package ad.Genis231.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ad.Genis231.lib.Models;

public class BearTrapModel extends ModelBase {
    private IModelCustom model;
    
    public BearTrapModel() {
        model = AdvancedModelLoader.loadModel(Models.BTrap);
    }

    public void RenderBase(){
    	model.renderPart("Base");
    }
    
    public void RenderSide(){
    	model.renderPart("Right");
    	model.renderPart("Left");
    }
}
