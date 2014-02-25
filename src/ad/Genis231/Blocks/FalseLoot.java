package ad.Genis231.Blocks;

import ad.Genis231.BaseClasses.ADBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class FalseLoot extends ADBlock {
	
	public static IIcon Coal, Gold, Lapis, Diamond, Emerald, Iron, Redstone;
	public static IIcon[] blockIcons = { Coal, Gold, Lapis, Diamond, Emerald, Iron, Redstone };
	public static String[] BlockTextures = { "coal_block", "gold_block", "lapis_block", "diamond_block", "emerald_block", "iron_block", "redstone_block" };
	
	public FalseLoot(String name) {
		super(Material.rock, name);
		setHardness(-1);
	}
	
	public int idDropped() {
		return 0;
	}
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List itemlist)
    {
		for (int i = 0; i <= 6; i++) {
			itemlist.add(new ItemStack(item,1,i));
		}
    }
	
	@Override @SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister icon) {
		for (int i = 0; i < blockIcons.length; i++)
			blockIcons[i] = icon.registerIcon(BlockTextures[i]);
	}
	
	@Override @SideOnly(Side.CLIENT) public IIcon getIcon(int side, int meta) {
		return blockIcons[meta];
	}
}
