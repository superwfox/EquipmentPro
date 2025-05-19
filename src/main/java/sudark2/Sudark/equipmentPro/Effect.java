package sudark2.Sudark.equipmentPro;

import org.bukkit.Material;
import org.bukkit.util.Transformation;

public class Effect {

    private final Material material;
    private final Transformation transformation;

    public Effect(Material material, Transformation transformation) {
        this.material = material;
        this.transformation = transformation;
    }

    public Material getMaterial() {
        return material;
    }

    public Transformation getTransformation() {
        return transformation;
    }


}
