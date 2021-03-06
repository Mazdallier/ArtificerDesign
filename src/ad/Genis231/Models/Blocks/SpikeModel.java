package ad.Genis231.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ad.Genis231.Refrence.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class SpikeModel extends ModelBase {
	
	private IModelCustom model;
	
	public SpikeModel() {
		
		model = AdvancedModelLoader.loadModel(Models.Spike);
	}
	
	public void render() {
		model.renderAll();
	}
}
