package ad.Genis231.Render.Blocks;

import static org.lwjgl.opengl.GL11.*;

import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ITableHelper {
	
	public static void block(double x, double y, double z, float scale) {
		glScalef(scale, scale, scale);
		glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.ITable);
		
	}
	
	public static void Circle(double x, double y, double z, float scale, float rotate) {
		glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
		glScalef(scale, scale, scale);
		glRotatef(rotate, 0.0F, 1.0F, 0.0F);
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.ITable);
		
	}
}
