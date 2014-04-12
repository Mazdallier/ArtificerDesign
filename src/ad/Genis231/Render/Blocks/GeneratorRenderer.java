package ad.Genis231.Render.Blocks;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.GenModel;
import ad.Genis231.TileEntity.GeneratorTile;
import ad.Genis231.lib.BlockTexture;

public class GeneratorRenderer extends TileEntitySpecialRenderer {
	
	private GenModel model = new GenModel();
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof GeneratorTile) {
			GL11.glDisable(GL11.GL_LIGHTING);
			glPushMatrix();
			
			glScalef(1.0F, 1.0F, 1.0F);
			glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			
			// Bind texture
			bindTexture(BlockTexture.Generator);
			
			// Render
			model.render();
			
			glPopMatrix();
			GL11.glEnable(GL11.GL_LIGHTING);
		}
	}
}
