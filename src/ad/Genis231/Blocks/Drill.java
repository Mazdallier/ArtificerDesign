package ad.Genis231.Blocks;

import ad.Genis231.lib.ADLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class Drill extends Block {
	
	public Drill(int id) {
		super(id, Material.rock);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighbor) {
		
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && !world.isRemote) {
			for (int i = y - 1; i > 0; i--) {
				blockBreak(world, x, i, z, 1);
			}
		}
	}
	
	public void blockBreak(World world, int x, int y, int z, int area) {
		int minX, minZ, maxX, maxZ;
		
		minX = x - area;
		maxX = x + area;
		
		minZ = z - area;
		maxZ = z + area;
		
		for (int xx = minX; xx <= maxX; xx++) {
			for (int zz = minZ; zz <= maxZ; zz++) {
				//Block.blocksList[l].dropBlockAsItem(world, xx, y, zz, i1, 0);
				world.destroyBlock(xx, y, zz, true);
			}
		}
	}
}
