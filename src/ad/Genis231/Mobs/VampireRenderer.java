package ad.Genis231.Mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import ad.Genis231.Render.Models.mobs.VampModel;

public class VampireRenderer extends RenderLiving {
	
	protected VampModel model;
	
	public VampireRenderer(VampModel par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((VampModel) mainModel);
	}
	
	@Override protected ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}
	
}
