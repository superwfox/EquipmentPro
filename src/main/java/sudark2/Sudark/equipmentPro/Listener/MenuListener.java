package sudark2.Sudark.equipmentPro.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

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
                    if (PlayerHats.containsKey(qq)) PlayerHats.get(qq).forEach(bd -> pl.showEntity(get(), bd));
                    else title(pl, "[§e未购买§f]", "§7请先购买头饰");
                }
                case NETHERITE_HELMET -> initPurchaseMenu(pl);
                case IRON_HELMET -> {
                    if (PlayerHats.containsKey(qq)) {
                        PlayerHats.get(qq).forEach(BlockDisplay::remove);
                        PlayerHats.remove(qq);
                        getData(qq).equipped = null;
                        title(pl, "[§e已卸下§f]", "§7头饰已卸下");
                    }
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
                clearPreviewDisplays(qq);
                if (owned) {
                    equipHat(qq, hatId, pl);
                    pl.closeInventory();
                    title(pl, "§e已装备", hatName);
                } else {
                    addHat(qq, hatId);
                    equipHat(qq, hatId, pl);
                    pl.closeInventory();
                    title(pl, "§e购买成功", hatName);
                    clearPreview(qq, hatId);
                }
                previewingHat.remove(qq);
            } else {
                pl.closeInventory();
                previewingHat.put(qq, hatId);

                try {
                    List<BlockDisplay> bds = spawnPreview(pl, hatId);
                    previewDisplays.put(qq, bds);

                    title(pl, "[§e预览头饰§f]", "§7低头即可" + (owned ? "装备" : "购买") + " | 抬头取消");
                    new BukkitRunnable() {
                        int timer = 0;

                        @Override
                        public void run() {
                            float pitch = pl.getPitch();
                            timer++;
                            if (pitch == 90) {
                                initPurchaseMenuWithConfirm(pl, hatId, owned);
                                cancel();
                                return;
                            }

                            if (pitch == -90 || timer >= 200) {
                                stop();
                                return;
                            }
                            pl.sendActionBar("§e》预览中《 §7[低头即可" + (owned ? "装备" : "购买") + " | 抬头取消]");
                        }

                        public void stop() {
                            pl.sendActionBar("§e");
                            clearPreview(qq, hatId);
                            this.cancel();
                        }

                    }.runTaskTimer(get(), 0, 10);
                } catch (Exception ex) {
                    title(pl, "§c错误", "§7无法预览");
                }
            }
        }
    }

    public void clearPreview(String qq, String hatId) {
        if (previewingHat.containsKey(qq) && previewingHat.get(qq).equals(hatId)) {
            previewingHat.remove(qq);
            clearPreviewDisplays(qq);
        }
    }

    private void clearPreviewDisplays(String qq) {
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
