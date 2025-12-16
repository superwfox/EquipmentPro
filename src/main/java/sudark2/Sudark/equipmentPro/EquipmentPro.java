package sudark2.Sudark.equipmentPro;

import org.bukkit.Bukkit;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import sudark2.Sudark.equipmentPro.Command.CommandHander;
import sudark2.Sudark.equipmentPro.File.FileManager;
import sudark2.Sudark.equipmentPro.Listener.DisplayListener;
import sudark2.Sudark.equipmentPro.Listener.MenuListener;

import java.util.HashSet;
import java.util.Set;

public final class EquipmentPro extends JavaPlugin {

    public static Set<BlockDisplay> BLS = new HashSet<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new DisplayListener(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);

        Bukkit.getPluginCommand("EquipmentPro").setExecutor(new CommandHander());

        FileManager.checkFile();
        FileManager.load();


    }

    public static Plugin get() {
        return Bukkit.getPluginManager().getPlugin("EquipmentPro");
    }

    @Override
    public void onDisable() {
        BLS.forEach(BlockDisplay::remove);
    }
}
