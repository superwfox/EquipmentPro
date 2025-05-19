package sudark2.Sudark.equipmentPro;

import org.bukkit.Bukkit;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class EquipmentPro extends JavaPlugin {

    static Set<BlockDisplay> bls = new HashSet<>();

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new checkEquipment(), this);
        Bukkit.getPluginManager().registerEvents(new Display(), this);

        Bukkit.getPluginCommand("EquipmentPro").setExecutor(new CommandHander());

    }

    public static Plugin get(){
        return Bukkit.getPluginManager().getPlugin("EquipmentPro");
    }

    @Override
    public void onDisable() {
        bls.forEach(BlockDisplay::remove);
    }
}
