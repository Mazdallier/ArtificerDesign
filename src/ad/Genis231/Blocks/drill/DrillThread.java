package ad.Genis231.Blocks.drill;

import java.util.List;

import ad.Genis231.Blocks.blocks;
import ad.Genis231.lib.ADLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.Hopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class DrillThread implements Runnable {
	World world;
	int x, y, z;
	
	int[] Unbreakable = { Block.waterMoving.blockID, Block.waterMoving.blockID, 0, Block.lavaMoving.blockID, Block.lavaStill.blockID, Block.chest.blockID, Block.chestTrapped.blockID, Block.bedrock.blockID };
	
	public DrillThread(World wo, int q, int w, int e) {
		world = wo;
		x = q;
		y = w;
		z = e;
	}
	
	@Override
	public void run() {
		int area = 5;
		
		int minX = x - area;
		int maxX = x + area;
		
		int minZ = z - area;
		int maxZ = z + area;
		
		try {
			if (!world.isRemote) {
				for (int fy = y - 1; fy > 0; fy--) {
					for (int fx = minX; fx <= maxX; fx++) {
						for (int fz = minZ; fz <= maxZ; fz++) {
							if (world.getBlockId(x, y, z) != blocks.Drill.blockID || !world.isBlockIndirectlyGettingPowered(x, y, z)) return;
							
							else if (check(world.getBlockId(fx, fy, fz))) {
								Thread.sleep(100);
								
								dropBlock(world, fx, fy, fz);
								world.setBlockToAir(fx, fy, fz);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			ADLog.logger.info("~~~~~Thread Failed~~~~~");
		}
	}
	
	public void dropBlock(World wo, int fx, int fy, int fz) {
		int id = wo.getBlockId(fx, fy, fz);
		
		int meta = wo.getBlockMetadata(fx, fy, fz);
		wo.playAuxSFX(2001, fx, fy, fz, id + (meta << 12));
		
		Block.blocksList[id].dropBlockAsItem(wo, x, y+2, z, meta, 0);
		
	}
	
	boolean check(int i) {
		for (int str : Unbreakable) {
			if (str == i) return false;
		}
		
		return true;
	}
}

@Deprecated
class roarz {
	public static void insertItem(IInventory Inventory, Block block, int meta) {
		for (int i = 0; i <= Inventory.getSizeInventory(); i++) {
			ADLog.logger.info("Slot: " + i + " Inventory Limit: " + Inventory.getSizeInventory());
			
			if (Inventory.getStackInSlot(i).stackSize < 64 && Inventory.getStackInSlot(i).itemID == block.blockID) {
				Inventory.setInventorySlotContents(0, new ItemStack(block, Inventory.getStackInSlot(i).stackSize + 1, meta));
				ADLog.logger.info("Stack Size: " + Inventory.getStackInSlot(i).stackSize);
			}
			
			ADLog.logger.info("Stack Size: " + Inventory.getStackInSlot(i).stackSize);
			ADLog.logger.info("Checked Slot: " + i);
		}
	}
	
	public static IInventory getInventoryAtLocation(World world, int x, int y, int z) {
		IInventory iinventory = null;
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if (entity != null && entity instanceof IInventory) {
			iinventory = (IInventory) entity;
			
			int blockID = world.getBlockId(x, y, z);
			Block block = Block.blocksList[blockID];
			
			iinventory = ((BlockChest) block).getInventory(world, x, y, z);
			
		}
		
		return iinventory;
	}
}
