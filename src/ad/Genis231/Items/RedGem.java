package ad.Genis231.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ad.Genis231.BaseClass.ADItem;
import ad.Genis231.lib.ADItems;


public class RedGem extends ADItem {
	
	public RedGem(String name, String texture) {
		super(name, texture);
	}
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		if(item.getItem()==ADItems.DirtyGem)
		list.add("Needs a way to be purified");
		list.add("into a pure red gem");
	}
}
