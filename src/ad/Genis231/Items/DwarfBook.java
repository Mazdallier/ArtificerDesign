package ad.Genis231.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADRaceBook;
import ad.Genis231.Core.Artificer;
import ad.Genis231.Player.PlayerData;
import ad.Genis231.Player.PlayerRace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DwarfBook extends ADRaceBook {
	
	public DwarfBook(String name, String Texture) {
		super(name, Texture);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		PlayerRace race = PlayerData.get(player).getRace();
		EnumChatFormatting color = null;
		
		if (race == PlayerRace.DWARF || race == PlayerRace.HUMAN)
			player.openGui(Artificer.instance, 3, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		else if (!world.isRemote)
			player.addChatComponentMessage(new ChatComponentText(color.DARK_PURPLE + "Sorry bro! you are not a " + color.GOLD + "dwarf!"));
		return item;
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		if (PlayerData.get(player).getRace() != PlayerRace.DWARF && PlayerData.get(player).getRace() != PlayerRace.HUMAN)
			list.add(this.mainColor + "You are not a " + this.secondaryColor + "Dwarf");
		
		super.addInformation(item, player, list, bool);
	}
}
