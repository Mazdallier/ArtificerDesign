package ad.Genis231.TileEntity;

import ad.Genis231.BaseClass.ADTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ITableTile extends ADTileEntity implements IInventory {
	
	private ItemStack[] inv;
	
	public float rate = 20;
	float count;
	
	public ITableTile(int size) {
		inv = new ItemStack[size];
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
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 32;
	}
	
	@Override public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		count = tagCompound.getFloat("gui_pos");
	}
	
	@Override public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setFloat("gui_pos", count);
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
		if (hasItem()) {
			this.markDirty();
			if (count >= rate)
				count = 0;
			else
				count++;
		}
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
		return "Imbueing Table";
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
