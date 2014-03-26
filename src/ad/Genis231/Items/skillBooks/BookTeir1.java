package ad.Genis231.Items.skillBooks;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ad.Genis231.BaseClass.ADSkillBook;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BookTeir1 extends ADSkillBook {
	
	public BookTeir1(String name, String Texture) {
		super(name, Texture);
	}
	
	@SideOnly(Side.CLIENT) public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 9; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
}