package sudark2.Sudark.equipmentPro.Menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static sudark2.Sudark.equipmentPro.Utils.ItemNameUtil.name;

public class Menu {

    public static void initMenu(Player pl) {
        Inventory inv = Bukkit.createInventory(null, 9, " 头饰 | §lEquipmentPro");
        inv.setItem(3, name(Material.GOLDEN_HELMET, "§b显示头饰", "§7让自己能看见头饰"));
        inv.setItem(4, name(Material.NETHERITE_HELMET, "§e购买头饰", "§7点击购买头饰"));
        inv.setItem(5, name(Material.IRON_HELMET, "§f卸载头饰", "§7使自己无法看见头饰"));
        pl.openInventory(inv);
    }
}
