package ad.Genis231.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import ad.Genis231.BaseClasses.ADTileEntity;

public class ITableTile extends ADTileEntity implements IInventory {
	
	private ItemStack[] inv;
	
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
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
	@Override public void openChest() {}
	
	@Override public void closeChest() {}
	
	@Override public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		
		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length)
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			
		}
	}
	
	@Override public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		
		NBTTagList TagData = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				TagData.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", TagData);
	}
	
	@Override public String getInvName() {
		return "ImbueingTable";
	}
	
	@Override public boolean isInvNameLocalized() {
		return false;
	}
	
	@Override public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}
