package ad.Genis231.Core.Resources;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.Minecraft;
import net.minecraft.command.IEntitySelector;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class InventoryHelper{
	private static Minecraft mc = Minecraft.getMinecraft();

	public static ItemStack getItem(IInventory inv,int slot){
		if(inv.getSizeInventory() < slot && inv != null) return inv.getStackInSlot(slot);
		return null;
	}

	public static IInventory getInventorySide(ForgeDirection dir,World world,int x,int y,int z){
		return getInventory(world,x + dir.offsetX,y + dir.offsetY,z + dir.offsetZ);
	}

	//Copied code from Vanilla Minecraft Hopper code
	public static IInventory getInventory(World world,int fx,int fy,int fz){
		IInventory iinventory = null;
		int x = MathHelper.floor_double(fx);
		int y = MathHelper.floor_double(fy);
		int z = MathHelper.floor_double(fz);
		TileEntity tileentity = world.getTileEntity(x,y,z);

		if(tileentity != null && tileentity instanceof IInventory){
			iinventory = (IInventory) tileentity;

			if(iinventory instanceof TileEntityChest){
				Block block = world.getBlock(x,y,z);

				if(block instanceof BlockChest){
					iinventory = ((BlockChest) block).func_149951_m(world,x,y,z);
				}
			}
		}

		if(iinventory == null){
			List list = world.getEntitiesWithinAABBExcludingEntity(null,AxisAlignedBB.getAABBPool().getAABB(fx,fy,fz,fx + 1.0D,fy + 1.0D,fz + 1.0D),IEntitySelector.selectInventories);

			if(list != null && list.size() > 0){
				iinventory = (IInventory) list.get(world.rand.nextInt(list.size()));
			}
		}

		return iinventory;
	}

	public static boolean addBlock(IInventory inv,ItemStack temp){
		ItemStack item = temp.copy();
		ItemStack invItem;

		if(inv != null) for(int i = 0; i < inv.getSizeInventory() && item.stackSize > 0; i++){
			invItem = inv.getStackInSlot(i);
			if(inv.isItemValidForSlot(i,item)){
				if(invItem != null || invItem == item){
					if(invItem.stackSize < invItem.getMaxStackSize()){
						if(invItem.stackSize + item.stackSize <= invItem.getMaxStackSize()){
							inv.setInventorySlotContents(i,new ItemStack(item.getItem(),invItem.stackSize + item.stackSize));
							inv.markDirty();
							item.stackSize = (invItem.stackSize + item.stackSize) - item.getMaxStackSize();
						}else{
							inv.setInventorySlotContents(i,new ItemStack(item.getItem(),item.getMaxStackSize()));
							inv.markDirty();
							inv.markDirty();
							item.stackSize = (invItem.stackSize + item.stackSize) - item.getMaxStackSize();
						}
					}
				}else if(invItem == null || invItem.stackSize<=0){
					inv.setInventorySlotContents(i,item);
					inv.markDirty();
					item.stackSize = 0;
				}
			}
		}
		return item.stackSize <=0;
	}
}

