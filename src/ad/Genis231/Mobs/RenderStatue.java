package ad.Genis231.Mobs;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import ad.Genis231.Render.Models.Blocks.BearTrap;
import ad.Genis231.Render.Models.mobs.VampModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderStatue extends RenderLiving {
    ResourceLocation skin = new ResourceLocation("artificer", "textures/models/new.png");
    
    public RenderStatue(BearTrap model, float shadow) {
        super(model, shadow);
    }

	protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return skin;
    }
}