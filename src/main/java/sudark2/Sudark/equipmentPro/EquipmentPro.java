package sudark2.Sudark.equipmentPro;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class EquipmentPro extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new Equipment(), this);
        Bukkit.getPluginManager().registerEvents(new Display(), this);

    }

    public static Plugin get(){
        return Bukkit.getPluginManager().getPlugin("EquipmentPro");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
