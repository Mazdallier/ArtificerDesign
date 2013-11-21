package ad.Genis231.Blocks;

import net.minecraft.world.World;
import ad.Genis231.lib.ADLog;

public class BlockHelper {
	/** returns the side in which you placed the block: args blockX, blockY, playerX, playerY */
	public static int sidePlaced(int x, int z, double posX, double posZ) {
		double Dx = x - posX;
		double Dz = z - posZ;
		double angle = Math.atan2(Dz, Dx) / Math.PI * 180 + 180;
		
		if (angle < 45 || angle > 315) return 5;
		else if (angle < 135) return 3;
		else if (angle < 225) return 4;
		else return 2;
	}
	
	/** checks if it is not touching said side on y axis: args world, x, y, z, blockID, side */
	public static boolean blockCheckAround(World world, int x, int y, int z, int block, int side) {
		if (world.getBlockId(x, y - 1, z) == block || world.getBlockId(x, y + 1, z) == block) return true;
		
		switch (side) {
			case 2:
				return world.getBlockId(x + 1, y, z) == block || world.getBlockId(x - 1, y, z) == block || world.getBlockId(x, y, z + 1) == block;
			case 3:
				return world.getBlockId(x + 1, y, z) == block || world.getBlockId(x - 1, y, z) == block || world.getBlockId(x, y, z - 1) == block;
			case 4:
				return world.getBlockId(x + 1, y, z) == block || world.getBlockId(x, y, z + 1) == block || world.getBlockId(x, y, z - 1) == block;
			case 5:
				return world.getBlockId(x - 1, y, z) == block || world.getBlockId(x, y, z + 1) == block || world.getBlockId(x, y, z - 1) == block;
			default:
				return false;
		}
	}
	
	/** checks if it is touching said block directly: world, x, y, z, blockID */
	public static int blockExists(World world, int x, int y, int z, int blockid) {
		if (world.getBlockId(x, y + 1, z) == blockid) return 0;
		else if (world.getBlockId(x, y - 1, z) == blockid) return 1;
		else if (world.getBlockId(x, y, z + 1) == blockid) return 2;
		else if (world.getBlockId(x, y, z - 1) == blockid) return 3;
		else if (world.getBlockId(x + 1, y, z) == blockid) return 4;
		else return 5;
	}
	
	/** places a block relative to the coords and side: args world, x, y, z, side of block */
	public static void placeInfront(World world, int x, int y, int z, int block, int side) {
		switch (side) {
			case 2:
				world.setBlock(x, y, z - 1, block, 0, 3);
				return;
			case 3:
				world.setBlock(x, y, z + 1, block, 0, 3);
				return;
			case 4:
				world.setBlock(x - 1, y, z, block, 0, 3);
				return;
			case 5:
				world.setBlock(x + 1, y, z, block, 0, 3);
				return;
		}
	}
	
	/** places a block relative to the coords and side: args world, x, y, z, side of block, meta */
	public static void placeInfront(World world, int x, int y, int z, int block, int side, int meta) {
		switch (side) {
			case 2:
				world.setBlock(x, y, z + 1, block, meta, 3);
				return;
			case 3:
				world.setBlock(x, y, z - 1, block, meta, 3);
				return;
			case 4:
				world.setBlock(x + 1, y, z, block, meta, 3);
				return;
			case 5:
				world.setBlock(x - 1, y, z, block, meta, 3);
				return;
		}
	}
	
	/** fills an area with said blockID args: world,minX,minY,inZ,maxX,maxY,maxZ,BlockId,checks if it can replace already existing blocks (true == will not override) **/
	public static void fill(World world, int mx, int my, int mz, int mX, int mY, int mZ, int blockID, int meta, boolean check) {
		int x, y, z, X, Y, Z;
		
		x = mx <= mX ? mx : mX;
		X = mx <= mX ? mX : mx;
		
		y = my <= mY ? my : mY;
		Y = my <= mY ? mY : my;
		
		z = mz <= mZ ? mz : mZ;
		Z = mz <= mZ ? mZ : mz;
		ADLog.logger.info("being told to place shtuffz :P");
		for (int q = x; q <= X; q++) {
			for (int w = z; w <= Z; w++) {
				for (int e = y; e <= Y; e++) {
					if (check) {
						if (world.getBlockId(q, e, w) == 0) {
							ADLog.logger.info("able to place " + meta);
							world.setBlock(q, e, w, blockID);
							world.setBlockMetadataWithNotify(q, e, w, meta, 3);
						} else world.destroyBlock(q, e, w - 1, false);
					} else {
						world.setBlock(q, e, w, blockID);
						world.setBlockMetadataWithNotify(q, e, w, meta, 3);
					}
				}
			}
		}
	}
}
