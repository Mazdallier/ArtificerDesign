package ad.Genis231.Render.Items;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import ad.Genis231.Models.Blocks.DTableModel;
import ad.Genis231.Refrence.textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ItemDTableRenderer implements IItemRenderer {
	
	private DTableModel model;
	
	public ItemDTableRenderer() {
		
		model = new DTableModel();
	}
	
	@Override public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	@Override public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case ENTITY:
				renderModel(0F, 0.0F, 0F, 2F);
				return;
				
			case EQUIPPED:
				renderModel(0.4F, 0.1F, 0.4F, 1F);
				return;
				
			case EQUIPPED_FIRST_PERSON:
				renderModel(0F, 0.9F, 0.7F, 0.75F);
				return;
				
			case INVENTORY:
				renderModel(0.0F, -0.5F, 0.0F, 1F);
				return;
			default:
				break;
		}
	}
	
	private void renderModel(float x, float y, float z, float size) {
		
		glPushMatrix();
		
		// Scale, Translate, Rotate
		glScalef(size, size, size);
		glTranslatef(x, y, z);
		glRotatef(0F, 1F, 0, 0);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.DTable);
		
		// Render
		model.renderFrame();
		
		glPopMatrix();
		
		glPushMatrix();
		// Scale, Translate, Rotate
		glScalef(size, size, size);
		glTranslatef(x, y + 0.5F, z);
		glRotatef(0F, 1F, 0, 0);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.DTable);
		
		// Render
		for (int i = 1; i <= 4; i++)
			model.renderPart(i);
		
		// glEnable(GL_LIGHTING);
		glPopMatrix();
	}
	
	@Override public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
}
