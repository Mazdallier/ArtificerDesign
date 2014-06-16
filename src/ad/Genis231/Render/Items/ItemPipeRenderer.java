package ad.Genis231.Render.Items;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import ad.Genis231.Models.Blocks.PipeModel;
import ad.Genis231.Refrence.textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ItemPipeRenderer implements IItemRenderer {
	
	private PipeModel model;
	
	public ItemPipeRenderer() {
		
		model = new PipeModel();
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
				renderSpikes(0.0F, 0.0F, -0.0F, 3F, false);
				return;
				
			case EQUIPPED:
				renderSpikes(0.7F, 0.3F, 0.0F, 2F, false);
				return;
				
			case EQUIPPED_FIRST_PERSON:
				renderSpikes(0.5F, -0.3F, 0.375F, 3F, false);
				return;
				
			case INVENTORY:
				renderSpikes(0.0F, -0.225F, -0.7F, 3.5F, true);
				return;
			default:
				break;
		}
	}
	
	private void renderSpikes(float x, float y, float z, float size, boolean rotate) {
		
		glPushMatrix();
		// glDisable(GL_LIGHTING);
		
		// Scale, Translate, Rotate
		glScalef(size, size, size);
		glTranslatef(x, y, z);
		
		if (rotate) {
			glRotatef(50F, 1F, 0, 0);
			glRotatef(35F, 0, 1F, 0);
			glRotatef(60F, 0, 0, 1F);
		}
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.Pipe);
		
		// Render
		
		for (int i = 0; i < 6; i++)
			model.renderPart(i, false);
		
		// glEnable(GL_LIGHTING);
		glPopMatrix();
	}
}
