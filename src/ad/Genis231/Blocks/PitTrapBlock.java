package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PitTrapBlock extends ADBlock {
	
	@SideOnly(Side.CLIENT) public static IIcon sandIcon;
	@SideOnly(Side.CLIENT) public static IIcon stoneIcon;
	@SideOnly(Side.CLIENT) public static IIcon dirtIcon;
	
	public static boolean toggle = true; // TODO Get rid of this stupid toggle thing!! -.-
	
	public PitTrapBlock(String name) {
		super(Material.rock, name);
		setHardness(-1);
		this.setCreativeTab(null);
	}
	
	public void onEntityWalking(World world, int x, int y, int z, Entity player) {
		world.setBlockToAir(x, y, z);
		
		super.onEntityWalking(world, x, y, z, player);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
		if (toggle) {
			if (check(world, x, y, z)) {
				world.setBlockToAir(x, y, z);
			}
		}
	}
	
	private boolean check(World world, int x, int y, int z) {
		for (int i = 2; i <= 5; i++) {
			if (blockIsSide(world, x, y, z, Blocks.air, i))
				return true;
		}
		return false;
	}
	
	@Override @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister icon) {
		sandIcon = icon.registerIcon("sand");
		stoneIcon = icon.registerIcon("stone");
		dirtIcon = icon.registerIcon("dirt");
	}
	
	@Override @SideOnly(Side.CLIENT) public IIcon getIcon(int side, int meta) {
		switch (meta) {
			case 0:
				return dirtIcon;
			case 1:
				return sandIcon;
			default:
				return stoneIcon;
		}
	}
}
