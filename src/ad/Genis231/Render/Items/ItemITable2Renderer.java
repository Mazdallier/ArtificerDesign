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
import ad.Genis231.Models.Blocks.ITableModel;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ItemITable2Renderer implements IItemRenderer {
	private ITableModel model;
	
	public ItemITable2Renderer() {
		model = new ITableModel();
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
				renderTable(0F, 0.0F, 0F, 2F);
				break;
			
			case EQUIPPED:
				renderTable(0.2F, 0.0F, 0.2F, 1F);
				break;
			
			case EQUIPPED_FIRST_PERSON:
				renderTable(0F, 0.9F, 0.7F, 0.75F);
				break;
			
			case INVENTORY:
				renderTable(1.5F, 0.75F, 1.5F, 1F);
				break;
			default:
				break;
		}
	}
	
	private void renderTable(float x, float y, float z, float scale) {
		
		glPushMatrix();
		glDisable(GL_LIGHTING);
		
		// Scale, Translate, Rotate
		glScalef(scale, scale, scale);
		glTranslatef(x, y, z);
		glRotatef(0F, 1F, 0, 0);
		
		// Bind texture
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(BlockTexture.ITable);
		
		// Render
		model.renderPart(0);
		model.renderPart(1);
		model.renderPart(2);
		
		// Itable.renderAll();
		
		glEnable(GL_LIGHTING);
		glPopMatrix();
		
	}
}
