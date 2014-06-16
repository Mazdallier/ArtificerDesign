package ad.Genis231.Resources;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class InventoryHelper {
	public static ItemStack getItem(IInventory inv, int slot) {
		if (inv.getSizeInventory() < slot && inv != null)
			return inv.getStackInSlot(slot);
		return null;
	}
	
	public static IInventory getInventorySide(ForgeDirection dir, World world, int x, int y, int z) {
		return getInventory(world, x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
	}
	
	public static IInventory getInventoryAround(World world, int x, int y, int z, ItemStack item) {
		IInventory chest;
		
		for (ForgeDirection dir : ForgeDirection.values()) {
			chest = InventoryHelper.getInventorySide(dir, world, x, y, z);
			if (chest != null && hasOpenSlots(chest, item))
				return chest;
		}
		
		return null;
	}
	
	// Copied code from Vanilla Minecraft Hopper code
	public static IInventory getInventory(World world, int x, int y, int z) {
		IInventory inventory = null;
		
		TileEntity tileentity = world.getTileEntity(x, y, z);
		
		if (tileentity != null && tileentity instanceof IInventory) {
			inventory = (IInventory) tileentity;
			
			if (inventory instanceof TileEntityChest) {
				Block block = world.getBlock(x, y, z);
				
				if (block instanceof BlockChest) {
					inventory = ((BlockChest) block).func_149951_m(world, x, y, z);
				}
			}
		}
		
		if (inventory == null) {
			List list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, AxisAlignedBB.getAABBPool().getAABB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D), IEntitySelector.selectInventories);
			
			if (list != null && list.size() > 0) {
				inventory = (IInventory) list.get(world.rand.nextInt(list.size()));
			}
		}
		
		return inventory;
	}
	
	public static boolean addBlock(IInventory inv, ItemStack temp) {
		ItemStack item = temp.copy();
		ItemStack invItem;
		
		if (inv != null && item != null) {
			for (int slot = 0; slot < inv.getSizeInventory() && item.stackSize > 0; slot++) {
				invItem = inv.getStackInSlot(slot);
				if (inv.isItemValidForSlot(slot, item)) {
					if (invItem != null || invItem == item) {
						if (invItem.stackSize < invItem.getMaxStackSize() && invItem.getItem() == item.getItem() && invItem.getItemDamage() == item.getItemDamage()) {
							if (invItem.stackSize + item.stackSize < invItem.getMaxStackSize()) {
								inv.setInventorySlotContents(slot, new ItemStack(item.getItem(), invItem.stackSize + item.stackSize, item.getItemDamage()));
								item = null;
								return true;
							} else {
								inv.setInventorySlotContents(slot, new ItemStack(item.getItem(), item.getMaxStackSize(), item.getItemDamage()));
								item.stackSize = (invItem.stackSize + item.stackSize) - item.getMaxStackSize();
							}
						}
					} else if (invItem == null || invItem.stackSize <= 0) {
						inv.setInventorySlotContents(slot, item);
						item = null;
						return true;
						
					}
				}
			}
			
			inv.markDirty();
		}
		
		if (item == null)
			return true;
		
		return item.stackSize <= 0;
	}
	
	public static boolean hasOpenSlots(IInventory inv, ItemStack item) {
		if (item == null)
			return false;
		
		int stackLimit = item.getMaxStackSize();
		
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack current = inv.getStackInSlot(i);
			
			if (current == null || inv == null)
				return true;
			
			if (current == item) {
				if (current.stackSize + item.stackSize <= stackLimit)
					return true;
			}
		}
		return false;
		
	}
}
