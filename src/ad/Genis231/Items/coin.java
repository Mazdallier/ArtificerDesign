package ad.Genis231.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import ad.Genis231.Resources.ADItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class coin extends ADItem {
	
	public coin(String name, String Texture) {
		super(name, Texture);
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add("This little item will send you all the way over to....");
			list.add("X: 31999999");
			list.add("Y: 5");
			list.add("Z: 31999999");
		} else {
			list.add("Seriously needs a better texture");
			list.add("We need to figure out how this will work");
		}
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		if(player.isSneaking())
		player.setPositionAndUpdate(32000000 - 1, 5, 32000000 - 1);
		
		return item;
	}
}
