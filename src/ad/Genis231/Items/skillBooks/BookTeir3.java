package ad.Genis231.Items.skillBooks;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ad.Genis231.BaseClass.ADSkillBook;

public class BookTeir3 extends ADSkillBook{

	public BookTeir3(String name, String Texture) {
		super(name, Texture);
		// TODO Auto-generated constructor stub
	}
	@SideOnly(Side.CLIENT) public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 9; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
}
