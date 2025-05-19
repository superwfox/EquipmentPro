package sudark2.Sudark.equipmentPro;

import org.bukkit.Material;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class EquipmentDisplay {

    static float p = 0.125f;
    static Transformation normal = new Transformation(
            new Vector3f(0, 0, 0),            // 平移（translation）向量
            new Quaternionf(),               // 旋转（rotation），默认不旋转
            new Vector3f(p, p, p), // 缩放（scale）到 1/8
            new Quaternionf()                // 旋转中心点（leftRotation），默认不旋转
    );

    //龙头
    static Effect[] obsidianH = {
            new Effect(Material.OBSIDIAN, cloneWithLoc(p, 4 * p, 0)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScale(cloneWithLoc(p, 5 * p, 0), p, 2 * p, p)),
            new Effect(Material.OBSIDIAN, cloneWithScale(cloneWithLoc(2 * p, 6 * p, -1 * p), p, 3 * p, p)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScale(cloneWithLoc(2 * p, 9 * p, -1 * p), 2 * p, p, p)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScale(cloneWithLoc(p, 8 * p, -1 * p), p, p, p)),

            new Effect(Material.OBSIDIAN, cloneWithLoc(-2 * p, 4 * p, 0)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScale(cloneWithLoc(-2 * p, 5 * p, 0), p, 2 * p, p)),
            new Effect(Material.OBSIDIAN, cloneWithScale(cloneWithLoc(-3 * p, 6 * p, -1 * p), p, 3 * p, p)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScale(cloneWithLoc(-4 * p, 9 * p, -1 * p), 2 * p, p, p)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScale(cloneWithLoc(-2 * p, 8 * p, -1 * p), p, p, p)),
    };

    static Effect[] obsidianC = {

    };

    static Effect[] obsidianL = {

    };
    static Effect[] obsidianB = {

    };

    //鹿角
    static Effect[] wildH = {
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(p, 4 * p, 0), p, 2 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(2 * p, 5 * p, 0), 2 * p, 2 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(4 * p, 6 * p, 0), p, 2 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(2 * p, 7 * p, 0), p, 3 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLoc(p, 8 * p, 0)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLoc(3 * p, 9 * p, 0)),

            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(-2 * p, 4 * p, 0), p, 2 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(-4 * p, 5 * p, 0), 2 * p, 2 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(-6 * p, 6 * p, 0), p, 2 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScale(cloneWithLoc(-4 * p, 7 * p, 0), p, 3 * p, p)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLoc(-3 * p, 8 * p, 0)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLoc(-5 * p, 9 * p, 0)),
    };
    static Effect[] wildC = {

    };
    static Effect[] wildL = {

    };
    static Effect[] wildB = {

    };


    public static Transformation cloneWithScale(Transformation transformation, float sx, float sy, float sz) {
        return new Transformation(
                new Vector3f(transformation.getTranslation()), // 拷贝 translation
                new Quaternionf(transformation.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(sx, sy, sz),                      // 替换 scale
                new Quaternionf()
        );
    }

    public static Transformation cloneWithLoc(float x, float y, float z) {
        return new Transformation(
                new Vector3f(new Vector3f(x, y, z)), // 拷贝 translation
                new Quaternionf(normal.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(normal.getScale()),                      // 替换 scale
                new Quaternionf()
        );
    }


}
