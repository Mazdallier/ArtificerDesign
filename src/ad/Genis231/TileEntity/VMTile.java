package ad.Genis231.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class VMTile extends TileEntity implements IInventory {
	
	private ItemStack[] inv= new ItemStack[2];
	
	@Override public ItemStack decrStackSize(int slot, int amountMoved) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amountMoved)
				setInventorySlotContents(slot, null);
			else {
				stack = stack.splitStack(amountMoved);
				if (stack.stackSize == 0)
					setInventorySlotContents(slot, null);
			}
		}
		return stack;
	}
	
	@Override public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		
		if (stack != null)
			setInventorySlotContents(slot, null);
		
		return stack;
	}
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
	@Override public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}
	
	@Override public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
	}
	
	@Override public int getSizeInventory() {
		return inv.length;
	}
	
	@Override public String getInventoryName() {
		return "VM";
	}
	
	@Override public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
	@Override public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override public void openInventory() {}
	
	@Override public void closeInventory() {}
	
	@Override public int getInventoryStackLimit() {
		return 64;
	}
}
