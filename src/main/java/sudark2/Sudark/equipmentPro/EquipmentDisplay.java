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
    static float hp = 0.0625f;
    static Transformation half = new Transformation(
            new Vector3f(0, 0, 0),            // 平移（translation）向量
            new Quaternionf(),               // 旋转（rotation），默认不旋转
            new Vector3f(hp, hp, hp), // 缩放（scale）到 1/8
            new Quaternionf()                // 旋转中心点（leftRotation），默认不旋转
    );


    public static Effect[] getEffect(String style) throws NoSuchFieldException, IllegalAccessException {
        return (Effect[]) EquipmentDisplay.class.getDeclaredField(style).get(null);
    }

    //龙头
    static Effect[] obsidian = {

            new Effect(Material.OBSIDIAN, LocP(1, 4, 0)),
            new Effect(Material.CRYING_OBSIDIAN, ScaleP(LocP(1, 5, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(2, 6, -1), 1, 3, 1)),
            new Effect(Material.CRYING_OBSIDIAN, ScaleP(LocP(2, 9, -2), 2, 1, 1)),
            new Effect(Material.CRYING_OBSIDIAN, ScaleP(LocP(1, 8, -1), 1, 1, 1)),

            new Effect(Material.OBSIDIAN, LocP(-2, 4, 0)),
            new Effect(Material.CRYING_OBSIDIAN, ScaleP(LocP(-2, 5, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(-3, 6, -1), 1, 3, 1)),
            new Effect(Material.CRYING_OBSIDIAN, ScaleP(LocP(-4, 9, -2), 2, 1, 1)),
            new Effect(Material.CRYING_OBSIDIAN, ScaleP(LocP(-2, 8, -1), 1, 1, 1)),

    };

    //鹿角
    static Effect[] wild = {
            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(1, 4, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(2, 5, -1), 2, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(4, 6, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(2, 7, 0), 1, 3, 1)),
            new Effect(Material.BROWN_TERRACOTTA, LocP(1, 8, 0)),
            new Effect(Material.BROWN_TERRACOTTA, LocP(3, 9, 1)),

            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(-2, 4, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(-4, 5, -1), 2, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(-5, 6, 0), 1, 2, 1)),
            new Effect(Material.BROWN_TERRACOTTA, ScaleP(LocP(-3, 7, 0), 1, 3, 1)),
            new Effect(Material.BROWN_TERRACOTTA, LocP(-2, 8, 0)),
            new Effect(Material.BROWN_TERRACOTTA, LocP(-4, 9, 1)),
    };

    //金鹿角
    static Effect[] wildG = {
            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(1, 4, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(2, 5, -1), 2, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(4, 6, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(2, 7, 0), 1, 3, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, LocP(1, 8, 0)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, LocP(3, 9, 1)),

            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(-2, 4, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(-4, 5, -1), 2, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(-5, 6, 0), 1, 2, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, ScaleP(LocP(-3, 7, 0), 1, 3, 1)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, LocP(-2, 8, 0)),
            new Effect(Material.YELLOW_CONCRETE_POWDER, LocP(-4, 9, 1)),
    };

    //黑鹿角
    static Effect[] wildO = {
            new Effect(Material.OBSIDIAN, ScaleP(LocP(1, 4, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(2, 5, -1), 2, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(4, 6, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(2, 7, 0), 1, 3, 1)),
            new Effect(Material.OBSIDIAN, LocP(1, 8, 0)),
            new Effect(Material.OBSIDIAN, LocP(3, 9, 1)),

            new Effect(Material.OBSIDIAN, ScaleP(LocP(-2, 4, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(-4, 5, -1), 2, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(-5, 6, 0), 1, 2, 1)),
            new Effect(Material.OBSIDIAN, ScaleP(LocP(-3, 7, 0), 1, 3, 1)),
            new Effect(Material.OBSIDIAN, LocP(-2, 8, 0)),
            new Effect(Material.OBSIDIAN, LocP(-4, 9, 1)),
    };

    //小鹿角
    static Effect[] tinyAntler = {
            new Effect(Material.GILDED_BLACKSTONE, ScaleP(LocP(1, 4, 0), 1, 2, 1)),
            new Effect(Material.GILDED_BLACKSTONE, ScaleP(LocP(2, 5, -1), 1, 2, 1)),
            new Effect(Material.BLACKSTONE_WALL, ScaleP(LocP(2, 7, -1), 1, 1, 1)),

            new Effect(Material.GILDED_BLACKSTONE, ScaleP(LocP(-2, 4, 0), 1, 2, 1)),
            new Effect(Material.GILDED_BLACKSTONE, ScaleP(LocP(-3, 5, -1), 1, 2, 1)),
            new Effect(Material.BLACKSTONE_WALL, ScaleP(LocP(-3, 7, -1), 1, 1, 1)),
    };


    //监守者
    static Effect[] warden = {
            new Effect(Material.CYAN_TERRACOTTA, ScaleP(LocP(2, 2, -1), 2, 1, 1)),
            new Effect(Material.CYAN_TERRACOTTA, LocP(3, 3, -1)),
            new Effect(Material.CYAN_TERRACOTTA, ScaleP(LocP(3, 4, -1), 2, 1, 1)),
            new Effect(Material.BLACK_TERRACOTTA, ScaleP(LocP(4, 5, 0), 1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, ScaleP(LocP(3, 6, 0), 1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, ScaleP(LocP(1, 7, 0), 2, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, ScaleP(LocP(1, 8, 0), 1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, ScaleP(LocP(1, 6, 0), 1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, ScaleP(LocP(3, 8, 0), 1, 1, 1)),


            new Effect(Material.CYAN_TERRACOTTA, ScaleP(LocP(-2, 2, -1), -2, 1, 1)),
            new Effect(Material.CYAN_TERRACOTTA, ScaleP(LocP(-3, 3, -1), -1, 1, 1)),
            new Effect(Material.CYAN_TERRACOTTA, ScaleP(LocP(-3, 4, -1), -2, 1, 1)),
            new Effect(Material.BLACK_TERRACOTTA, ScaleP(LocP(-4, 5, 0), -1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, ScaleP(LocP(-3, 6, 0), -1, 2, 1)),
            new Effect(Material.BLACK_TERRACOTTA, ScaleP(LocP(-1, 7, 0), -2, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, ScaleP(LocP(-1, 8, 0), -1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, ScaleP(LocP(-1, 6, 0), -1, 1, 1)),
            new Effect(Material.BLACK_CONCRETE_POWDER, ScaleP(LocP(-3, 8, 0), -1, 1, 1)),
    };

    //天使
    static Effect[] angel = {
            new Effect(Material.GLOWSTONE, ScaleP(LocP(2, 6, 1), -4, 1, 1)),
            new Effect(Material.GLOWSTONE, ScaleP(LocP(2, 6, -2), -4, 1, 1)),
            new Effect(Material.GLOWSTONE, ScaleP(LocP(-2, 6, 1), 1, 1, -2)),
            new Effect(Material.GLOWSTONE, ScaleP(LocP(1, 6, 1), 1, 1, -2)),
    };

    //上帝
    static int ty = 6;
    static Effect[] god = {
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(4, ty, -2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(3, ty, -3), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(3, ty, -4), -2, 1, -1)),

            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(-3, ty, -2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(-2, ty, -3), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(-1, ty, -4), -2, 1, -1)),

            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(-3, ty, 2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(-2, ty, 2), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(-1, ty, 3), -2, 1, -1)),

            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(4, ty, 2), -1, 1, -2)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(3, ty, 2), -1, 1, -1)),
            new Effect(Material.OCHRE_FROGLIGHT, ScaleP(LocP(3, ty, 3), -2, 1, -1)),
    };

    //猫耳（黑/粉）
    static Effect[] catBlack = {
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 4, 1), 2, 1, 2)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(2, 3, 0), 1, 1, 2)),

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 4, 1), 2, 1, 2)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 3, 0), 1, 1, 2)),
    };

    static Effect[] crown = {

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-1, 4, -2), 2, 1, 4)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 4, -1), 4, 1, 2)),
            new Effect(Material.GOLD_BLOCK, LocP(0, 5, -2)),
            new Effect(Material.GOLD_BLOCK, LocP(-2, 5, -1)),
            new Effect(Material.GOLD_BLOCK, LocP(1, 5, 0)),
            new Effect(Material.GOLD_BLOCK, LocP(-1, 5, 1)),

    };

    static Effect[] hugeCrown = {

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 4, -2), 4, 1, 4)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(2, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 5, 2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(2, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 5, 2), 1, 2, 1)),

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 7, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 7, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 7, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 7, -2), 1, 2, 1)),

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-1, 7, -1), 2, 2, 2)),

    };

    static Effect[] hugeCrown2 = {

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 4, -2), 4, 1, 4)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 5, -3), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(2, 5, -2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 5, 2), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(2, 5, 1), 1, 2, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 5, 2), 1, 2, 1)),

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(2, 6, 2), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(2, 6, -3), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 6, 2), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-3, 6, -3), 1, 1, 1)),

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 7, 1), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 7, -2), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-2, 7, 1), 1, 1, 1)),
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(1, 7, -2), 1, 1, 1)),

            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(-1, 7, -1), 2, 1, 2)),

            new Effect(Material.HONEY_BLOCK, ScaleP(LocP(-1, 5, -1), 2, 2, 2)),
    };

    static Effect[] test = {
            new Effect(Material.GOLD_BLOCK, ScaleP(LocP(0, 4, 0), 1, 1, 1)),
            new Effect(Material.IRON_BLOCK, ScaleP(LocP(1, 4, 0), 1, 1, 1)),

            new Effect(Material.IRON_BLOCK, ScaleP(LocP(2, 4, 2), 1, 1, 1)),
            new Effect(Material.IRON_BLOCK, ScaleP(LocP(2, 0, 2), 1, 1, 1)),

            new Effect(Material.IRON_BLOCK, ScaleP(LocP(-3, 0, -3), 1, 1, 1)),
            new Effect(Material.IRON_BLOCK, ScaleP(LocP(-3, 4, -3), 1, 1, 1))
    };

    static float cx = 0f;
    static float cy = 0f;
    static float cz = 5 * p;
    static Material black = Material.BLACK_WOOL;
    static Material brown = Material.BLACK_TERRACOTTA;
    static Material white = Material.SMOOTH_QUARTZ;
    static Material goldBlock = Material.GOLD_BLOCK;
    static Material lightBrown = Material.YELLOW_GLAZED_TERRACOTTA;
    static Effect[] Dragon = {
            //chin
            new Effect(brown, HalfP(LocHP(cx - 2, cy - 1, cz + 4), 4, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 1, cy - 2, cz + 4), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 2, cy - 2, cz + 3), 4, 1, 1)),
            //pair left
            new Effect(brown, HalfP(LocHP(cx - 3, cy - 1, cz + 3), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 5, cy, cz + 2), 2, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 4, cy - 1, cz + 2), 1, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 4, cy + 1, cz + 3), 1, 1, 1)),
            //pair right
            new Effect(brown, HalfP(LocHP(cx + 2, cy - 1, cz + 3), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx + 3, cy, cz + 2), 2, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx + 3, cy - 1, cz + 2), 1, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 3, cy + 1, cz + 3), 1, 1, 1)),

            //teeth
            new Effect(white, HalfP(LocHP(cx + 1.9f, cy, cz + 5), 1.2f, 1.2f, 1.2f)),
            new Effect(white, HalfP(LocHP(cx - 3.1f, cy, cz + 5), 1.2f, 1.2f, 1.2f)),
            new Effect(white, HalfP(LocHP(cx - 4.1f, cy + 2, cz + 3), 8.2f, 1.2f, 1.2f)),

            //mouth
            new Effect(brown, HalfP(LocHP(cx - 3, cy + 1, cz + 4), 2, 1, 2)),
            new Effect(brown, HalfP(LocHP(cx + 1, cy + 1, cz + 4), 2, 1, 2)),
            new Effect(black, HalfP(LocHP(cx - 1, cy + 1, cz + 3), 2, 1, 1)),

            //nose
            new Effect(brown, HalfP(LocHP(cx - 1, cy + 2, cz + 4), 2, 3, 2.1f)),
            new Effect(black, HalfP(LocHP(cx - 2, cy + 2, cz + 5), 4, 1, 1)),
            //pair left
            new Effect(brown, HalfP(LocHP(cx - 3, cy + 2, cz + 4), 1, 1, 2)),
            new Effect(brown, HalfP(LocHP(cx - 2, cy + 4, cz + 4), 1, 1, 2)),
            //pair right
            new Effect(brown, HalfP(LocHP(cx + 2, cy + 2, cz + 4), 1, 1, 2)),
            new Effect(brown, HalfP(LocHP(cx + 1, cy + 4, cz + 4), 1, 1, 2)),

            //cheek left
            new Effect(brown, HalfP(LocHP(cx - 4, cy + 3, cz + 4), 3, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 5, cy + 5, cz + 2), 2, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 6, cy + 2, cz + 2), 2, 3, 1)),
            new Effect(lightBrown, HalfP(LocHP(cx - 6.1f, cy + 3, cz + 2), 1.2f, 1.2f, 1.2f)),
            new Effect(lightBrown, HalfP(LocHP(cx - 5.1f, cy + 4, cz + 3), 1.2f, 1.2f, 1.2f)),
            new Effect(brown, HalfP(LocHP(cx - 5f, cy + 2, cz + 3), 1, 2, 1)),

            new Effect(brown, HalfP(LocHP(cx - 6, cy, cz + 1), 1, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 8, cy + 1, cz + 1), 3, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 7, cy + 2, cz + 1), 2, 1, 1)),

            //cheek right
            new Effect(brown, HalfP(LocHP(cx + 1, cy + 3, cz + 4), 3, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 3, cy + 5, cz + 2), 2, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx + 4, cy + 2, cz + 2), 2, 3, 1)),
            new Effect(lightBrown, HalfP(LocHP(cx + 4.9f, cy + 3, cz + 2), 1.2f, 1.2f, 1.2f)),
            new Effect(lightBrown, HalfP(LocHP(cx + 3.9f, cy + 4, cz + 3), 1.2f, 1.2f, 1.2f)),
            new Effect(brown, HalfP(LocHP(cx + 4f, cy + 2, cz + 3), 1, 2, 1)),

            new Effect(brown, HalfP(LocHP(cx + 5, cy, cz + 1), 1, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 5, cy + 1, cz + 1), 3, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 5, cy + 2, cz + 1), 2, 1, 1)),

            //noseBridge
            new Effect(brown, HalfP(LocHP(cx - 4, cy + 4, cz + 3), 8, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 1, cy + 6, cz + 3), 2, 3, 2)),

            //eyes
            new Effect(goldBlock, HalfP(LocHP(cx - 2.1f, cy + 6, cz + 3), 4.2f, 1, 1.1f)),
            new Effect(white, HalfP(LocHP(cx - 3, cy + 6, cz + 3), 6, 1, 1)),

            //eyebrow
            new Effect(brown, HalfP(LocHP(cx - 5, cy + 8, cz + 1), 10, 1, 2)),
            //pair left
            new Effect(brown, HalfP(LocHP(cx - 6, cy + 7, cz + 2), 1, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 5, cy + 7, cz + 3), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 3, cy + 7, cz + 4), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 3, cy + 8, cz + 3), 2, 1, 1)),
            //pair right
            new Effect(brown, HalfP(LocHP(cx + 5, cy + 7, cz + 2), 1, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 3, cy + 7, cz + 3), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 1, cy + 7, cz + 4), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 1, cy + 8, cz + 3), 2, 1, 1)),

            //ears
            //pair left
            new Effect(brown, HalfP(LocHP(cx - 8, cy + 4, cz + 1), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 7, cy + 5, cz + 1), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 6, cy + 6, cz + 1), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 6, cy + 8, cz - 1), 2, 1, 2)),
            //pair right
            new Effect(brown, HalfP(LocHP(cx + 6, cy + 4, cz + 1), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 5, cy + 5, cz + 1), 2, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx + 5, cy + 6, cz + 1), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx + 4, cy + 8, cz - 1), 2, 1, 2)),

            //antler
            new Effect(brown, HalfP(LocHP(cx - 4, cy + 9, cz + 1), 8, 1, 1)),
            new Effect(brown, HalfP(LocHP(cx - 1, cy + 9, cz + 2), 2, 1, 1)),
            //pair left
            new Effect(brown, HalfP(LocHP(cx - 4, cy + 10, cz + 1), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 3, cy + 10, cz), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 4, cy + 11, cz), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx - 5, cy + 12, cz), 1, 3, 1)),
            new Effect(brown, HalfP(LocHP(cx - 4, cy + 15, cz), 1, 1, 1)),
            //pair right
            new Effect(brown, HalfP(LocHP(cx + 3, cy + 10, cz + 1), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx + 2, cy + 10, cz), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx + 3, cy + 11, cz), 1, 2, 1)),
            new Effect(brown, HalfP(LocHP(cx + 4, cy + 12, cz), 1, 3, 1)),
            new Effect(brown, HalfP(LocHP(cx + 3, cy + 15, cz), 1, 1, 1)),

            new Effect(brown, ScaleP(LocP(-3, 0, -3), 6, 4, 4 + 4 * p))
    };

    static float c1x = 0, c1y = 0, c1z = 4 * p + hp;
    static Material mouth = Material.GRAY_CONCRETE;
    static Material yellow = Material.YELLOW_WOOL;
    static Effect[] Tiger = {
            //chin
            new Effect(white, HalfP(LocHP(c1x - 3, c1y - 2, c1z + 2), 6, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 2, c1y - 2, c1z + 3), 4, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 4, c1y - 1, c1z + 2), 8, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 3, c1y - 1, c1z + 3), 6, 1, 2)),
            new Effect(white, HalfP(LocHP(c1x - 1, c1y - 1, c1z + 5), 2, 1, 1)),

            //mouth
            new Effect(mouth, HalfP(LocHP(c1x - 2, c1y - 1, c1z + 5), 1, 1, 1)),
            new Effect(mouth, HalfP(LocHP(c1x + 1, c1y - 1, c1z + 5), 1, 1, 1)),
            new Effect(mouth, HalfP(LocHP(c1x - 1, c1y, c1z + 5), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 1, c1y + 1, c1z + 5), 2, 1, 1)),

            //nose
            new Effect(white, HalfP(LocHP(c1x - 2, c1y, c1z + 5), 1, 4, 1)),
            new Effect(white, HalfP(LocHP(c1x + 1, c1y, c1z + 5), 1, 4, 1)),
            new Effect(white, HalfP(LocHP(c1x - 1, c1y + 2, c1z + 6), 2, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x - 3, c1y + 2, c1z + 5), 4, 1, 1)),

            //cheek(under)
            new Effect(white, HalfP(LocHP(c1x - 3, c1y + 1, c1z + 4), 6, 4, 1)),
            //pair left
            new Effect(black, HalfP(LocHP(c1x - 3, c1y, c1z + 4), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 5, c1y + 1, c1z + 3), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 4, c1y, c1z + 3), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 5, c1y, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 6, c1y + 1, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 7, c1y + 2, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 6, c1y, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 7, c1y + 1, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 8, c1y + 2, c1z + 2), 1, 4, 1)),
            //cheek right
            new Effect(black, HalfP(LocHP(c1x + 2, c1y, c1z + 4), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 1, c1z + 3), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 3, c1y, c1z + 3), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 4, c1y, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 5, c1y + 1, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 6, c1y + 2, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 5, c1y, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 6, c1y + 1, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 7, c1y + 2, c1z + 2), 1, 4, 1)),

            //cheek(up)
            //pair left
            new Effect(black, HalfP(LocHP(c1x - 5, c1y + 2, c1z + 3), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 6, c1y + 2, c1z + 3), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 4, c1y + 3, c1z + 4), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 5, c1y + 3, c1z + 3), 2, 2, 1)),
            new Effect(black, HalfP(LocHP(c1x - 6, c1y + 3, c1z + 3), 1, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x - 7, c1y + 3, c1z + 3), 1, 2, 1)),
            //pair right
            new Effect(black, HalfP(LocHP(c1x + 3, c1y + 2, c1z + 3), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 5, c1y + 2, c1z + 3), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 3, c1z + 4), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 3, c1z + 3), 2, 2, 1)),
            new Effect(black, HalfP(LocHP(c1x + 5, c1y + 3, c1z + 3), 1, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x + 6, c1y + 3, c1z + 3), 1, 2, 1)),

            //eyebrow
            //pair left
            new Effect(white, HalfP(LocHP(c1x - 4, c1y + 5, c1z + 3), 1, 1, 1)),
            new Effect(yellow, HalfP(LocHP(c1x - 4, c1y + 6, c1z + 3), 1, 1, 1)),
            new Effect(yellow, HalfP(LocHP(c1x - 3, c1y + 6, c1z + 4), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 2, c1y + 7, c1z + 4), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 5, c1y + 5, c1z + 3), 1, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x - 6, c1y + 5, c1z + 3), 1, 2, 1)),
            //pair right
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 5, c1z + 3), 1, 1, 1)),
            new Effect(yellow, HalfP(LocHP(c1x + 3, c1y + 6, c1z + 3), 1, 1, 1)),
            new Effect(yellow, HalfP(LocHP(c1x + 2, c1y + 6, c1z + 4), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 1, c1y + 7, c1z + 4), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 4, c1y + 5, c1z + 3), 1, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x + 5, c1y + 5, c1z + 3), 1, 2, 1)),

            //eye
            new Effect(goldBlock, HalfP(LocHP(c1x - 3, c1y + 5, c1z + 4), 6, 1, 1)),

            //eyeMiddle
            new Effect(white, HalfP(LocHP(c1x - 1, c1y + 4, c1z + 5), 2, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x - 1, c1y + 6, c1z + 4), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 2, c1y + 5, c1z + 5), 1, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x + 1, c1y + 5, c1z + 5), 1, 2, 1)),

            //head
            //fore
            new Effect(black, HalfP(LocHP(c1x - 6, c1y + 9, c1z + 2), 12, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 1, c1y + 7, c1z + 3), 2, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 1, c1y + 10, c1z + 2), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 1, c1y + 8, c1z + 3), 2, 2, 1)),
            //pair left
            new Effect(black, HalfP(LocHP(c1x - 4, c1y + 7, c1z + 3), 1, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x - 5, c1y + 7, c1z + 3), 1, 2, 1)),
            new Effect(black, HalfP(LocHP(c1x - 3, c1y + 7, c1z + 4), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 2, c1y + 8, c1z + 4), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 2, c1y + 9, c1z + 3), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 3, c1y + 8, c1z + 3), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 4, c1y + 9, c1z + 3), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 4, c1y + 10, c1z + 2), 3, 1, 1)),
            //pair right
            new Effect(black, HalfP(LocHP(c1x + 3, c1y + 7, c1z + 3), 1, 2, 1)),
            new Effect(white, HalfP(LocHP(c1x + 4, c1y + 7, c1z + 3), 1, 2, 1)),
            new Effect(black, HalfP(LocHP(c1x + 2, c1y + 7, c1z + 4), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 1, c1y + 8, c1z + 4), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 1, c1y + 9, c1z + 3), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 2, c1y + 8, c1z + 3), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 2, c1y + 9, c1z + 3), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 1, c1y + 10, c1z + 2), 3, 1, 1)),
            //left
            new Effect(black, HalfP(LocHP(c1x - 7, c1y + 5, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 8, c1y + 6, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 7, c1y + 7, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 6, c1y + 8, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 7, c1y + 6, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 6, c1y + 7, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 7, c1y + 8, c1z + 2), 1, 2, 1)),
            //right
            new Effect(black, HalfP(LocHP(c1x + 6, c1y + 5, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 7, c1y + 6, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 6, c1y + 7, c1z + 2), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 5, c1y + 8, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 6, c1y + 6, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 5, c1y + 7, c1z + 2), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 6, c1y + 8, c1z + 2), 1, 2, 1)),

            //ears
            //pair left
            new Effect(white, HalfP(LocHP(c1x - 6, c1y + 10, c1z), 3, 1, 2)),
            new Effect(white, HalfP(LocHP(c1x - 7, c1y + 11, c1z), 5, 1, 2)),
            new Effect(white, HalfP(LocHP(c1x - 6, c1y + 13, c1z), 2, 1, 2)),
            new Effect(black, HalfP(LocHP(c1x - 5, c1y + 11, c1z + 1), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x - 6, c1y + 12, c1z + 1), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 7, c1y + 12, c1z + 1), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 4, c1y + 12, c1z + 1), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x - 7, c1y + 12, c1z), 4, 1, 1)),
            //pair right
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 10, c1z), 3, 1, 2)),
            new Effect(white, HalfP(LocHP(c1x + 2, c1y + 11, c1z), 5, 1, 2)),
            new Effect(white, HalfP(LocHP(c1x + 4, c1y + 13, c1z), 2, 1, 2)),
            new Effect(black, HalfP(LocHP(c1x + 4, c1y + 11, c1z + 1), 1, 1, 1)),
            new Effect(black, HalfP(LocHP(c1x + 4, c1y + 12, c1z + 1), 2, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 12, c1z + 1), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 12, c1z + 1), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 6, c1y + 12, c1z + 1), 1, 1, 1)),
            new Effect(white, HalfP(LocHP(c1x + 3, c1y + 12, c1z), 4, 1, 1)),

            new Effect(white, ScaleP(LocP(-3, 0, -3), 6, 4 + p, 4 + 3 * p + hp))

    };

    public static Transformation cloneWithScale(Transformation transformation, float sx, float sy, float sz) {
        return new Transformation(
                new Vector3f(transformation.getTranslation()), // 拷贝 translation
                new Quaternionf(transformation.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(sx, sy, sz),                      // 替换 scale
                new Quaternionf()
        );
    }

    public static Transformation ScaleP(Transformation transformation, float sx, float sy, float sz) {
        return new Transformation(
                new Vector3f(transformation.getTranslation()), // 拷贝 translation
                new Quaternionf(transformation.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(sx * p, sy * p, sz * p),                      // 替换 scale
                new Quaternionf()
        );
    }

    public static Transformation HalfP(Transformation transformation, float sx, float sy, float sz) {
        return new Transformation(
                new Vector3f(transformation.getTranslation()), // 拷贝 translation
                new Quaternionf(transformation.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(sx * hp, sy * hp, sz * hp),                      // 替换 scale
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

    public static Transformation LocP(float x, float y, float z) {
        return new Transformation(
                new Vector3f(new Vector3f(x * p, y * p, z * p)), // 拷贝 translation
                new Quaternionf(normal.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(normal.getScale()),                      // 替换 scale
                new Quaternionf()
        );
    }

    public static Transformation LocHP(float x, float y, float z) {
        return new Transformation(
                new Vector3f(new Vector3f(x * hp, y * hp, z * hp)), // 拷贝 translation
                new Quaternionf(half.getLeftRotation()), // 拷贝 leftRotation
                new Vector3f(half.getScale()),                      // 替换 scale
                new Quaternionf()
        );
    }

}
