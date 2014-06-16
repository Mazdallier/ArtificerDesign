package ad.Genis231.TileEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import ad.Genis231.Resources.ADTileEntity;
import ad.Genis231.Resources.InventoryHelper;

public class PipeTileEntity extends ADTileEntity implements IInventory {
	ForgeDirection last;
	HashMap<ForgeDirection, ArrayList<ItemStack>> map;
	
	public PipeTileEntity() {
		map = new HashMap<ForgeDirection, ArrayList<ItemStack>>();
		
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
			map.put(dir, new ArrayList<ItemStack>());
		
	}
	
	public void updateEntity() {
		if (this.worldObj.isRemote)
			return;
		
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS)
			if (map.get(dir) != null)
				for (ForgeDirection mainDir : ForgeDirection.VALID_DIRECTIONS) {
					TileEntity temp = this.worldObj.getTileEntity(xCoord + mainDir.offsetX, yCoord + mainDir.offsetY, zCoord + mainDir.offsetZ);
					if (temp != null && dir != mainDir)
						
						if (temp instanceof IInventory && map.get(mainDir) != null) {
							List<ItemStack> newList = new ArrayList<ItemStack>();
							
							for (ItemStack item : map.get(mainDir))
								if (InventoryHelper.addBlock((IInventory) temp, item))
									newList.add(item);
							
							for (ItemStack item : newList)
								map.get(mainDir).remove(item);
							
						} else if (temp instanceof PipeTileEntity)
							((PipeTileEntity) temp).sendItems(map.get(mainDir), mainDir.getOpposite());
				}
	}
	
	public void sendItems(List<ItemStack> itemList, ForgeDirection dir) {
		List<ItemStack> temp = new ArrayList<ItemStack>();
		
		temp = map.get(dir);
		
		for (ItemStack item : itemList)
			temp.add(item);
	}
	
	// TODO: FIX THIS SHIT
	public void writeToNBT(NBTTagCompound NBT) {
		super.writeToNBT(NBT);
		
		List<ItemStack> list = new ArrayList<ItemStack>();
		
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			if (map.get(dir) != null && !map.get(dir).isEmpty())
				for (ItemStack item : map.get(dir))
					list.add(item);
		}
		
		NBTTagList tagList = new NBTTagList();
		NBTTagCompound temp = new NBTTagCompound();
		
		for (ItemStack item : list) {
			item.writeToNBT(temp);
			tagList.appendTag(temp);
			list.remove(item);
		}
		
		NBT.setTag("Items", tagList);
	}
	
	// TODO: FIX THIS SHIT
	public void readFromNBT(NBTTagCompound NBT) {
		super.readFromNBT(NBT);
		
		NBTTagList tagList = NBT.getTagList("Items", 10);
		
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = tagList.getCompoundTagAt(i);
			map.get(ForgeDirection.NORTH).add(ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}
	}
	
	@Override public int getSizeInventory() {
		return 1;
	}
	
	@Override public ItemStack getStackInSlot(int var1) {
		return null;
	}
	
	@Override public ItemStack decrStackSize(int var1, int var2) {
		return null;
	}
	
	@Override public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}
	
	@Override public void setInventorySlotContents(int slot, ItemStack item) {
		map.get(ForgeDirection.UP).add(item);
	}
	
	@Override public String getInventoryName() {
		return "GenericPipes";
	}
	
	@Override public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override public boolean isUseableByPlayer(EntityPlayer var1) {
		return false;
	}
	
	@Override public void openInventory() {}
	
	@Override public void closeInventory() {}
	
	@Override public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}
}
