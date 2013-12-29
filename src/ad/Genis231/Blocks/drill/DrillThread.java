package ad.Genis231.Blocks.drill;

import ad.Genis231.lib.ADLog;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class DrillThread implements Runnable {
	World world;
	int x, y, z;
	
	@Override
	public void run() {
		int area = 20;
		
		int minX = x - area;
		int maxX = x + area;
		
		int minZ = z - area;
		int maxZ = z + area;
		
		try {
			if (!world.isRemote) {
				for (int fy = y - 1; fy > 0; fy--) {
					for (int fx = minX; fx <= maxX; fx++) {
						for (int fz = minZ; fz <= maxZ; fz++) {
							if (world.getBlockId(fx, fy, fz) != 0) {
								Thread.sleep(100);
								
								// destroyBlock(world, fx, fy, fz, x, y, z);
								world.setBlock(fx, fy, fz, 0);
							}
						}
					}
				}
			}
		} catch (InterruptedException e) {
			ADLog.logger.info("~~~~~Thread Failed~~~~~");
		}
	}
	
	public DrillThread(World wo, int q, int w, int e) {
		world = wo;
		x = q;
		y = w;
		z = e;
	}
	
	public void destroyBlock(World wo, int fx, int fy, int fz, int ftx, int fty, int ftz) {
		int l = wo.getBlockId(fx, fy, fz);
		
		if (l > 0) {
			int i1 = wo.getBlockMetadata(fx, fy, fz);
			
			Block.blocksList[l].dropBlockAsItem(wo, ftx, fty, ftz, i1, 0);
		}
		
	}
}
