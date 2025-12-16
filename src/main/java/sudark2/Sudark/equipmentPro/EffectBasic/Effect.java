package sudark2.Sudark.equipmentPro.EffectBasic;

import org.bukkit.Material;
import org.bukkit.util.Transformation;

public class Effect {

    private final Material material;
    private final Transformation transformation;
    private final double scale;

    public Effect(Material material, Transformation transformation,double scale) {
        this.material = material;
        this.transformation = transformation;
        this.scale = scale;
    }

    public Material getMaterial() {
        return material;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public double getScale() {
        return scale;
    }


}
