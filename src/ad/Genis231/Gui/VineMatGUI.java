package ad.Genis231.Gui;

import ad.Genis231.lib.textures;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class VineMatGUI extends GuiScreen implements IInventory {
	
	int centerX, centerY;
	int imageX = 176, imageY = 165;
	
	public VineMatGUI(EntityPlayer player, World world, int x, int y, int z) {}
	
	@Override public void drawScreen(int par1, int par2, float par3) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(textures.VM);
		this.drawTexturedModalRect((width - imageX) / 2, (height - imageY) / 2, 0, 0, imageX, imageY);
	}
	
	@Override public int getSizeInventory() {
		return 1;
	}
	
	@Override public ItemStack getStackInSlot(int slot) {
		return null;
	}
	
	@Override public ItemStack decrStackSize(int var1, int var2) {
		return null;
	}
	
	@Override public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}
	
	@Override public void setInventorySlotContents(int var1, ItemStack var2) {}
	
	@Override public String getInventoryName() {
		return "Vine Mat Inventory";
	}
	
	@Override public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override public int getInventoryStackLimit() {
		return 9999;
	}
	
	@Override public void markDirty() {}
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}
	
	@Override public void openInventory() {}
	
	@Override public void closeInventory() {}
	
	@Override public boolean isItemValidForSlot(int slot, ItemStack item) {
		return true;
	}
}
