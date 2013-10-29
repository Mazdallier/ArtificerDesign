package ad.Genis231.TileEntitys;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ad.Genis231.Render.Models.Blocks.SpikeModel;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SpikeTileRenderer extends TileEntitySpecialRenderer {
	
	private SpikeModel modelAlchemyTable = new SpikeModel();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer#
	 * renderTileEntityAt(net.minecraft.tileentity.TileEntity, double, double,
	 * double, float)
	 */
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof SpikeTile) {
			// TODO Use the TileAlchemyTable to determine what circle to project on the server of the table
			SpikeTile tileAlchemyTable = (SpikeTile) tileEntity;
			
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			
			// Scale, Translate, Rotate
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);
			
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("artificer","textures/blocks/Spikes.png"));
			
			// Render
			modelAlchemyTable.render();
			
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}
	
}