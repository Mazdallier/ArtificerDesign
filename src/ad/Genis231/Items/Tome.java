package ad.Genis231.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADItem;
import ad.Genis231.Research.Player.PlayerData;

public class Tome extends ADItem {
	
	public Tome(String name, String Texture) {
		super(name, Texture);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		PlayerData props = PlayerData.get(player);
		
		if (!world.isRemote)
			if (!player.isSneaking())
				props.addPoints(10);
			else
				props.subPoints(10);
		
		System.out.println("Current Points: " + props.getPoints() + " Side: " + (world.isRemote ? "Client" : "Server"));
		
		return item;
	}
}
