package ad.Genis231.Render.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ITable2Model extends ModelBase {
    private IModelCustom modelIT2;
    
    public ITable2Model() {
        modelIT2 = AdvancedModelLoader.loadModel("/assets/artificer/textures/models/ITable2.obj");
    }
    
    public void render() {
        modelIT2.renderAll();
    }
}
