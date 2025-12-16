package sudark2.Sudark.equipmentPro.Utils;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static sudark2.Sudark.equipmentPro.EquipmentPro.get;

public class TitleUtil {

    public static void title(Player pl, String t1, String t2) {
        new BukkitRunnable() {
            StringBuilder temt = new StringBuilder("§7_");
            int i = 0;

            @Override
            public void run() {
                temt.append(t2.toCharArray()[i]);
                pl.sendTitle(t1, temt + "§7_", 0, 50, 20);
                i++;
                if (i == t2.length()) {
                    cancel();
                }
            }
        }.runTaskTimer(get(), 0, 2L);
    }

}
