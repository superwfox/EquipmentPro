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

    static String[] styles = {
            "obsidian",
            "wild",
            "wildG",
            "tinyAntler",
            "warden",
            "angel",
            "god",
            "catBlack",
            "crown",
            "hugeCrown",
            "hugeCrown2",
    };

    //龙头
    static Effect[] obsidianH = {

            new Effect(Material.OBSIDIAN, cloneWithLocP(1, 4, 0)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScaleP(cloneWithLocP(1, 5, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, cloneWithScaleP(cloneWithLocP(2, 6, -1), 1, 3, 1)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScaleP(cloneWithLocP(2, 9, -2), 2, 1, 1)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScaleP(cloneWithLocP(1, 8, 1), 1, 1, 1)),

            new Effect(Material.OBSIDIAN, cloneWithLocP(-2, 4, 0)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScaleP(cloneWithLocP(-2, 5, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, cloneWithScaleP(cloneWithLocP(-3, 6, -1), 1, 3, 1)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScaleP(cloneWithLocP(-4, 9, -2), 2, 1, 1)),
            new Effect(Material.CRYING_OBSIDIAN, cloneWithScaleP(cloneWithLocP(-2, 8, 1), 1, 1, 1)),

    };

    static Effect[] obsidianC = {

    };

    static Effect[] obsidianL = {

    };
    static Effect[] obsidianB = {

    };

    //鹿角
    static Effect[] wildH = {
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(1, 4, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(2, 5, -1), 2, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(4, 6, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(2, 7, 0), 1, 3, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLocP(1, 8, 0)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLocP(3, 9, 1)),

            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-2, 4, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-4, 5, -1), 2, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-5, 6, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-3, 7, 0), 1, 3, 1)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLocP(-2, 8, 0)),
            new Effect(Material.BROWN_TERRACOTTA, cloneWithLocP(-4, 9, 1)),
    };

    static Effect[] wildC = {

    };
    static Effect[] wildL = {

    };
    static Effect[] wildB = {

    };

    //金鹿角
    static Effect[] wildGH = {
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(1, 4, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(2, 5, -1), 2, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(4, 6, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(2, 7, 0), 1, 3, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithLocP(1, 8, 0)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithLocP(3, 9, 1)),

            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(-2, 4, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(-4, 5, -1), 2, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(-5, 6, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(-3, 7, 0), 1, 3, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithLocP(-2, 8, 0)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, cloneWithLocP(-4, 9, 1)),
    };


    //小鹿角
    static Effect[] tinyAntler = {
            new Effect(Material.GILDED_BLACKSTONE, cloneWithScaleP(cloneWithLocP(1, 4, 0), 1, 2, 1)),
            new Effect(Material.GILDED_BLACKSTONE, cloneWithScaleP(cloneWithLocP(2, 5, -1), 1, 2, 1)),
            new Effect(Material.BLACKSTONE_WALL, cloneWithScaleP(cloneWithLocP(2, 7, -1), 1, 1, 1)),

            new Effect(Material.GILDED_BLACKSTONE, cloneWithScaleP(cloneWithLocP(-2, 4, 0), 1, 2, 1)),
            new Effect(Material.GILDED_BLACKSTONE, cloneWithScaleP(cloneWithLocP(-3, 5, -1), 1, 2, 1)),
            new Effect(Material.BLACKSTONE_WALL, cloneWithScaleP(cloneWithLocP(-3, 7, -1), 1, 1, 1)),
    };


    //监守者
    static Effect[] warden = {
            new Effect(Material.CYAN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(2, 2, -1), 2, 1, 1)),
            new Effect(Material.CYAN_TERRACOTTA, cloneWithLocP(3, 3, -1)),
            new Effect(Material.CYAN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(3, 4, -1), 2, 1, 1)),
            new Effect(Material.BLACK_TERRACOTTA, cloneWithScaleP(cloneWithLocP(4, 5, 0), 1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, cloneWithScaleP(cloneWithLocP(3, 6, 0), 1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, cloneWithScaleP(cloneWithLocP(1, 7, 0), 2, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(1, 8, 0), 1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(1, 6, 0), 1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(3, 8, 0), 1, 1, 1)),


            new Effect(Material.CYAN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-2, 2, -1), -2, 1, 1)),
            new Effect(Material.CYAN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-3, 3, -1), -1, 1, 1)),
            new Effect(Material.CYAN_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-3, 4, -1), -2, 1, 1)),
            new Effect(Material.BLACK_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-4, 5, 0), -1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-3, 6, 0), -1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, cloneWithScaleP(cloneWithLocP(-1, 7, 0), -2, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(-1, 8, 0), -1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(-1, 6, 0), -1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, cloneWithScaleP(cloneWithLocP(-3, 8, 0), -1, 1, 1)),
    };

    //天使
    static Effect[] angel = {
            new Effect(Material.GLOWSTONE, cloneWithScaleP(cloneWithLocP(2, 6, 1), -4, 1, 1)),
            new Effect(Material.GLOWSTONE, cloneWithScaleP(cloneWithLocP(2, 6, -2), -4, 1, 1)),
            new Effect(Material.GLOWSTONE, cloneWithScaleP(cloneWithLocP(-2, 6, 1), 1, 1, -2)),
            new Effect(Material.GLOWSTONE, cloneWithScaleP(cloneWithLocP(1, 6, 1), 1, 1, -2)),
    };

    //上帝
    static int ty = 6;
    static Effect[] god = {
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(4, ty, -2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(3, ty, -3), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(3, ty, -4), -2, 1, -1)),

            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(-3, ty, -2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(-2, ty, -3), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(-1, ty, -4), -2, 1, -1)),

            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(-3, ty, 2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(-2, ty, 2), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(-1, ty, 3), -2, 1, -1)),

            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(4, ty, 2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(3, ty, 2), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, cloneWithScaleP(cloneWithLocP(3, ty, 3), -2, 1, -1)),
    };

    //猫耳（黑/粉）
    static Effect[] catBlack = {
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 4, 1), 2, 1, 2)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(2, 3, 0), 1, 1, 2)),

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 4, 1), 2, 1, 2)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 3, 0), 1, 1, 2)),
    };

    static Effect[] crown = {

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-1, 4, -2), 2, 1, 4)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 4, -1), 4, 1, 2)),
            new Effect(Material.GOLD_BLOCK, cloneWithLocP(0, 5, -2)),
            new Effect(Material.GOLD_BLOCK, cloneWithLocP(-2, 5, -1)),
            new Effect(Material.GOLD_BLOCK, cloneWithLocP(1, 5, 0)),
            new Effect(Material.GOLD_BLOCK, cloneWithLocP(-1, 5, 1)),

    };

    static Effect[] hugeCrown = {

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 4, -2), 4, 1, 4)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(2, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 5, 2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(2, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 5, 2), 1, 2, 1)),

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 7, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 7, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 7, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 7, -2), 1, 2, 1)),

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-1, 7, -1), 2, 2, 2)),

    };

    static Effect[] hugeCrown2 = {

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 4, -2), 4, 1, 4)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(2, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 5, 2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(2, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 5, 2), 1, 2, 1)),

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(2, 6, 2), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(2, 6, -3), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 6, 2), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-3, 6, -3), 1, 1, 1)),

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 7, 1), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 7, -2), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-2, 7, 1), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(1, 7, -2), 1, 1, 1)),

            new Effect(Material.GOLD_BLOCK, cloneWithScaleP(cloneWithLocP(-1, 7, -1), 2, 1, 2)),

            new Effect(Material.HONEY_BLOCK, cloneWithScaleP(cloneWithLocP(-1, 5, -1), 2, 2, 2)),
    };


    public static Transformation cloneWithScale(Transformation transformation, float sx, float sy, float sz) {
        return new Transformation(
                new Vector3f(transformation.getTranslation()), // 拷贝 translation
                new Quaternionf(transformation.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(sx, sy, sz),                      // 替换 scale
                new Quaternionf()
        );
    }

    public static Transformation cloneWithScaleP(Transformation transformation, float sx, float sy, float sz) {
        return new Transformation(
                new Vector3f(transformation.getTranslation()), // 拷贝 translation
                new Quaternionf(transformation.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(sx * p, sy * p, sz * p),                      // 替换 scale
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

    public static Transformation cloneWithLocP(float x, float y, float z) {
        return new Transformation(
                new Vector3f(new Vector3f(x * p, y * p, z * p)), // 拷贝 translation
                new Quaternionf(normal.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(normal.getScale()),                      // 替换 scale
                new Quaternionf()
        );
    }

}
