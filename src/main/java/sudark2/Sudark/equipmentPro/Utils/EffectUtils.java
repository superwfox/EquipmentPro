package sudark2.Sudark.equipmentPro.Utils;

import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import sudark2.Sudark.equipmentPro.EffectBasic.Effect;
import sudark2.Sudark.equipmentPro.File.FileManager;

import java.util.*;

import static sudark2.Sudark.equipmentPro.EffectBasic.EquipmentDisplay.getEffect;
import static sudark2.Sudark.equipmentPro.EquipmentPro.BLS;
import static sudark2.Sudark.equipmentPro.EquipmentPro.get;
import static sudark2.Sudark.equipmentPro.File.FileManager.getQQ;
import static sudark2.Sudark.equipmentPro.File.FileManager.hairMap;

public class EffectUtils {

    public static Map<String, List<BlockDisplay>> PlayerHats = new HashMap<>();

    public static List<BlockDisplay> spawn(Location loc, Effect[] e, Player owner) {
        List<BlockDisplay> spawned = new ArrayList<>();
        for (Effect effect : e) {
            BlockDisplay bl = (BlockDisplay) loc.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);

            bl.setBlock(effect.getMaterial().createBlockData());
            bl.setTransformation(effect.getTransformation());

            bl.setTeleportDuration(1);
            bl.setInterpolationDuration(0);
            if (owner != null) owner.hideEntity(get(), bl);

            BLS.add(bl);
            spawned.add(bl);
        }
        if (owner != null) owner.sendMessage("[§e头饰§f] 默认情况 你无法看见头饰");
        return spawned;
    }

    public static void loadEffectsForPlayer(Player pl) throws NoSuchFieldException, IllegalAccessException {
        String qq = getQQ(pl);
        if (qq == null) return;

        Effect[] effect = getEffect(hairMap.get(qq));
        List<BlockDisplay> bds = spawn(pl.getEyeLocation().subtract(0, 2 * effect[0].getScale(), 0).clone(), effect, pl);
        PlayerHats.put(qq, bds);
    }

    public static void unloadEffectsForPlayer(Player pl) {
        String qq = getQQ(pl);
        if (qq == null) return;
        PlayerHats.get(qq).forEach(BlockDisplay::remove);
        PlayerHats.remove(qq);
    }

    public static void deleteHat(Player pl) {
        String qq = getQQ(pl);
        if (PlayerHats.containsKey(qq)) PlayerHats.get(qq).forEach(BlockDisplay::remove);
        hairMap.remove(qq);
        PlayerHats.remove(qq);
        FileManager.save();
    }
}
