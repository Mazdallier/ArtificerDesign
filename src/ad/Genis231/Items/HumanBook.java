package ad.Genis231.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ad.Genis231.Core.Artificer;
import ad.Genis231.Resources.ADSkillBook;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HumanBook extends ADSkillBook {
	
	public HumanBook(String name, String Texture) {
		super(name, Texture);
	}
	
	@Override @SideOnly(Side.CLIENT) public IIcon getIcon(ItemStack item, int pass) {
		if (pass == 1)
			return open;
		
		return this.itemIcon;
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		player.openGui(Artificer.instance, 3, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		return item;
	}
}
