package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DamBlock extends ADBlock {
	@SideOnly(Side.CLIENT) public static IIcon sideIcon;
	@SideOnly(Side.CLIENT) public static IIcon openIcon;
	@SideOnly(Side.CLIENT) public static IIcon closeIcon;
	
	public DamBlock(String name) {
		super(Material.rock, name);
		this.setHardness(5.0F);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		world.setBlock(x, y, z, this, sidePlaced(x, z, player.posX, player.posZ) - 2, 3);
	}
	
	public void onPostBlockPlaced(World world, int x, int y, int z, int meta) {
		check(world, x, y, z);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		check(world, x, y, z);
	}
	
	void check(World world, int x, int y, int z) {
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) <= 3) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 4, 3);
			set(world, x, y, z, world.getBlockMetadata(x, y, z) - 2);
			
		} else if (!world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) >= 4) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 4, 3);
			setBlock(world, x, y, z, Blocks.air, world.getBlockMetadata(x, y, z) + 2);
		}
	}
	
	public void set(World world, int x, int y, int z, int side) {		
		if (blockIsSide(world, x, y, z, Blocks.water, ForgeDirection.OPPOSITES[side]))
			setBlock(world, x, y, z, Blocks.water, side);
	}
	
	@Override @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister icon) {
		sideIcon = icon.registerIcon(textures.Dam[0]);
		openIcon = icon.registerIcon(textures.Dam[1]);
		closeIcon = icon.registerIcon(textures.Dam[2]);
	}
	
	@Override @SideOnly(Side.CLIENT) public IIcon getIcon(int side, int meta) {
		
		if (meta < 4) {
			if (side - meta == 2)
				return closeIcon;
			else
				return sideIcon;
		} else {
			if (meta - side == 2)
				return openIcon;
			else
				return sideIcon;
		}
	}
}
