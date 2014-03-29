package ad.Genis231.BaseClass;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ADRaceBook extends ADItem {
	
	public ADRaceBook(String name, String Texture) {
		super(name, Texture);
		this.setMaxDamage(0);
		this.setCreativeTab(Ref.MainTab);
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("This SERIOUSLY needs a purpose");
		list.add("add a texture any time now noob >_>");
	}
}
