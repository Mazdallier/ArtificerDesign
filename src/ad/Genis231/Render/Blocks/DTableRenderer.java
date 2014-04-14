package ad.Genis231.Render.Blocks;

import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.DTableModel;
import ad.Genis231.TileEntity.model.DTableTile;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class DTableRenderer extends TileEntitySpecialRenderer {
	
	private DTableModel model = new DTableModel();
	public static long speed = 0x3FFF / 8;
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof DTableTile) {
			float rotation = (float) (360.0 * (System.currentTimeMillis() & speed) / speed);
			
//			glDisable(GL_LIGHTING);
			
			renderFrame(x, y, z);
			
			for (int i = 1; i <= 4; i++)
				renderPart(x, y, z, i, rotation);
			
//			glEnable(GL_LIGHTING);
			
		}
	}
	
	private void renderFrame(double x, double y, double z) {
		glPushMatrix();
		
		// Scale, Translate, Rotate
		glScalef(1.0F, 1.0F, 1.0F);
		glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.DTable);
		
		// Render
		model.renderFrame();
		glPopMatrix();
	}
	
	private void renderPart(double x, double y, double z, int part, float angle) {
		glPushMatrix();
		
		// Scale, Translate, Rotate
		glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
		
		if (part < 3) {
			GL11.glRotatef(part == 1 ? angle : -angle, 1F, 0F, 0F);
		} else {
			GL11.glRotatef(part == 3 ? -angle : angle, 0F, 0F, 1F);
		}
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.DTable);
		
		// Render
		model.renderPart(part);
		// if(part==1)
		// model.render();
		
		glPopMatrix();
	}
}
