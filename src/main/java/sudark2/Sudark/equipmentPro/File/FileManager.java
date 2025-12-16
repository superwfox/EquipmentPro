package sudark2.Sudark.equipmentPro.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getLogger;

public class FileManager {

    public static Map<String, String> hairMap = new HashMap<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static File fileFolder = Bukkit.getPluginManager().getPlugin("EquipmentPro").getDataFolder();
    private static final File dataFile = new File(fileFolder, "data.json");

    public static void checkFile() {
        if (!fileFolder.exists()) fileFolder.mkdirs();
    }

    public static void save() {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(dataFile), StandardCharsets.UTF_8)) {
            gson.toJson(hairMap, writer);
        } catch (IOException e) {
            getLogger().warning("保存头饰数据失败: " + e.getMessage());
        }
    }


    public static Map<String, String> load() {
        try (Reader reader = new FileReader(dataFile)) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>(); // 出错时返回空 Map
        }
    }


    public static String getQQ(Player pl) {
        NamespacedKey key = new NamespacedKey("sudark", "qq");
        return pl.getPersistentDataContainer().get(key, PersistentDataType.STRING);
    }
}
