package ad.Genis231.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADItem;
import ad.Genis231.Research.Player.PlayerData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tome extends ADItem {
	
	public Tome(String name, String Texture) {
		super(name, Texture);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		PlayerData props = PlayerData.get(player);
		
		if (!world.isRemote)
			if (!player.isSneaking())
				props.addPoints(20);
			else
				props.subPoints(200);
		
		return item;
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("This needs a texture!!");
		list.add("This NEEDS to be balanced");
	}
}
