package ad.Genis231.Render.Blocks;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import ad.Genis231.Models.Blocks.WMillModel;
import ad.Genis231.Refrence.textures;
import ad.Genis231.TileEntity.WMMastTileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class WMillRenderer extends TileEntitySpecialRenderer {
	
	private WMillModel model = new WMillModel();
	public static long speed = 16383;
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		float angle = (float) (360.0 * (System.currentTimeMillis() & speed) / (speed / 8));
		
		if (tileEntity instanceof WMMastTileEntity) {
			
			glPushMatrix();
			
			// Scale, Translate, Rotate
			
			glScalef(1.0F, 1.0F, 1.0F);
			glTranslatef((float) x + 0.05F, (float) y + 0.5F, (float) z + 0.5F);
			glRotatef(-angle, 1F, 0F, 0F);
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.WMMasts);
			
			// Render
			model.render();
			glPopMatrix();
		}
	}
}
