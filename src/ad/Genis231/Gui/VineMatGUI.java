package ad.Genis231.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import ad.Genis231.lib.textures;

public class VineMatGUI extends GuiContainer {
	int imageX = 176, imageY = 165;
	
	public VineMatGUI(EntityPlayer player) {
		super(player.inventoryContainer);
	}
	
	@Override protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(textures.VM);
		this.drawTexturedModalRect((width - imageX) / 2, (height - imageY) / 2, 0, 0, imageX, imageY);
	}
	
}
