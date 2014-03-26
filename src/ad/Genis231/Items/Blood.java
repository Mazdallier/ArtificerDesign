package ad.Genis231.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ad.Genis231.BaseClass.ADItem;


public class Blood extends ADItem {
	
	public Blood(String name, String texture) {
		super(name, texture);
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("Need mobs to drop these items");
	}
	
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return false;
    }
}
