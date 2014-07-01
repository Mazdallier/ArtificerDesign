package ad.Genis231.Render.Blocks;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import ad.Genis231.Models.Blocks.DrillModel;
import ad.Genis231.Refrence.textures;
import ad.Genis231.TileEntity.DrillTileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class DrillRenderer extends TileEntitySpecialRenderer {
	private DrillModel Model = new DrillModel();
	DrillTileEntity tile;
	
	float scale = 1.0F;
	
	void renderDrill(double x, double y, double z, float rotate, int type) {
		glPushMatrix();
		
		glScalef(scale, scale, scale);
		glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
		
		glRotatef(-rotate, 0.0F, 1.0F, 0.0F);
		
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.Drill[type]);
		
		// Render
		Model.renderDrill();
		
		glPopMatrix();
	}
	
	void renderFrame(double x, double y, double z) {
		glPushMatrix();
		{
			glScalef(scale, scale, scale);
			glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.DrillFrame);
			
			// Render
			Model.renderFrame();
			
		}
		glPopMatrix();
	}
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		tile = (DrillTileEntity) tileEntity;
		
		if (tileEntity instanceof DrillTileEntity) {
			renderFrame(x, y, z);
			
			if (tile.getDrillType() != -1)
				renderDrill(x, y, z, tile.angle, tile.getDrillType());
		}
	}
}
