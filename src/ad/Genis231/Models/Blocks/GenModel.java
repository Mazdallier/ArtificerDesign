package ad.Genis231.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ad.Genis231.lib.Models;

public class GenModel extends ModelBase {
	
	private IModelCustom model;
	
	public GenModel() {
		
		model = AdvancedModelLoader.loadModel(Models.Generator);
	}
	
	public void render() {
		model.renderAll();
	}
	
	public void renderFrame() {
		model.renderAllExcept("tank1", "tank2");
	}
	
	public void renderTanks() {
		model.renderOnly("tank1", "tank2");
	}
}
