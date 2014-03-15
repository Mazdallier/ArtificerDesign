package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class DrillPartBlock extends ADBlock {
	
	public DrillPartBlock(String name) {
		super(Material.rock, name);
		this.setCreativeTab(null);
	}
	
	@Override public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
		
		int temp = getsize(world, x, y, z);
		
		if (temp > 1) {
		}
	}
	
	int getsize(World world, int x, int y, int z) {
		int temp = 0;
		int tx = 1, ty = 1, tz = 11;
		
		for (int fy = y; fy <= fy + 3; fy++) {
			for (int fx = x; fx <= fx + 3; fx++) {
				for (int fz = z; fz <= fz + 3; fz++) {
					if (check(world, fx, y, z))
						tx++;
					else
						tx = 1;
					
					if (check(world, x, y, fz))
						tz++;
					else
						tz = 1;
					
					if (check(world, x, fy, z))
						ty++;
					else
						ty = 1;
				}
			}
		}
		
		temp = Math.min(tx, tz);
		temp = Math.min(ty, temp);
				
		return temp;
	}
	
	boolean check(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) == this;
	}
}
