package ad.Genis231.BaseClasses;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ad.Genis231.Blocks.BearTrap;
import ad.Genis231.Blocks.DamBlock;
import ad.Genis231.Blocks.Drill;
import ad.Genis231.Blocks.DwarvenStone;
import ad.Genis231.Blocks.FakeFire;
import ad.Genis231.Blocks.FalseLoot;
import ad.Genis231.Blocks.ITableBlock;
import ad.Genis231.Blocks.PitTrapBlock;
import ad.Genis231.Blocks.RedGemOre;
import ad.Genis231.Blocks.SpikeTrap;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.blockIDs;

public class ADBlock extends Block {
	/** Basic Constructor
	 * @param material The material of said block
	 * @param name This is the UnlocalizedName */
	
	public ADBlock(Material material, String name) {
		super(material);
		this.setCreativeTab(Ref.TAB);
		this.setBlockName(name);
	}
	
	public static final Block RedGemOre = new RedGemOre("BloodOre");
	public static final Block Dam = new DamBlock("DamBlock");
	public static final Block FalseLoot = new FalseLoot("FalseLootBlocks");
	public static final Block FalsePitTrap = new PitTrapBlock("Null_block");
	public static final Block Itable1 = new ITableBlock("ITable1");
	public static final Block Itable2 = new ITableBlock("ITable2");
	public static final Block Spike = new SpikeTrap("Spike");
	public static final Block BearTrap = new BearTrap("BTrap");
	public static final Block Drill = new Drill("Drill_MB");
	public static final Block DwarvenStone = new DwarvenStone("DwarvenStone");
	public static final Block GreenFire = new FakeFire().setBlockName("GFire");
	
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
	public static boolean blockIsSide(World world, int x, int y, int z, Block block, int side) {
		switch (ForgeDirection.getOrientation(side)) {
			case NORTH:
				return world.getBlock(x, y, z - 1).equals(block);
			case SOUTH:
				return world.getBlock(x, y, z + 1).equals(block);
			case WEST:
				return world.getBlock(x - 1, y, z).equals(block);
			case EAST:
				return world.getBlock(x + 1, y, z).equals(block);
			case DOWN:
				return world.getBlock(x, y - 1, z).equals(block);
			case UP:
				return world.getBlock(x, y + 1, z).equals(block);
			default:
				return true;
		}
	}
	
	/** checks if it is touching said block directly: world, x, y, z, blockID */
	public static int blockExists(World world, int x, int y, int z, Block block) {
		if (world.getBlock(x, y + 1, z).equals(block))
			return 0;
		else if (world.getBlock(x, y - 1, z).equals(block))
			return 1;
		else if (world.getBlock(x, y, z + 1).equals(block))
			return 2;
		else if (world.getBlock(x, y, z - 1).equals(block))
			return 3;
		else if (world.getBlock(x + 1, y, z).equals(block))
			return 4;
		else if (world.getBlock(x - 1, y, z).equals(block))
			return 5;
		else
			return -1;
	}
	
	/** places a block relative to the coords and side: args world, x, y, z, side of block */
	public static void setBlock(World world, int x, int y, int z, Block block, int side) {
		setBlock(world, x, y, z, block, side, 0);
	}
	
	/** places a block relative to the coords and side: args world, x, y, z, side of block, meta */
	public static void setBlock(World world, int x, int y, int z, Block block, int side, int meta) {
		switch (ForgeDirection.getOrientation(side)) {
			case NORTH:
				world.setBlock(x, y, z - 1, block, meta, 3);
				break;
			case SOUTH:
				world.setBlock(x, y, z + 1, block, meta, 3);
				break;
			case WEST:
				world.setBlock(x - 1, y, z, block, meta, 3);
				break;
			case EAST:
				world.setBlock(x + 1, y, z, block, meta, 3);
				break;
			default:
				break;
		
		}
	}
	
	/** fills an area with said blockID args: world,minX,minY,inZ,maxX,maxY,maxZ,BlockId,checks if it can replace already existing blocks (true == will not override) **/
	public static void fill(World world, int mx, int my, int mz, int mX, int mY, int mZ, Block block, int meta, boolean check) {
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
						if (world.getBlock(fx, fy, fz) == Blocks.air) {
							world.setBlock(fx, fy, fz, block);
							world.setBlockMetadataWithNotify(fx, fy, fz, meta, 3);
						} else
							// TODO FIX THIS!! world.destroyBlock(fx, fy, fz - 1, false);
							world.setBlockToAir(fx, fy, fz - 1);
					} else {
						world.setBlock(fx, fy, fz, block);
						world.setBlockMetadataWithNotify(fx, fy, fz, meta, 3);
					}
				}
			}
		}
	}
}
