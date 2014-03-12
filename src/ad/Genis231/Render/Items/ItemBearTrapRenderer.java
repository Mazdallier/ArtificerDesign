package ad.Genis231.Render.Items;

import ad.Genis231.Models.Blocks.BearTrapModel;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import static org.lwjgl.opengl.GL11.*;

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
				renderModel(0.1F, 0.2F, 0.1F, 2F);
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
		
		glPushMatrix();
		
		// Scale, Translate, Rotate
		glScalef(size, size, size);
		glTranslatef(x, y, z);
		glRotatef(0F, 1F, 0, 0);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.BearTrap);
		
		// Render
		model.randerAll();
		
		glPopMatrix();
	}
}
