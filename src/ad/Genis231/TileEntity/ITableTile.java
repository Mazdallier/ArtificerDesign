package ad.Genis231.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import ad.Genis231.BaseClasses.ADTileEntity;

public class ITableTile extends ADTileEntity implements IInventory {
	
	private ItemStack[] TableContents;
	
	public ITableTile(int size) {
		TableContents = new ItemStack[size];
	}
	
	@Override
	public int getSizeInventory() {
		return TableContents.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return TableContents[slot];
	}
	
	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int slot, ItemStack ItemStack) {
		this.TableContents[slot] = ItemStack;
		
		if (ItemStack != null && ItemStack.stackSize > this.getInventoryStackLimit()) ItemStack.stackSize = this.getInventoryStackLimit();
		
		this.onInventoryChanged();
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amountMoved) {
		if (this.TableContents[slot] != null) {
			ItemStack itemstack;
			
			if (this.TableContents[slot].stackSize <= amountMoved) {
				itemstack = this.TableContents[slot];
				this.TableContents[slot] = null;
				this.onInventoryChanged();
				return itemstack;
			} else {
				itemstack = this.TableContents[slot].splitStack(amountMoved);
				
				if (this.TableContents[slot].stackSize == 0) {
					this.TableContents[slot] = null;
				}
				
				this.onInventoryChanged();
				return itemstack;
			}
		} else {
			return null;
		}
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
	@Override
	public void openChest() {}
	
	@Override
	public void closeChest() {}
	
	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		this.TableContents = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;
			
			if (j >= 0 && j < this.TableContents.length) {
				this.TableContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}
	
	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.TableContents.length; ++i) {
			if (this.TableContents[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.TableContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		
		par1NBTTagCompound.setTag("Items", nbttaglist);
	}
	
	@Override
	public String getInvName() {
		return "ImbueingTable";
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return false;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
