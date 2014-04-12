package ad.Genis231.Render.Items;

import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.GenModel;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ItemGenRenderer implements IItemRenderer {
	
	private GenModel model;
	
	public ItemGenRenderer() {
		model = new GenModel();
	}
	
	@Override public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	@Override public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	@Override public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		switch (type) {
			case ENTITY:
				renderModel(0.0F, 0.0F, 0.0F, 1.0F);
				break;
			
			case EQUIPPED:
				renderModel(0.0F, 0.0F, 0.0F, 1.0F);
				break;
			
			case EQUIPPED_FIRST_PERSON:
				renderModel(0.0F, 0.25F, 0.5F, 1.0F);
				break;
			
			case INVENTORY:
				renderModel(0.0F, -0.5F, 0.0F, 1F);
				break;
			default:
				break;
		}
	}
	
	private void renderModel(float x, float y, float z, float size) {
		glDisable(GL11.GL_LIGHTING);
		glDisable(GL11.GL_CULL_FACE);
		
		glPushMatrix();
		glScalef(size, size, size);
		glTranslatef(x, y, z);
		glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.Generator);
		
		// Render
		model.render();
		glPopMatrix();
		
		glEnable(GL11.GL_CULL_FACE);
		glEnable(GL_LIGHTING);
	}
}
