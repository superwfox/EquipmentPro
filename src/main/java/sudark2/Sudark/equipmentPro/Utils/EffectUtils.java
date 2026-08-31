package sudark2.Sudark.equipmentPro.Utils;

import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import sudark2.Sudark.equipmentPro.EffectBasic.Effect;
import sudark2.Sudark.equipmentPro.File.FileManager;

import java.util.*;

import static sudark2.Sudark.equipmentPro.EffectBasic.EquipmentDisplay.getEffect;
import static sudark2.Sudark.equipmentPro.EquipmentPro.*;
import static sudark2.Sudark.equipmentPro.File.FileManager.*;

public class EffectUtils {

    public static List<BlockDisplay> spawn(Location loc, Effect[] e, Player owner, float scaleMult) {
        List<BlockDisplay> spawned = new ArrayList<>();
        for (Effect effect : e) {
            BlockDisplay bl = (BlockDisplay) loc.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);
            bl.setBlock(effect.getMaterial().createBlockData());
            if (scaleMult == 1f) {
                bl.setTransformation(effect.getTransformation());
            } else {
                var t = effect.getTransformation();
                var trans = new org.joml.Vector3f(t.getTranslation()).mul(scaleMult);
                var scale = new org.joml.Vector3f(t.getScale()).mul(scaleMult);
                bl.setTransformation(new org.bukkit.util.Transformation(trans, t.getLeftRotation(), scale, t.getRightRotation()));
            }
            bl.setTeleportDuration(1);
            bl.setInterpolationDuration(0);
            if (owner != null) owner.hideEntity(get(), bl);
            BLS.add(bl);
            spawned.add(bl);
        }
        if (owner != null) owner.sendMessage("[§e头饰§f] 默认情况 你无法看见头饰");
        return spawned;
    }

    public static List<BlockDisplay> spawnPreview(Player pl, String hatId) {
        Effect[] effect = getEffect(hatId);
        Location loc = pl.getLocation().add(pl.getLocation().getDirection().multiply(0.6));
        loc.setY(pl.getEyeLocation().getY() - 4 * effect[0].getScale());
        loc.setPitch(0);
        return spawn(loc, effect, null, 2f);
    }

    public static void loadEffectsForPlayer(Player pl) {
        String qq = getQQ(pl);
        if (qq == null) return;
        String equipped = getEquipped(qq);
        if (equipped == null) return;

        Effect[] effects = getEffect(equipped);
        List<BlockDisplay> bds = spawn(pl.getEyeLocation().clone().subtract(0, 0.25, 0), effects, pl, 1f);
        PlayerHats.put(qq, bds);
    }

    public static void unloadEffectsForPlayer(Player pl) {
        String qq = getQQ(pl);
        if (qq == null) return;
        if (PlayerHats.containsKey(qq)) {
            PlayerHats.get(qq).forEach(BlockDisplay::remove);
            PlayerHats.remove(qq);
        }
    }

    public static void deleteHat(Player pl) {
        String qq = getQQ(pl);
        if (PlayerHats.containsKey(qq)) PlayerHats.get(qq).forEach(BlockDisplay::remove);
        getData(qq).equipped = null;
        PlayerHats.remove(qq);
        FileManager.save();
    }
}
