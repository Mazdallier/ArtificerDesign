package ad.Genis231.Render.Models.Blocks;

import ad.Genis231.lib.Models;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ITable1Model extends ModelBase {
    private IModelCustom table;
    
    public ITable1Model() {
        table = AdvancedModelLoader.loadModel(Models.ITable1);
    }
    
    public void renderPart(int part) {
        switch (part) {
            case 0:
                table.renderPart("MainBox");
                break;
            case 1:
                table.renderPart("Mid");
                break;
        }
    }
}
