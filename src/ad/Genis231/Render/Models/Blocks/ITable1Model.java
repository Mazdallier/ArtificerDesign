package ad.Genis231.Render.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ITable1Model extends ModelBase {
    private IModelCustom modelIT1;
    
    public ITable1Model() {
        modelIT1 = AdvancedModelLoader.loadModel("/assets/artificer/textures/models/ITable1.obj");
    }
    
    public void renderPart(int part) {
        switch (part) {
            case 0:
                modelIT1.renderPart("Box001");
            case 1:
                modelIT1.renderPart("Cylinder001");
        }
    }
}
