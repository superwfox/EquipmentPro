package sudark2.Sudark.equipmentPro.Menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import static sudark2.Sudark.equipmentPro.File.FileManager.*;
import static sudark2.Sudark.equipmentPro.Utils.ItemNameUtil.name;

public class Menu {

    public static final String[][] HATS = {
            {"obsidian", "龙角", "OBSIDIAN", "0"},
            {"wild", "鹿角", "BROWN_TERRACOTTA", "0"},
            {"wildG", "金鹿角", "YELLOW_CONCRETE_POWDER", "0"},
            {"wildO", "黑鹿角", "OBSIDIAN", "0"},
            {"tinyAntler", "小鹿角", "GILDED_BLACKSTONE", "0"},
            {"warden", "监守者", "CYAN_TERRACOTTA", "0"},
            {"angel", "天使", "GLOWSTONE", "0"},
            {"god", "上帝", "OCHRE_FROGLIGHT", "0"},
            {"catBlack", "猫耳", "GOLD_BLOCK", "0"},
            {"crown", "皇冠", "GOLD_BLOCK", "0"},
            {"hugeCrown", "大皇冠", "GOLD_BLOCK", "0"},
            {"hugeCrown2", "华丽皇冠", "HONEY_BLOCK", "0"},
            {"Dragon", "邱邱王", "BLACK_TERRACOTTA", "0"},
            {"Tiger", "虎", "SMOOTH_QUARTZ", "0"},
            {"cyanLoong", "青龙", "DARK_PRISMARINE", "0"},
            {"darkLoong", "暗龙", "DRAGON_HEAD", "0"},
    };

    public static void initMenu(Player pl) {
        Inventory inv = Bukkit.createInventory(null, 9, " 头饰 | §lEquipmentPro");
        inv.setItem(3, name(Material.GOLDEN_HELMET, "§b显示头饰", "§7让自己能看见头饰"));
        inv.setItem(4, name(Material.NETHERITE_HELMET, "§e选择头饰", "§7点击选择头饰"));
        inv.setItem(5, name(Material.IRON_HELMET, "§f卸载头饰", "§7使自己无法看见头饰"));
        pl.openInventory(inv);
    }

    public static void initPurchaseMenu(Player pl) {
        Inventory inv = Bukkit.createInventory(null, 54, " 选择头饰 | §lEquipmentPro");
        String qq = getQQ(pl);

        for (int i = 0; i < HATS.length; i++) {
            String hatId = HATS[i][0];
            String hatName = HATS[i][1];
            Material mat = Material.valueOf(HATS[i][2]);
            boolean owned = hasHat(qq, hatId);

            ItemStack item = new ItemStack(mat);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e" + hatName);

            if (owned) {
                meta.addEnchant(Enchantment.MENDING, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.setLore(List.of("§e[已拥有]", "§7左键进行详细展示"));
            } else {
                meta.setLore(List.of("§e[购买: §b" + HATS[i][3] + "§e]", "§7左键进行详细展示"));
            }
            item.setItemMeta(meta);
            inv.setItem(i, item);
        }
        pl.openInventory(inv);
    }
}
