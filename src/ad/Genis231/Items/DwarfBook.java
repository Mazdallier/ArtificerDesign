package ad.Genis231.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADRaceBook;
import ad.Genis231.Core.Artificer;
import ad.Genis231.Player.PlayerData;
import ad.Genis231.Player.PlayerRace;

public class DwarfBook extends ADRaceBook {
	
	public DwarfBook(String name, String Texture) {
		super(name, Texture);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		if (PlayerData.get(player).getRace() == PlayerRace.DWARF || PlayerData.get(player).getRace() == PlayerRace.HUMAN)
			player.openGui(Artificer.instance, 3, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		else
			System.out.println("You are the wrong race!!");
		return item;
	}
}
