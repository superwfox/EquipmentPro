package sudark2.Sudark.equipmentPro;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import static sudark2.Sudark.equipmentPro.EquipmentPro.get;

public class checkEquipment implements Listener {

    static String[] styles = {
            "obsidian"
    };

    @EventHandler
    public void onPlayerJoin(PlayerArmorChangeEvent e) {
        e.getPlayer().getMetadata("EP").clear();
        Armor(e.getPlayer());
    }

    public static void Armor(Player pl) {
        EntityEquipment equipment = pl.getEquipment();

        ItemStack helmet = equipment.getHelmet();
        ItemStack chestplate = equipment.getChestplate();
        ItemStack leggings = equipment.getLeggings();
        ItemStack boots = equipment.getBoots();

        for (String style : styles) {

            pl.removeMetadata(style, get());
            int h = 0, c = 0, l = 0, b = 0;

            if (helmet != null && check(helmet, style)) h = 1;
            if (chestplate != null && check(chestplate, style)) c = 1;
            if (leggings != null && check(leggings, style)) l = 1;
            if (boots != null && check(boots, style)) b = 1;

            if (h + c + l + b > 0)
                pl.setMetadata(style, new FixedMetadataValue(get(), h + "," + c + "," + l + "," + b));
        }

    }

    public static boolean check(ItemStack item, String style) {
        return item.getLore().stream().anyMatch(s -> s.equals(style));
    }

}


