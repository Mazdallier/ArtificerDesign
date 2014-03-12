package ad.Genis231.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ad.Genis231.lib.Models;

public class DrillModel extends ModelBase {
	
	private IModelCustom model;
	
	public DrillModel() {
		
		model = AdvancedModelLoader.loadModel(Models.Drill);
	}
	
	public void renderFrame() {
		model.renderAllExcept("Drill");
	}
	
	public void renderDrill() {
		model.renderPart("Drill");
	}
}