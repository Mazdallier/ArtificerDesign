package ad.Genis231.Render.Blocks;

import ad.Genis231.Models.Blocks.SpikeModel;
import ad.Genis231.TileEntity.model.SpikeTile;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import static org.lwjgl.opengl.GL11.*;

@SideOnly(Side.CLIENT) public class SpikeTileRenderer extends TileEntitySpecialRenderer {
	
	private SpikeModel model = new SpikeModel();
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof SpikeTile) {
			
			glPushMatrix();
			
			// Scale, Translate, Rotate
			glScalef(1.0F, 1.0F, 1.0F);
			glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);
			
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.Spike);
			
			// Render
			model.render();
			glPopMatrix();
		}
	}
}
