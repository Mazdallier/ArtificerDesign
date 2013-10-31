package ad.Genis231.Render.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SpiralModel extends ModelBase {
	
	private IModelCustom modelSpiral;
	
	public SpiralModel() {
		
		modelSpiral = AdvancedModelLoader.loadModel("/assets/artificer/textures/models/Spring.obj");
	}
	
	public void render() {
		modelSpiral.renderAll();
	}
}