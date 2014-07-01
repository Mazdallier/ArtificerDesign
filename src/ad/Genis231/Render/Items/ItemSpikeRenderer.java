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
import ad.Genis231.Models.Blocks.SpikeModel;
import ad.Genis231.Refrence.textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ItemSpikeRenderer implements IItemRenderer {
	
	private SpikeModel model;
	
	public ItemSpikeRenderer() {
		
		model = new SpikeModel();
	}
	
	@Override public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	
	@Override public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		switch (type) {
			case ENTITY:
				renderSpikes(-0.5F, 0.0F, 0.5F, 1.5F);
				return;
				
			case EQUIPPED:
				renderSpikes(-0.3F, 0.2F, 0.65F, 1.5F);
				return;
				
			case EQUIPPED_FIRST_PERSON:
				renderSpikes(0.0F, 0.7F, 1.0F, 1F);
				return;
				
			case INVENTORY:
				renderSpikes(0.0F, 0.1F, 1.0F, 1.1F);
				return;
			default:
				break;
		}
	}
	
	private void renderSpikes(float x, float y, float z, float size) {
		
		glPushMatrix();
		glDisable(GL_LIGHTING);
		
		// Scale, Translate, Rotate
		glScalef(size, size, size);
		glTranslatef(x, y, z);
		glRotatef(0F, 1F, 0, 0);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.Spike);
		
		// Render
		model.render();
		
		glEnable(GL_LIGHTING);
		glPopMatrix();
	}
	
	@Override public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
}
