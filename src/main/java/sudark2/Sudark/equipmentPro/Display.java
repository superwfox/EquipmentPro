package sudark2.Sudark.equipmentPro;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class Display implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player pl = e.getPlayer();

        for (String style : Equipment.styles) {

            if (!pl.hasMetadata(style)) continue;

            int turn = 0;
            for (boolean bl : (List<Boolean>) pl.getMetadata(style).get(0)) {
                turn ++;

                if(bl){
                    show(pl, style, turn);
                }


            }

        }

    }


}
