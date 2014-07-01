package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import ad.Genis231.Core.ADBlocks;
import ad.Genis231.Resources.ADBlockTile;

public class WindMill extends ADBlockTile {
	
	public WindMill(String name, String texture) {
		super(Material.rock, name, texture);
	}
	
	public void breakBlock(World world, int x, int y, int z, Block block, int unknown) {
		placeBlocks(world, x, y, z, Blocks.air);
	}
	
	public void onPostBlockPlaced(World world, int x, int y, int z, int meta) {
		placeBlocks(world, x, y, z, ADBlocks.airBlock);
		
		world.setBlock(x + 1, y, z, ADBlocks.windmillMast);
	}
	
	void placeBlocks(World world, int x, int y, int z, Block block) {
		for (int i = z - 2; i < z + 3; i++)
			for (int q = y - 2; q < y + 3; q++) {
				world.setBlock(x + 1, q, i, block);
			}
	}
}
