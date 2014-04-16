package ad.Genis231.Items;

import ad.Genis231.Resources.ADItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class coin extends ADItem{

	public coin(String name,String Texture){
		super(name,Texture);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item,EntityPlayer player,List list,boolean bool){
		list.add("Seriously needs a better texture");
		list.add("We need to figure out how this will work");
	}

}
