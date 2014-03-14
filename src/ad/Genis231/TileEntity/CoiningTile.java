package ad.Genis231.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import ad.Genis231.Core.PacketHandler;

public class CoiningTile extends ADTileEntity implements IInventory {
	ItemStack[] inv = new ItemStack[2];
	
	public CoiningTile() {
		
	}
	
	@Override public int getSizeInventory() {
		return inv.length;
	}
	
	@Override public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}
	
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
	
	@Override public void setInventorySlotContents(int var1, ItemStack var2) {}
	
	@Override public String getInventoryName() {
		return "coiningMechine";
	}
	
	@Override public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 32;
	}
	
	@Override public void openInventory() {}
	
	@Override public void closeInventory() {}
	
	@Override public boolean isItemValidForSlot(int slot, ItemStack item) {
		return slot == 1 && item.getItem() == Items.gold_nugget;
	}
}
