package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
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
		EntityItem entityitem;
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && !world.isRemote) {
			for (int i = y - 1; i > 0; i--) {
				entityitem = new EntityItem(world, x, y + 1, z);
				
				if (world.getBlockId(x, i, z) != Block.bedrock.blockID) {
					entityitem.dropItem(world.getBlockId(x, i, z), 1);
					world.destroyBlock(x, i, z, false);
					
				}
			}
		}
	}
	
}
