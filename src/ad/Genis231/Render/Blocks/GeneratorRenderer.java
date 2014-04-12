package ad.Genis231.Render.Blocks;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.GenModel;
import ad.Genis231.TileEntity.GeneratorTile;
import ad.Genis231.lib.BlockTexture;
import buildcraft.code.LiquidStuff.FluidRenderer;
import buildcraft.code.LiquidStuff.RenderUtils;

public class GeneratorRenderer extends TileEntitySpecialRenderer {
	
	private GenModel model = new GenModel();
	
	@Override public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float tick) {
		
		if (tile instanceof GeneratorTile) {
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
			
			renderLiquid(tile, (float) x, (float) y, (float) z, FluidRegistry.WATER, 0);
			// renderLiquid(tile, (float) x, (float) y, (float) z, FluidRegistry.LAVA, 1);
		}
		
	}
	
	void renderLiquid(TileEntity tile, float x, float y, float z, Fluid fluid, int type) {
		
		FluidStack liquid = new FluidStack(fluid, 8);
		int color = 0xFFFFFF;
		int limit = 16;
		if (liquid == null || liquid.amount <= 0) { return; }
		
		int[] displayList = FluidRenderer.getFluidDisplayLists(liquid, tile.getWorldObj(), false);
		if (displayList == null)
			return;
		
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		bindTexture(FluidRenderer.getFluidSheet(liquid));
		RenderUtils.setGLColorFromInt(color);
		
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glScalef(0.3F, 0.5F, 0.3F);
		
		renderQuad(displayList, liquid, limit, type);
		
		GL11.glPopMatrix();
	}
	
	void renderQuad(int[] displayList, FluidStack liquid, int compacity, int type) {
		if (compacity < liquid.amount)
			liquid.amount = compacity;
		
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glTranslatef(1.2F, 0.34F, 1.85F);
		GL11.glRotatef(25.0F, 0.0F, 1.0F, 0.0F);
		GL11.glCallList(displayList[(int) ((float) liquid.amount / (float) (compacity) * (FluidRenderer.DISPLAY_STAGES - 1))]);
		
		GL11.glPopAttrib();
		
		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glTranslatef(1.2F, 0.34F, 1.85F);
		GL11.glRotatef(70.0F, 0.0F, 1.0F, 0.0F);
		GL11.glCallList(displayList[(int) ((float) liquid.amount / (float) (compacity) * (FluidRenderer.DISPLAY_STAGES - 1))]);
		
		GL11.glPopAttrib();
	}
}
