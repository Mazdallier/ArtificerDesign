package ad.Genis231.Items;

import ad.Genis231.Entity.DragonBreatheEntity;
import ad.Genis231.Resources.ADItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DragonBreathe extends ADItem {
	public DragonBreathe(String name, String texture) {
		super(name, texture);
	}
	
	/** Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer */
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		
		if (!player.capabilities.isCreativeMode) {
			item.stackSize--;
		}
		
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if (!world.isRemote) {
			world.spawnEntityInWorld(new DragonBreatheEntity(world, player, item));
		}
		
		return item;
	}
}
