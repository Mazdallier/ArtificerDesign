package ad.Genis231.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import ad.Genis231.Render.Models.mobs.DwarfModel;
import ad.Genis231.lib.textures;

public class dwarfRenderer extends RenderLiving {
    DwarfModel dwarf;
    
    public dwarfRenderer(ModelBase model, float par2) {
        super(model, par2);
        
        dwarf = ((DwarfModel) mainModel);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return textures.dwarf;
    }
    
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        RenderDwarf((dwarfMob) par1Entity, par2, par4, par6, par8, par9);
    }
    
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        RenderDwarf((dwarfMob) par1EntityLiving, par2, par4, par6, par8, par9);
    }
    
    public void RenderDwarf(dwarfMob mob, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(mob, par2, par4, par6, par8, par9);
    }
    
}
