package ad.Genis231.Render.Blocks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.BearTrapModel;
import ad.Genis231.Render.TileEntity.BearTrapTile;
import ad.Genis231.Render.TileEntity.SpikeTile;
import ad.Genis231.lib.textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BtrapRenderer extends TileEntitySpecialRenderer {
	
	private static BearTrapModel Model = new BearTrapModel();
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof BearTrapTile) {
			
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			
			GL11.glPushMatrix();
			
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
			
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.BearTrap);
			
			// Render
			Model.RenderBase();
			Model.RenderSide();
			GL11.glPopMatrix();
			
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_LIGHTING);
		}
	}
}
