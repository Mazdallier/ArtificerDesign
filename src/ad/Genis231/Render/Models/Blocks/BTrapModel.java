package ad.Genis231.Render.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BTrapModel extends ModelBase {
	
	private IModelCustom modelBTrap;
	
	public BTrapModel() {
		
		modelBTrap = AdvancedModelLoader.loadModel("/assets/artificer/textures/models/bearTrap.obj");
	}
	
	public void render() {
		modelBTrap.renderAll();
	}
}