package sudark2.Sudark.equipmentPro.Listener;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static sudark2.Sudark.equipmentPro.EquipmentPro.get;
import static sudark2.Sudark.equipmentPro.File.FileManager.getQQ;
import static sudark2.Sudark.equipmentPro.Utils.EffectUtils.*;

public class DisplayListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player pl = e.getPlayer();
        unloadEffectsForPlayer(pl);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player pl = e.getPlayer();
        String qq = getQQ(pl);
        World nowWorld = pl.getWorld();
        if (PlayerHats.containsKey(qq)) {
            PlayerHats.get(qq).forEach(bd -> {
                if (!nowWorld.equals(bd.getWorld())) {
                    bd.teleport(pl.getEyeLocation().subtract(0, 0.25, 0).clone());
                    pl.hideEntity(get(), bd);
                    return;
                }
                bd.teleport(pl.getEyeLocation().subtract(0, 0.25, 0).clone());
            });
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) throws NoSuchFieldException, IllegalAccessException {
        Player pl = e.getPlayer();
        loadEffectsForPlayer(pl);
    }

}