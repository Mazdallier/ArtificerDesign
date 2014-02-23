package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Drill extends ADBlock {
	
	@SideOnly(Side.CLIENT) public static IIcon oddSideIcon;
	@SideOnly(Side.CLIENT) public static IIcon evenSideIcon;
	@SideOnly(Side.CLIENT) public static IIcon topIcon;
	@SideOnly(Side.CLIENT) public static IIcon botIcon;
	
	public Drill(String name) {
		super(Material.rock, name);
		this.setHardness(5.0F);
	}
	
	@Override @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister icon) {
		evenSideIcon = icon.registerIcon(BlockTexture.Drill[0]);
		oddSideIcon = icon.registerIcon(BlockTexture.Drill[1]);
		topIcon = icon.registerIcon(BlockTexture.Drill[2]);
		botIcon = icon.registerIcon(BlockTexture.Drill[3]);
	}
	
	@Override @SideOnly(Side.CLIENT) public IIcon getIcon(int side, int meta) {
		switch (side) {
			case 0:
				return botIcon;
			case 1:
				return topIcon;
			case 2:
				return evenSideIcon;
			case 3:
				return evenSideIcon;
			case 4:
				return oddSideIcon;
			default:
				return oddSideIcon;
		}
	}
}
