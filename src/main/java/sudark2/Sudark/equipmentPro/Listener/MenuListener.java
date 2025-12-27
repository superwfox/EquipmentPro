package sudark2.Sudark.equipmentPro.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static sudark2.Sudark.equipmentPro.EquipmentPro.*;
import static sudark2.Sudark.equipmentPro.File.FileManager.*;
import static sudark2.Sudark.equipmentPro.Menu.Menu.*;
import static sudark2.Sudark.equipmentPro.Utils.EffectUtils.spawnPreview;
import static sudark2.Sudark.equipmentPro.Utils.TitleUtil.title;

public class MenuListener implements Listener {

    public static Map<String, String> previewingHat = new HashMap<>();
    public static Map<String, List<BlockDisplay>> previewDisplays = new HashMap<>();

    @EventHandler
    public void onMenu(InventoryClickEvent e) {
        String menuName = e.getView().getTitle();
        Player pl = (Player) e.getWhoClicked();
        String qq = getQQ(pl);

        if (menuName.equals(" 头饰 | §lEquipmentPro")) {
            ItemStack item = e.getCurrentItem();
            if (item == null) return;
            e.setCancelled(true);
            pl.closeInventory();

            switch (item.getType()) {
                case GOLDEN_HELMET -> {
                    if (PlayerHats.containsKey(qq))
                        PlayerHats.get(qq).forEach(bd -> pl.showEntity(get(), bd));
                    else title(pl, "[§e未购买§f]", "§7请先购买头饰");
                }
                case NETHERITE_HELMET -> initPurchaseMenu(pl);
                case IRON_HELMET -> {
                    if (PlayerHats.containsKey(qq))
                        PlayerHats.get(qq).forEach(bd -> pl.hideEntity(get(), bd));
                    else title(pl, "[§e未购买§f]", "§7请先购买头饰");
                }
            }
        }

        if (menuName.equals(" 选择头饰 | §lEquipmentPro")) {
            ItemStack item = e.getCurrentItem();
            if (item == null) return;
            e.setCancelled(true);

            int slot = e.getSlot();
            if (slot >= HATS.length) return;

            String hatId = HATS[slot][0];
            String hatName = HATS[slot][1];
            boolean owned = hasHat(qq, hatId);

            if (previewingHat.containsKey(qq) && previewingHat.get(qq).equals(hatId)) {
                if (owned) {
                    equipHat(qq, hatId);
                    pl.closeInventory();
                    title(pl, "§e已装备", hatName);
                } else {
                    addHat(qq, hatId);
                    equipHat(qq, hatId);
                    pl.closeInventory();
                    title(pl, "§e购买成功", hatName);
                }
                clearPreview(qq);
                previewingHat.remove(qq);
            } else {
                clearPreview(qq);
                pl.closeInventory();
                previewingHat.put(qq, hatId);

                try {
                    List<BlockDisplay> bds = spawnPreview(pl, hatId);
                    previewDisplays.put(qq, bds);

                    Bukkit.getScheduler().runTaskLater(get(), () -> {
                        if (previewingHat.containsKey(qq) && previewingHat.get(qq).equals(hatId)) {
                            clearPreview(qq);
                            previewingHat.remove(qq);
                        }
                    }, 600L);

                    title(pl, "§e预览中", "§7点击完成" + (owned ? "装备" : "购买"));
                    Bukkit.getScheduler().runTaskLater(get(), () -> {
                        initPurchaseMenuWithConfirm(pl, hatId, owned);
                    }, 20L);
                } catch (Exception ex) {
                    title(pl, "§c错误", "§7无法预览");
                }
            }
        }
    }

    private void clearPreview(String qq) {
        if (previewDisplays.containsKey(qq)) {
            previewDisplays.get(qq).forEach(BlockDisplay::remove);
            previewDisplays.remove(qq);
        }
    }

    public static void initPurchaseMenuWithConfirm(Player pl, String confirmHat, boolean owned) {
        var inv = Bukkit.createInventory(null, 54, " 选择头饰 | §lEquipmentPro");
        String qq = getQQ(pl);

        for (int i = 0; i < HATS.length; i++) {
            String hatId = HATS[i][0];
            String hatName = HATS[i][1];
            var mat = org.bukkit.Material.valueOf(HATS[i][2]);
            boolean hasIt = hasHat(qq, hatId);

            ItemStack item = new ItemStack(mat);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e" + hatName);

            if (hatId.equals(confirmHat)) {
                meta.setLore(List.of("§7点击完成" + (owned ? "装备" : "购买")));
            } else if (hasIt) {
                meta.addEnchant(org.bukkit.enchantments.Enchantment.MENDING, 1, true);
                meta.addItemFlags(org.bukkit.inventory.ItemFlag.HIDE_ENCHANTS);
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
