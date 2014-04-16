package ad.Genis231.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import ad.Genis231.Refrence.ADItems;
import ad.Genis231.Resources.ADTileEntity;

public class CoiningTile extends ADTileEntity implements IInventory {
	ItemStack[] inv;
	
	public CoiningTile() {
		inv = new ItemStack[2];
	}
	
	@Override public void updateEntity() {
		if (inv[0] != null) {
			if (inv[0].getItem() == Items.gold_nugget) {
				
				if (inv[1] != null) {
					if (inv[1].stackSize >= 64)
						return;
					
					inv[1].stackSize++;
					inv[0].stackSize--;
					
					if (inv[0].stackSize <= 0)
						inv[0] = null;
					
				} else {
					inv[1] = new ItemStack(ADItems.Coin, 0, 0);
				}
				
			}
		}
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
			setInventorySlotContents(slot, stack);
		
		return stack;
	}
	
	@Override public void setInventorySlotContents(int slot, ItemStack stack) {
		this.inv[slot] = stack;
		
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
	}
	
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
		switch (slot) {
			case 0:
				System.out.println("Slot One: " + item.getItem().getUnlocalizedName());
				return item.getItem() == Items.gold_nugget;
			case 1:
				System.out.println("Slot Two: " + item.getItem().getUnlocalizedName());
				return item.getItem() == ADItems.Coin;
			default:
				System.out.println("Invalid Slot");
				return false;
		}
	}
}
