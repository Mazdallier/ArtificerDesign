package ad.Genis231.Block.Renderer;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ITableHelper {
    static ResourceLocation texture = new ResourceLocation("artificer", "textures/blocks/ITable.png");
    
    public static void block(double x, double y, double z, float scale) {
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);

    }
    
    public static void Circle(double x, double y, double z, float scale, float rotate) {
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(rotate, 0.0F, 1.0F, 0.0F);
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);

    }
}
