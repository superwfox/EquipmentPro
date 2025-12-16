package sudark2.Sudark.equipmentPro.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static sudark2.Sudark.equipmentPro.EquipmentPro.get;
import static sudark2.Sudark.equipmentPro.File.FileManager.getQQ;
import static sudark2.Sudark.equipmentPro.Menu.Menu.initMenu;
import static sudark2.Sudark.equipmentPro.Utils.EffectUtils.PlayerHats;
import static sudark2.Sudark.equipmentPro.Utils.TitleUtil.title;

public class MenuListener implements Listener {
    @EventHandler
    public void onMenu(InventoryClickEvent e) {
        String menuName = e.getView().getTitle();

        if (menuName.equals(" 头饰 | §lEquipmentPro")) {

            ItemStack item = e.getCurrentItem();
            if (item == null) return;

            Player pl = (Player) e.getWhoClicked();
            String qq = getQQ(pl);
            e.setCancelled(true);
            pl.closeInventory();

            switch (item.getType()) {

                case GOLDEN_HELMET -> {
                    if (PlayerHats.containsKey(qq))
                        PlayerHats.get(qq).forEach(blockDisplay -> {
                            pl.showEntity(get(), blockDisplay);
                        });
                    else {
                        title(pl, "[§e未购买§f]", "§7请先购买头饰");
                    }
                }

                case NETHERITE_HELMET -> {
                    initMenu(pl);
                }

                case IRON_HELMET -> {
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
