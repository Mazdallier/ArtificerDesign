package ad.Genis231.Render.Mobs;

import ad.Genis231.Mobs.dwarfMob;
import ad.Genis231.Models.mobs.DwarfModel;
import ad.Genis231.lib.textures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class dwarfRenderer extends RenderLiving {
	DwarfModel dwarf;
	int dwarfType = 0;
	
	public dwarfRenderer(DwarfModel model, float shadow, int type) {
		super(model, shadow);
		dwarfType = type;
		dwarf = ((DwarfModel) mainModel);
	}
	
	@Override protected ResourceLocation getEntityTexture(Entity entity) {
		return textures.dwarf[dwarfType];
	}
	
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		RenderDwarf((dwarfMob) par1Entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		RenderDwarf((dwarfMob) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	public void RenderDwarf(dwarfMob mob, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(mob, par2, par4, par6, par8, par9);
	}
}
