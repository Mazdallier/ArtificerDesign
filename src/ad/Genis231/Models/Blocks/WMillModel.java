package ad.Genis231.Models.Blocks;

import ad.Genis231.Refrence.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT) public class WMillModel extends ModelBase {
	
	private IModelCustom model;
	
	public WMillModel() {
		
		model = AdvancedModelLoader.loadModel(Models.WindMill);
	}
	
	public void render() {
		model.renderAll();
	}
}
