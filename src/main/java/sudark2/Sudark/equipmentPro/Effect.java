package sudark2.Sudark.equipmentPro;

import org.bukkit.Material;
import org.bukkit.util.Transformation;

public class Effect {

    private final Material material;
    private final Transformation transformation;
    private final float x;
    private final float y;
    private final float z;

    public Effect(Material material, Transformation transformation, float x, float y, float z) {
        this.material = material;
        this.transformation = transformation;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Material getMaterial() {
        return material;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public float z() {
        return z;
    }


}
