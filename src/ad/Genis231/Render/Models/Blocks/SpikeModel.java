package ad.Genis231.Render.Models.Blocks;

import ad.Genis231.lib.Models;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SpikeModel extends ModelBase {
	
	private IModelCustom modelSpike;
	
	public SpikeModel() {
		
		modelSpike = AdvancedModelLoader.loadModel(Models.Spike);
	}
	
	public void render() {
		modelSpike.renderAll();
	}
}