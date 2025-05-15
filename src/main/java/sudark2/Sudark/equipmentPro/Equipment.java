package sudark2.Sudark.equipmentPro;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.List;

import static sudark2.Sudark.equipmentPro.EquipmentPro.get;

public class Equipment implements Listener {

    static String[] styles = {"obsidian"};

    @EventHandler
    public void onPlayerJoin(PlayerArmorChangeEvent e) {
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
            boolean h = false, c = false, l = false, b = false;

            if (helmet != null && check(helmet, style)) h = true;
            if (chestplate != null && check(chestplate, style)) c = true;
            if (leggings != null && check(leggings, style)) l = true;
            if (boots != null && check(boots, style)) b = true;

            if (h || c || l || b) pl.setMetadata(style, new FixedMetadataValue(get(), List.of(h, c, l, b)));
        }

    }

    public static boolean check(ItemStack item, String style) {
        return item.getLore().stream().anyMatch(s -> s.equals(style));
    }

}


