package ad.Genis231.BaseClass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ad.Genis231.lib.Ref;

public class ADBlock extends Block {
	/** Basic Constructor
	 * @param material The material of said block
	 * @param name This is the UnlocalizedName */
	public ADBlock(Material material, String name) {
		super(material);
		this.setHardness(0.0F);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockName(name);
	}
	
	public ADBlock(Material material, String name, String texture) {
		super(material);
		this.setBlockTextureName(texture);
		this.setHardness(0.0F);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockName(name);
	}
	
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
		ForgeDirection direction = ForgeDirection.getOrientation(side);
		return world.getBlock(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ).equals(block);
		
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
		ForgeDirection direction = ForgeDirection.getOrientation(side);
		world.setBlock(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ, block, meta, 3);
		
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
							// TODO FIX THIS!! world.destroyBlock(fx, fy, fz -
							// 1, false);
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
