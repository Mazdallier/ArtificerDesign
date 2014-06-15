package ad.Genis231.Models.Blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ad.Genis231.Refrence.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class PipeModel extends ModelBase {
	
	private IModelCustom model;
	
	public PipeModel() {
		
		model = AdvancedModelLoader.loadModel(Models.Pipe);
	}
	
	public void render() {
		model.renderOnly("Center");
	}
	
	public void renderPart(int i, boolean extended) {
		
		switch (i) {
			case 1:
				model.renderOnly(extended ? "Top" : "TopP");
				return;
				
			case 0:
				model.renderOnly(extended ? "Bot" : "BotP");
				return;
				
			case 5:
				model.renderOnly(extended ? "Right" : "RightP");
				return;
				
			case 4:
				model.renderOnly(extended ? "Left" : "LeftP");
				return;
				
			case 3:
				model.renderOnly(extended ? "Front" : "FrontP");
				return;
				
			case 2:
				model.renderOnly(extended ? "Back" : "BackP");
				return;
		}
		
	}
}
