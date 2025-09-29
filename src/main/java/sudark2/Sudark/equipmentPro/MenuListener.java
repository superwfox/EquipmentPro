package sudark2.Sudark.equipmentPro;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static sudark2.Sudark.equipmentPro.DisplayListener.PlayerHats;
import static sudark2.Sudark.equipmentPro.EquipmentPro.get;
import static sudark2.Sudark.equipmentPro.FileManager.getQQ;
import static sudark2.Sudark.equipmentPro.Title.title;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenu(InventoryClickEvent e) {
        String menuName = e.getView().getTitle();

        if (menuName.equals(" 头饰 | §lEquipmentPro")) {

            ItemStack item = e.getCurrentItem();
            if (item == null) return;

            Player pl = (Player) e.getWhoClicked();
            String qq = getQQ(pl);
            pl.closeInventory();

            switch (item.getType()) {
                case GOLDEN_HELMET -> {
                    e.setCancelled(true);
                    if (PlayerHats.containsKey(qq))
                        PlayerHats.get(qq).forEach(blockDisplay -> {
                            pl.showEntity(get(), blockDisplay);
                        });
                    else {
                        title(pl, "[§e未购买§f]", "§7请先购买头饰");
                    }
                }
                case NETHERITE_HELMET -> {
                    e.setCancelled(true);
                    pl.teleport(new Location(Bukkit.getWorld("BEEF-Main"), 10.5, -9, 300.5));
                }
                case IRON_HELMET -> {
                    e.setCancelled(true);
                    if (PlayerHats.containsKey(qq))
                        PlayerHats.get(qq).forEach(blockDisplay ->
                                pl.hideEntity(get(), blockDisplay)
                        );
                    else {
                        title(pl, "[§e未购买§f]", "§7请先购买头饰");
                    }
                }
            }

        }
    }
}
