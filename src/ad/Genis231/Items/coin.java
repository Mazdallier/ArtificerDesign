package ad.Genis231.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import ad.Genis231.BaseClass.ADItem;
import ad.Genis231.lib.ItemTexture;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class coin extends ADItem {
	
	public coin(String name, String Texture) {
		super(name, Texture);
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("Seriously needs a better texture");
		list.add("We need to figure out how this will work");
	}
}
