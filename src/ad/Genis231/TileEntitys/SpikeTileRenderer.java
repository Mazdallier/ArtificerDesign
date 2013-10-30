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
	
	private SpikeModel modelSpike = new SpikeModel();
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof SpikeTile) {
			
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			
			GL11.glPushMatrix();
			
			// Scale, Translate, Rotate
			//RenderDirection(x, y, z, SpikeTrap.side);
			
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);
			
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("artificer", "textures/blocks/Spikes.png"));
			
			// Render
			modelSpike.render();
			GL11.glPopMatrix();
			
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_LIGHTING);
		}
	}
	
	private void RenderDirection(double x, double y, double z, int side) {
		
		switch (side) {
			case 0:
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				GL11.glTranslatef((float) x, (float) y, (float) z);
				GL11.glRotatef(90F, 1F, 0F, 0F);
				return;
				
			case 1:
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				GL11.glTranslatef((float) x, (float) y, (float) z);
				GL11.glRotatef(-90F, 1F, 0F, 0F);
				return;
				
			case 2:
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				GL11.glTranslatef((float) x, (float) y, (float) z);
				GL11.glRotatef(180F, 0F, 1F, 0F);
				return;
				
			case 4:
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				GL11.glTranslatef((float) x, (float) y, (float) z);
				GL11.glRotatef(-90F, 0F, 0F, 1F);
				return;
				
			case 5:
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				GL11.glTranslatef((float) x + 2.0F, (float) y, (float) z);
				GL11.glRotatef(90F, 0F, 0F, 1F);
				return;
				
			default:
				GL11.glScalef(1.0F, 1.0F, 1.0F);
				GL11.glTranslatef((float) x, (float) y, (float) z);
				return;
				
		}
	}
}