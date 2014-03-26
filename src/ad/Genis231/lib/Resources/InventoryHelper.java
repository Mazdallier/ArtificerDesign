package ad.Genis231.lib.Resources;

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
import net.minecraft.util.MathHelper;
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
		IInventory iinventory = null;
		int i = MathHelper.floor_double(x);
		int j = MathHelper.floor_double(y);
		int k = MathHelper.floor_double(z);
		TileEntity tileentity = world.getTileEntity(i, j, k);
		
		if (tileentity != null && tileentity instanceof IInventory) {
			iinventory = (IInventory) tileentity;
			
			if (iinventory instanceof TileEntityChest) {
				Block block = world.getBlock(i, j, k);
				
				if (block instanceof BlockChest) {
					iinventory = ((BlockChest) block).func_149951_m(world, i, j, k);
				}
			}
		}
		
		if (iinventory == null) {
			List list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, AxisAlignedBB.getAABBPool().getAABB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D), IEntitySelector.selectInventories);
			
			if (list != null && list.size() > 0) {
				iinventory = (IInventory) list.get(world.rand.nextInt(list.size()));
			}
		}
		
		return iinventory;
	}
	
	public static boolean addBlock(IInventory inv, ItemStack temp) {
		ItemStack item = temp.copy();
		ItemStack invItem;
		
		if (inv != null)
			for (int i = 0; i < inv.getSizeInventory() && item.stackSize > 0; i++) {
				invItem = inv.getStackInSlot(i);
				if (inv.isItemValidForSlot(i, item)) {
					if (invItem != null || invItem == item) {
						if (invItem.stackSize < invItem.getMaxStackSize() && invItem.getItem() == item.getItem() && invItem.getItemDamage() == item.getItemDamage()) {
							if (invItem.stackSize + item.stackSize <= invItem.getMaxStackSize()) {
								inv.setInventorySlotContents(i, new ItemStack(item.getItem(), invItem.stackSize + item.stackSize, item.getItemDamage()));
								inv.markDirty();
								item.stackSize = (invItem.stackSize + item.stackSize) - item.getMaxStackSize();
							} else {
								inv.setInventorySlotContents(i, new ItemStack(item.getItem(), item.getMaxStackSize(), item.getItemDamage()));
								inv.markDirty();
								item.stackSize = (invItem.stackSize + item.stackSize) - item.getMaxStackSize();
							}
						}
					} else if (invItem == null || invItem.stackSize <= 0) {
						inv.setInventorySlotContents(i, item);
						inv.markDirty();
						item.stackSize = 0;
					}
				}
			}
		return item.stackSize <= 0;
	}
	
	public static boolean hasOpenSlots(IInventory inv, ItemStack item) {
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack current = inv.getStackInSlot(i);
			
			if (current == null)
				return true;
			else if (item != null && current.getItem() == item.getItem() && current.getItemDamage() == item.getItemDamage()) {
				if (current.stackSize + item.stackSize <= item.getMaxStackSize())
					return true;
			}
		}
		return false;
		
	}
}
