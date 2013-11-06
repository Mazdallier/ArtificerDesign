package ad.Genis231.Render.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ITable2Model extends ModelBase {
    private IModelCustom table;
    
    public ITable2Model() {
        table = AdvancedModelLoader.loadModel("/assets/artificer/textures/models/ITable2.obj");
    }
    
    public void renderPart(int i) {
        switch (i) {
            case 0:
                table.renderPart("Box001");
            case 1:
                table.renderPart("Cylinder001");
            case 2:
                table.renderPart("Cylinder002");
        }
    }
}
