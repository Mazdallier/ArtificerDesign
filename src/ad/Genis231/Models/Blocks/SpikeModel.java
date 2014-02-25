package ad.Genis231.Models.Blocks;

import ad.Genis231.lib.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT) public class SpikeModel extends ModelBase {
	
	private IModelCustom model;
	
	public SpikeModel() {
		
		model = AdvancedModelLoader.loadModel(Models.Spike);
	}
	
	public void render() {
		model.renderAll();
	}
}
