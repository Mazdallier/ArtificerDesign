package ad.Genis231.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADItem;
import ad.Genis231.Player.PlayerData;
import ad.Genis231.Player.PlayerRace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Tome extends ADItem {
	
	public Tome(String name, String Texture) {
		super(name, Texture);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		PlayerData props = PlayerData.get(player);
		
		int i = props.getRace().getID();
		
		if (!world.isRemote)
			if (i < 3)
				props.setRace(PlayerRace.getRace((i + 1)%4));
			else
				props.setRace(PlayerRace.getRace((i + 1)%4));
		
		return item;
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("This needs a texture!!");
		list.add("This will change the current class of the player");
	}
}
