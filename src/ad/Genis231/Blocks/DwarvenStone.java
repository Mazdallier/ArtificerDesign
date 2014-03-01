package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(String name, String texture) {
		super(Material.rock, name, texture);
		setHardness(10.0f);
	}
	
	public void onPostBlockPlaced(World world, int x, int y, int z, int meta) {}
}
