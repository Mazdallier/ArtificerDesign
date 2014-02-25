package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.lib.BlockTexture;
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
	
	@Override public boolean renderAsNormalBlock() {
		return true;
	}
	
	@Override public boolean isOpaqueCube() {
		return true;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		world.setBlock(x, y, z, this, sidePlaced(x, z, player.posX, player.posZ) - 2, 3);
	}
	
	public void onPostBlockPlaced(World world, int x, int y, int z, int meta) {
		if (!world.isBlockIndirectlyGettingPowered(x, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z), 3);
			set(world, x, y, z, world.getBlockMetadata(x, y, z) - 4);
		}
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid) {
		
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) <= 3) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 4, 3);
			set(world, x, y, z, world.getBlockMetadata(x, y, z) - 2);
			
		} else if (!world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) >= 4) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 4, 3);
			setBlock(world, x, y, z, Blocks.air, world.getBlockMetadata(x, y, z) + 2);
		}
	}
	
	public void set(World world, int x, int y, int z, int side) {
		if (blockIsSide(world, x, y, z, Blocks.water, side))
			setBlock(world, x, y, z, Blocks.water, side);
	}
	
	@Override @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister icon) {
		sideIcon = icon.registerIcon(BlockTexture.Dam[0]);
		openIcon = icon.registerIcon(BlockTexture.Dam[1]);
		closeIcon = icon.registerIcon(BlockTexture.Dam[2]);
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
