package ad.Genis231.Render.Items;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
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
		switch (helper) {
			case BLOCK_3D:
				return true;
			case ENTITY_BOBBING:
				return true;
			case ENTITY_ROTATION:
				return true;
			case EQUIPPED_BLOCK:
				return false;
			case INVENTORY_BLOCK:
				return false;
			default:
				return true;
		}
	}
	
	@Override public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		switch (type) {
			case ENTITY:
				renderModel(0.0F, 0.0F, 0.0F, 1.0F, false);
				break;
				
			case EQUIPPED:
				renderModel(0.0F, 0.0F, 0.0F, 1.0F, false);
				break;
				
			case EQUIPPED_FIRST_PERSON:
				renderModel(0.75F, 0.5F, 0.2F, 0.5F, false);
				break;
				
			case INVENTORY:
				// renderModel(0.0F, -0.5F, 0.0F, 1F);
				renderModel(0.6F, 1.1F, 0.0F, 13F, true);
				break;
			default:
				break;
		}
	}
	
	/** Arguments:
	 * @param x
	 * @param y
	 * @param z
	 * @param size */
	private void renderModel(float x, float y, float z, float size, boolean flip) {
		GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
		glPushMatrix();
		// Scale, Translate, Rotate
		glScalef(size, size, size);
		glTranslatef(x, y, z);
		glRotatef(-90F, 0.0F, 1.0F, 0.0F);
		
		if (flip)
			glRotatef(180F, 0.0F, 0.0F, 1.0F);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.Generator);
		
		// Render
		model.render();
		
		glEnable(GL_LIGHTING);
		glPopMatrix();
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_LIGHTING);
	}
}
