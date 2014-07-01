package ad.Genis231.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ad.Genis231.Resources.ADItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Swords extends ADItem {
	public IIcon[] IconArray = new IIcon[4];
	
	public Swords() {
		super("sword");
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("sword" + item.getItemDamage() + ".png");
	}
	
	@Override public IIcon getIconFromDamage(int meta) {
		return this.IconArray[meta];
	}
	
	@Override public int getMetadata(int meta) {
		return meta;
	}
	
	@SideOnly(Side.CLIENT) public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 4; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override public String getUnlocalizedName(ItemStack item) {
		return getUnlocalizedName() + item.getItemDamage();
	}
	
	@Override @SideOnly(Side.CLIENT) public void registerIcons(IIconRegister icon) {
		for (int i = 0; i < IconArray.length; i++)
			IconArray[i] = icon.registerIcon("artificer:" + "sword" + i);
	}
}
