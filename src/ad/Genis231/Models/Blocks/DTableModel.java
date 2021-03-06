package ad.Genis231.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ad.Genis231.Refrence.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class DTableModel extends ModelBase {
	
	private IModelCustom model;
	
	public DTableModel() {
		
		model = AdvancedModelLoader.loadModel(Models.DTable);
	}
	
	public void render() {
		model.renderAll();
	}
	
	public void renderFrame() {
		model.renderOnly("Top", "Bot", "Pillar1", "Pillar2", "Pillar3", "Pillar4", "Box001");
	}
	
	public void renderPart(int i) {
		model.renderOnly("Gear" + i, "Center" + i);
	}
}
