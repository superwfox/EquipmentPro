package sudark2.Sudark.equipmentPro;

import org.bukkit.Location;
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
import static sudark2.Sudark.equipmentPro.FileManager.getQQ;

public class DisplayListener implements Listener {

    static Map<String, Set<BlockDisplay>> PlayerHats = new HashMap<>();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player pl = e.getPlayer();
        String qq = getQQ(pl);
        if (PlayerHats.containsKey(qq)) {
            PlayerHats.get(pl).forEach(BlockDisplay::remove);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player pl = e.getPlayer();
        if (PlayerHats.containsKey(pl)) {
            PlayerHats.get(pl).forEach(bd -> {
                bd.teleport(pl.getEyeLocation().subtract(0, 2 * p, 0).clone());
            });
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player pl = e.getPlayer();
        String qq = getQQ(pl);

        if(qq == null)return;




    }

    public static Set<BlockDisplay> spawn(Location loc, Effect[] e) {
        Set<BlockDisplay> spawned = new HashSet<>();
        for (Effect effect : e) {
            BlockDisplay bl = (BlockDisplay) loc.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);

            bl.setBlock(effect.getMaterial().createBlockData());
            bl.setTransformation(effect.getTransformation());

            bl.setTeleportDuration(0);
            bl.setInterpolationDuration(0);

            bls.add(bl);
            spawned.add(bl);
        }
        return spawned;
    }
}
