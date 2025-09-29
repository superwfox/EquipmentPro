package sudark2.Sudark.equipmentPro;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static sudark2.Sudark.equipmentPro.DisplayListener.PlayerHats;
import static sudark2.Sudark.equipmentPro.DisplayListener.spawn;
import static sudark2.Sudark.equipmentPro.EquipmentDisplay.getEffect;
import static sudark2.Sudark.equipmentPro.EquipmentDisplay.p;
import static sudark2.Sudark.equipmentPro.FileManager.getQQ;
import static sudark2.Sudark.equipmentPro.FileManager.hairMap;
import static sudark2.Sudark.equipmentPro.Title.title;

public class CommandHander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof BlockCommandSender bl)) return true;

        Player pl = bl.getBlock().getLocation().getNearbyPlayers(6).stream().findFirst().orElse(null);
        if (pl == null) return true;

        ItemStack item = pl.getInventory().getItemInMainHand();
        String operation = args[0];
        String style = args[1];

        switch (operation) {
            case "show" -> {
                Location loc = bl.getBlock().getLocation().add(-1.5, 3, 0.5).addRotation(-90, 0);
                loc.getNearbyEntities(2, 2, 2).forEach(entity -> {
                    if (entity instanceof BlockDisplay bd) bd.remove();
                });

                try {
                    spawn(loc, getEffect(style));
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            case "give" -> {
                int price = Integer.parseInt(args[2]);
                int own = pl.getLevel();

                if (own < price) {
                    title(pl, "[§e购买失败§f]", "§7你的等级不足");
                    pl.playSound(pl, Sound.ENTITY_VILLAGER_NO, 1, 1);
                    return true;
                } else {
                    try {
                        bought(pl, style, price);
                    } catch (NoSuchFieldException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }

                hairMap.put(getQQ(pl), style);
                FileManager.save();

            }
            case "clear" -> {
                hairMap.remove(getQQ(pl));
                FileManager.save();
            }
            case "showUp" -> {

            }
        }

        return true;
    }

    private static void bought(Player pl, String style, int price) throws NoSuchFieldException, IllegalAccessException {
        String qq = getQQ(pl);
        pl.giveExpLevels(-price);
        title(pl, "[§e成功购买§f]", "§7现在你拥有头饰 §b§l" + style);

        new BukkitRunnable() {
            int turn = 0;

            @Override
            public void run() {
                pl.getWorld().spawnParticle(Particle.ENCHANT, pl.getLocation(), 10, 0.2, 0.2, 0.2, 0.1);
                turn++;
                if (turn == 30) {
                    cancel();
                }
            }
        }.runTaskTimer(EquipmentPro.get(), 0, 2);

        PlayerHats.put(qq, spawn(pl.getEyeLocation().add(0, 2 * p, 0), getEffect(style)));
    }
}

