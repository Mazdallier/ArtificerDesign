package ad.Genis231.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ad.Genis231.BaseClasses.ADTileEntity;

public class ITableTile extends ADTileEntity implements IInventory {
	
	private ItemStack[] inv;
	
	float count = 0;
	
	public ITableTile(int size) {
		inv = new ItemStack[size];
	}
	
	@Override public int getSizeInventory() {
		return inv.length;
	}
	
	@Override public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}
	
	@Override public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
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
	
	@Override public int getInventoryStackLimit() {
		return 1;
	}
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
	@Override public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		
		count = tagCompound.getFloat("GUI");
	}
	
	@Override public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		
		tagCompound.setFloat("GUI", count);
	}
	
	@Override public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
	public boolean hasItem() {
		for (int i = 0; i < this.inv.length; i++) {
			if (inv[i] != null)
				return true;
		}
		return false;
	}
	
	public float getBurn() {
		return count;
	}
	
	public void updateEntity() {
		if (hasItem())
			if (count >= 20)
				count = 0;
			else
				count++;
	}
	
	@Override public String getInventoryName() {
		return "Imbueing Table";
	}
	
	@Override public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override public void openInventory() {
		// TODO Auto-generated method stub
		
	}
	
	@Override public void closeInventory() {
		// TODO Auto-generated method stub
		
	}
}
