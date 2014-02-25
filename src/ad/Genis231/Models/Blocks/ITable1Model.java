package ad.Genis231.Models.Blocks;

import ad.Genis231.lib.Models;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ITable1Model extends ModelBase {
	private IModelCustom model;
	
	public ITable1Model() {
		model = AdvancedModelLoader.loadModel(Models.ITable);
	}
	
	public void renderPart(int part) {
		switch (part) {
			case 0:
				model.renderPart("MainBox");
				break;
			case 1:
				model.renderPart("Mid");
				break;
		}
	}
}
