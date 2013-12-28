package ad.Genis231.Blocks;

import ad.Genis231.Blocks.drill.DrillThread;
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
	
	Thread DrillThread;
	
	public Drill(int id) {
		super(id, Material.rock);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighbor) {
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && !world.isRemote) {
			DrillThread = new Thread(new DrillThread(world, x, y, z));
			DrillThread.start();
		}
	}
}
