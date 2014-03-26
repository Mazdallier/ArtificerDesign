package ad.Genis231.BaseClass;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.Core.Artificer;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ADSkillBook extends ADItem {
	
	public ADSkillBook(String name, String Texture) {
		super(name, Texture);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(Ref.BookTab);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		player.openGui(Artificer.instance, 3, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		
		return item;
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("This SERIOUSLY needs a purpose");
		list.add("needs catagories (tools,armor)");
		list.add("add a texture any time now noob >_>");
	}
}
