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
import java.util.*;

import static org.bukkit.Bukkit.getLogger;

public class FileManager {

    public static Map<String, PlayerData> dataMap = new HashMap<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static File fileFolder = Bukkit.getPluginManager().getPlugin("EquipmentPro").getDataFolder();
    private static final File dataFile = new File(fileFolder, "data.json");

    public static class PlayerData {
        public Set<String> owned = new HashSet<>();
        public String equipped = null;
    }

    public static void checkFile() {
        if (!fileFolder.exists()) fileFolder.mkdirs();
    }

    public static void save() {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(dataFile), StandardCharsets.UTF_8)) {
            gson.toJson(dataMap, writer);
        } catch (IOException e) {
            getLogger().warning("保存头饰数据失败: " + e.getMessage());
        }
    }

    public static void load() {
        if (!dataFile.exists()) {
            dataMap = new HashMap<>();
            return;
        }
        try (Reader reader = new FileReader(dataFile)) {
            Type type = new TypeToken<Map<String, PlayerData>>() {}.getType();
            dataMap = gson.fromJson(reader, type);
            if (dataMap == null) dataMap = new HashMap<>();
        } catch (IOException e) {
            dataMap = new HashMap<>();
        }
    }

    public static PlayerData getData(String qq) {
        return dataMap.computeIfAbsent(qq, k -> new PlayerData());
    }

    public static boolean hasHat(String qq, String hatName) {
        PlayerData data = dataMap.get(qq);
        return data != null && data.owned.contains(hatName);
    }

    public static void addHat(String qq, String hatName) {
        getData(qq).owned.add(hatName);
        save();
    }

    public static void equipHat(String qq, String hatName) {
        getData(qq).equipped = hatName;
        save();
    }

    public static String getEquipped(String qq) {
        PlayerData data = dataMap.get(qq);
        return data != null ? data.equipped : null;
    }

    public static String getQQ(Player pl) {
        NamespacedKey key = new NamespacedKey("sudark", "qq");
        return pl.getPersistentDataContainer().get(key, PersistentDataType.STRING);
    }
}
