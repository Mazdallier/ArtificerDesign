package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PitTrapBlock extends ADBlock {
	
	@SideOnly(Side.CLIENT) public static Icon sandIcon;
	@SideOnly(Side.CLIENT) public static Icon stoneIcon;
	@SideOnly(Side.CLIENT) public static Icon dirtIcon;
	
	public static boolean toggle = true; // TODO Get rid of this stupid toggle thing!! -.-
	
	public PitTrapBlock(int id, String name) {
		super(id, Material.rock, name);
		setHardness(-1);
		this.setCreativeTab(null);
	}
	
	public void onEntityWalking(World world, int x, int y, int z, Entity player) {
		world.setBlock(x, y, z, 0, 0, 3);
		super.onEntityWalking(world, x, y, z, player);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighbor) {
		if (toggle) {			
			if (check(world, x, y, z)) {
				world.setBlock(x, y, z, 0, 0, 3);
			}
		}
	}
	
	private boolean check(World world, int x, int y, int z) {
		for (int i = 2; i <= 5; i++) {
			if (blockIsSide(world, x, y, z, 0, i))
				return true;
		}
		
		return false;
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		sandIcon = icon.registerIcon("sand");
		stoneIcon = icon.registerIcon("stone");
		dirtIcon = icon.registerIcon("dirt");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
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
