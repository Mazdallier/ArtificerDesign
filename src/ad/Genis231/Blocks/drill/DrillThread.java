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
	int trueX, trueY, trueZ;
	
	int[] Unbreakable = { Block.waterMoving.blockID, Block.waterMoving.blockID, 0, Block.lavaMoving.blockID, Block.lavaStill.blockID, Block.chest.blockID, Block.chestTrapped.blockID, Block.bedrock.blockID };
	
	public DrillThread(World wo, int q, int w, int e) {
		world = wo;
		trueX = q;
		trueY = w;
		trueZ = e;
	}
	
	@Override
	public void run() {
		
		try {
			int[] array = MinMax(5);
			if (!world.isRemote) {
				for (int fy = trueY - 1; fy > 0; fy--) {
					for (int fx = array[0]; fx <= array[1]; fx++) {
						for (int fz = array[2]; fz <= array[3]; fz++) {
							if (world.getBlockId(trueX, trueY, trueZ) != blocks.Drill.blockID || !world.isBlockIndirectlyGettingPowered(trueX, trueY, trueZ)) return;
							
							else if (check(world.getBlockId(fx, fy, fz))) {
								Thread.sleep(100);
								
								dropBlock(world, fx, fy, fz);
								System.out.println("X: " + fx + " Y: " + fy + " Z: " + fz);
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
		
		Block.blocksList[id].dropBlockAsItem(wo, trueX, trueY + 2, trueZ, meta, 0);
		
	}
	
	boolean check(int i) {
		for (int str : Unbreakable) {
			if (str == i) return false;
		}
		return true;
	}
	
	int[] MinMax(int area) {
		int[] array = new int[4];
		int temp;
		
		int minX = trueX - area;
		int maxX = trueX + area;
		
		int minZ = trueZ - area;
		int maxZ = trueZ + area;
		
		array[0] = minX;
		array[1] = maxX;
		array[2] = minZ;
		array[3] = maxZ;
		
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		return array;
	}
}
