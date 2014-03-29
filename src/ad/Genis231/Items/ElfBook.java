package ad.Genis231.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADRaceBook;
import ad.Genis231.Core.Artificer;
import ad.Genis231.Player.PlayerData;
import ad.Genis231.Player.PlayerRace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ElfBook extends ADRaceBook {
	
	public ElfBook(String name, String Texture) {
		super(name, Texture);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		if (PlayerData.get(player).getRace() == PlayerRace.ELF || PlayerData.get(player).getRace() == PlayerRace.HUMAN)
			player.openGui(Artificer.instance, 3, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		else
			System.out.println("You are the wrong race!!");
		return item;
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		super.addInformation(item, player, list, bool);
		if (PlayerData.get(player).getRace() != PlayerRace.ELF && PlayerData.get(player).getRace() != PlayerRace.HUMAN) {
			list.add("\u00A76"+"You are not an "+"\u00A75"+"Elf");
		}
	}
}
