package ad.Genis231.BaseClasses;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import ad.Genis231.Blocks.BTrap;
import ad.Genis231.Blocks.BloodDiamond_Ore;
import ad.Genis231.Blocks.Drill;
import ad.Genis231.Blocks.DwarvenStone;
import ad.Genis231.Blocks.FakeFire;
import ad.Genis231.Blocks.ITableBlock;
import ad.Genis231.Blocks.PTBlock;
import ad.Genis231.Blocks.SpikeTrap;
import ad.Genis231.Blocks.dam_block;
import ad.Genis231.Blocks.false_loot;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.blockIDs;

public class ADBlock extends Block {
	/** Basic Constructor
	 * @param id This is the blockID
	 * @param material The material of said block
	 * @param name This is the UnlocalizedName */
	
	public ADBlock(int id, Material material, String name) {
		super(id, material);
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
	}
	
	public static final Block BDiamond_ore = new BloodDiamond_Ore(blockIDs.BDOre, "BloodOre");
	public static final Block Dam = new dam_block(blockIDs.DamBlock, "DamBlock");
	public static final Block FalseLoot = new false_loot(blockIDs.False_Loot, "FalseLootBlocks");
	public static final Block FPTrap = new PTBlock(blockIDs.FALSE_PIT_TRAP, "Null_block");
	public static final Block ItableT1 = new ITableBlock(blockIDs.ITableT1, "ITable1");
	public static final Block ItableT2 = new ITableBlock(blockIDs.ITableT2, "ITable2");
	public static final Block Spike = new SpikeTrap(blockIDs.Spike, "Spike");
	public static final Block BTrap = new BTrap(blockIDs.BearTrap, "BTrap");
	public static final Block Drill = new Drill(blockIDs.Drill, "Drill_MB");
	public static final Block DwarvenStone = new DwarvenStone(blockIDs.DStone, "DwarvenStone");
	public static final BlockFire GFire = (BlockFire) new FakeFire(blockIDs.GFire, true).setUnlocalizedName("GFire");
	public static final BlockFire BFire = (BlockFire) new FakeFire(blockIDs.GFire + 5, false).setUnlocalizedName("BFire");
	
	public static int sidePlaced(int x, int z, double posX, double posZ) {
		double Dx = x - posX;
		double Dz = z - posZ;
		double angle = Math.atan2(Dz, Dx) / Math.PI * 180 + 180;
		
		if (angle < 45 || angle > 315)
			return 5;
		else if (angle < 135)
			return 3;
		else if (angle < 225)
			return 4;
		else
			return 2;
	}
	
	/** checks if it is not touching said side on y axis: args world, x, y, z, blockID, side */
	public static boolean blockCheckAround(World world, int x, int y, int z, int block, int side) {
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
				return true;
		}
	}
	
	/** checks if it is touching said block directly: world, x, y, z, blockID */
	public static int blockExists(World world, int x, int y, int z, int blockid) {
		if (world.getBlockId(x, y + 1, z) == blockid)
			return 0;
		else if (world.getBlockId(x, y - 1, z) == blockid)
			return 1;
		else if (world.getBlockId(x, y, z + 1) == blockid)
			return 2;
		else if (world.getBlockId(x, y, z - 1) == blockid)
			return 3;
		else if (world.getBlockId(x + 1, y, z) == blockid)
			return 4;
		else
			return 5;
	}
	
	/** places a block relative to the coords and side: args world, x, y, z, side of block */
	public static void placeInfront(World world, int x, int y, int z, int block, int side) {
		switch (side) {
			case 2:
				world.setBlock(x, y, z - 1, block);
				break;
			case 3:
				world.setBlock(x, y, z + 1, block);
				break;
			case 4:
				world.setBlock(x - 1, y, z, block);
				break;
			case 5:
				world.setBlock(x + 1, y, z, block);
				break;
		}
	}
	
	/** places a block relative to the coords and side: args world, x, y, z, side of block, meta */
	public static void placeInfront(World world, int x, int y, int z, int block, int side, int meta) {
		switch (side) {
			case 2:
				world.setBlock(x, y, z + 1, block, meta, 3);
				break;
			case 3:
				world.setBlock(x, y, z - 1, block, meta, 3);
				break;
			case 4:
				world.setBlock(x + 1, y, z, block, meta, 3);
				break;
			case 5:
				world.setBlock(x - 1, y, z, block, meta, 3);
				break;
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
		
		for (int fy = y; fy <= Y; fy++) {
			for (int fx = x; fx <= X; fx++) {
				for (int fz = z; fz <= Z; fz++) {
					if (check) {
						if (world.getBlockId(fx, fy, fz) == 0) {
							world.setBlock(fx, fy, fz, blockID);
							world.setBlockMetadataWithNotify(fx, fy, fz, meta, 3);
						} else
							world.destroyBlock(fx, fy, fz - 1, false);
					} else {
						world.setBlock(fx, fy, fz, blockID);
						world.setBlockMetadataWithNotify(fx, fy, fz, meta, 3);
					}
				}
			}
		}
	}
}
