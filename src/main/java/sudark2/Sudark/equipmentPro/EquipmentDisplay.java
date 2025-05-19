package sudark2.Sudark.equipmentPro;

import org.bukkit.Material;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class EquipmentDisplay {


    static Transformation normal = new Transformation(
            new Vector3f(0, 0, 0),            // 平移（translation）向量
            new Quaternionf(),               // 旋转（rotation），默认不旋转
            new Vector3f(0.125f, 0.125f, 0.125f), // 缩放（scale）到 1/8
            new Quaternionf()                // 旋转中心点（leftRotation），默认不旋转
    );

    static Effect[] obsidianH = {
            new Effect(Material.OBSIDIAN, normal, 0.0f, 0.0f, 0.0f),
            new Effect(Material.OBSIDIAN, normal, 0.3f, 0.3f, 0.3f)
    };

    static Effect[] obsidianC = {

    };

    static Effect[] obsidianL = {

    };
    static Effect[] obsidianB = {

    };
}
