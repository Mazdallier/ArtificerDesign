package ad.Genis231.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ad.Genis231.lib.Models;

public class ITable2Model extends ModelBase {
	private IModelCustom table;
	
	public ITable2Model() {
		table = AdvancedModelLoader.loadModel(Models.ITable);
	}
	
	public void renderPart(int i) {
		switch (i) {
			case 0:
				table.renderPart("MainBox");
				break;
			case 1:
				table.renderPart("Mid");
				break;
			case 2:
				table.renderPart("Top");
				break;
		}
	}
	
}
