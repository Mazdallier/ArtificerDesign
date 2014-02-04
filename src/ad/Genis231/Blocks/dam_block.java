package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class dam_block extends ADBlock {
	
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;
	@SideOnly(Side.CLIENT)
	public static Icon openIcon;
	@SideOnly(Side.CLIENT)
	public static Icon closeIcon;
	
	public dam_block(int id, String name) {
		super(id, Material.rock, name);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item) {
		world.setBlock(x, y, z, Dam.blockID, sidePlaced(x, z, player.posX, player.posZ) - 2, 2);
	}
	
	public void onPostBlockPlaced(World world, int x, int y, int z, int par5) {
		if (!world.isBlockIndirectlyGettingPowered(x, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z), 3);
			set(world, x, y, z, world.getBlockMetadata(x, y, z) - 4);
		}
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockid) {
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) < 4) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 4, 3);
			set(world, x, y, z, world.getBlockMetadata(x, y, z) - 2);
			
		} else if (!world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) > 3) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 4, 3);
			placeInfront(world, x, y, z, 0, world.getBlockMetadata(x, y, z) + 2);
		}
	}
	
	public void set(World world, int x, int y, int z, int side) {
		
		if (blockCheckAround(world, x, y, z, Block.waterMoving.blockID, side) || blockCheckAround(world, x, y, z, Block.waterStill.blockID, side)) {
			placeInfront(world, x, y, z, Block.waterMoving.blockID, side);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		sideIcon = icon.registerIcon(textures.DamArray[0]);
		openIcon = icon.registerIcon(textures.DamArray[1]);
		closeIcon = icon.registerIcon(textures.DamArray[2]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		
		if (meta < 4) {
			if (side - meta == 2) return closeIcon;
			else return sideIcon;
		} else {
			if (meta - side == 2) return openIcon;
			else return sideIcon;
		}
	}
}
