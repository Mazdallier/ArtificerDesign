package ad.Genis231.Render.Blocks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.SpikeModel;
import ad.Genis231.TileEntity.model.SpikeTile;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class SpikeTileRenderer extends TileEntitySpecialRenderer {
	
	private SpikeModel model = new SpikeModel();
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof SpikeTile) {
			
			GL11.glPushMatrix();
			
			// Scale, Translate, Rotate
			
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);
			
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.Spike);
			
			// Render
			model.render();
			GL11.glPopMatrix();
		}
	}
}
