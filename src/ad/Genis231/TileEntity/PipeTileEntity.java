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
		
		for (ForgeDirection dir : ForgeDirection.values())
			map.put(dir, new ArrayList<ItemStack>());
		
	}
	
	public void updateEntity() {
		if (worldObj.isRemote)
			return;
		
		for (ForgeDirection mainDir : ForgeDirection.VALID_DIRECTIONS)
			for (ForgeDirection cycle : ForgeDirection.VALID_DIRECTIONS) {
				TileEntity tile = worldObj.getTileEntity(xCoord + cycle.offsetX, yCoord + cycle.offsetY, zCoord + cycle.offsetZ);
				
				if (tile != null && mainDir != cycle && !map.get(cycle).isEmpty()) {
					if (tile instanceof IInventory && !(tile instanceof PipeTileEntity)) {
						List<ItemStack> newList = new ArrayList<ItemStack>();
						for (ItemStack item : map.get(cycle))
							if (InventoryHelper.addBlock((IInventory) tile, item))
								newList.add(item);
						
						for (ItemStack item : newList)
							map.get(cycle).remove(item);
					} else if (tile instanceof PipeTileEntity) {
						((PipeTileEntity) tile).sendItems(map.get(cycle), cycle.getOpposite());
						map.get(cycle).clear();
					}
				}
			}
	}
	
	public void sendItems(List<ItemStack> itemList, ForgeDirection dir) {
		for (ItemStack item : itemList)
			map.get(dir).add(item);
	}
	
	public void writeToNBT(NBTTagCompound NBT) {
		super.writeToNBT(NBT);
		
		for (int i = 0; i < 6; i++) {
			NBTTagList tagList = new NBTTagList();
			NBTTagCompound temp = new NBTTagCompound();
			
			List<ItemStack> list = map.get(ForgeDirection.values()[i]);
			for (ItemStack item : list) {
				item.writeToNBT(temp);
				tagList.appendTag(temp);
				list.remove(item);
			}
			NBT.setTag("Items_" + i, tagList);
		}
		
	}
	
	public void readFromNBT(NBTTagCompound NBT) {
		super.readFromNBT(NBT);
		
		for (int count = 0; count < 6; count++) {
			NBTTagList tagList = NBT.getTagList("Items_" + count, 10);
			
			for (int i = 0; i < tagList.tagCount(); i++) {
				NBTTagCompound temp = tagList.getCompoundTagAt(i);
				map.get(ForgeDirection.values()[count]).add(ItemStack.loadItemStackFromNBT(temp));
			}
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
		map.get(ForgeDirection.DOWN).add(item);
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
