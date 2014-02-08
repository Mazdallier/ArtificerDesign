package ad.Genis231.Render.Items;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.BearTrapModel;
import ad.Genis231.lib.textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ItemBearTrapRenderer implements IItemRenderer {
	
	private BearTrapModel model;
	
	public ItemBearTrapRenderer() {
		
		model = new BearTrapModel();
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
				renderModel(0F, 0.0F, 0F, 2F);
				return;
				
			case EQUIPPED:
				renderModel(0.0F, 0.2F, 0.3F, 2F);
				return;
				
			case EQUIPPED_FIRST_PERSON:
				renderModel(0F, 1F, 0.5F, 1F);
				return;
				
			case INVENTORY:
				renderModel(0.0F, 0F, 0.0F, 1.5F);
				return;
			default:
				break;
		}
	}
	
	private void renderModel(float x, float y, float z, float size) {
		
		GL11.glPushMatrix();
		
		// Scale, Translate, Rotate
		GL11.glScalef(size, size, size);
		GL11.glTranslatef(x, y, z);
		GL11.glRotatef(0F, 1F, 0, 0);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.BearTrap);
		
		// Render
		model.randerAll();
		
		GL11.glPopMatrix();
	}
}
