package sudark2.Sudark.equipmentPro;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.*;

import static sudark2.Sudark.equipmentPro.EquipmentDisplay.*;
import static sudark2.Sudark.equipmentPro.EquipmentPro.bls;
import static sudark2.Sudark.equipmentPro.EquipmentPro.get;
import static sudark2.Sudark.equipmentPro.FileManager.getQQ;
import static sudark2.Sudark.equipmentPro.FileManager.hairMap;

public class DisplayListener implements Listener {

    static Map<String, Set<BlockDisplay>> PlayerHats = new HashMap<>();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player pl = e.getPlayer();
        String qq = getQQ(pl);
        if (PlayerHats.containsKey(qq)) {
            PlayerHats.get(qq).forEach(BlockDisplay::remove);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player pl = e.getPlayer();
        String qq = getQQ(pl);
        World nowWorld = pl.getWorld();
        if (PlayerHats.containsKey(qq)) {
            PlayerHats.get(qq).forEach(bd -> {
                if(!nowWorld.equals(bd.getWorld())){
                    bd.teleport(pl.getEyeLocation().subtract(0, 2 * p, 0).clone());
                    pl.hideEntity(get(), bd);
                    return;
                }
                bd.teleport(pl.getEyeLocation().subtract(0, 2 * p, 0).clone());
            });
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) throws NoSuchFieldException, IllegalAccessException {
        Player pl = e.getPlayer();
        String qq = getQQ(pl);

        if (qq == null) return;

        if (PlayerHats.containsKey(qq)) {
            Set<BlockDisplay> bds = spawn(pl.getEyeLocation().subtract(0, 2 * p, 0).clone(), getEffect(hairMap.get(qq)), pl);
            PlayerHats.put(qq, bds);
        }
    }

    public static Set<BlockDisplay> spawn(Location loc, Effect[] e, Player owner) {
        Set<BlockDisplay> spawned = new HashSet<>();
        for (Effect effect : e) {
            BlockDisplay bl = (BlockDisplay) loc.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);

            bl.setBlock(effect.getMaterial().createBlockData());
            bl.setTransformation(effect.getTransformation());

            bl.setTeleportDuration(1);
            bl.setInterpolationDuration(0);
            if (owner != null) owner.hideEntity(get(), bl);

            bls.add(bl);
            spawned.add(bl);
        }
        if (owner != null) owner.sendMessage("[§e头饰§f] 默认情况 你无法看见头饰");
        return spawned;
    }
}