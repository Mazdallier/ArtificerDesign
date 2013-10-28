package ad.Genis231.Items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;

public class ODust extends Item {
	protected ODust(int id) {
		super(id);
		setMaxStackSize(64);
		setUnlocalizedName("OrangeDust");
	}
	
	/* bottom = 0 ~~ top=1 ~~ south = 2 ~~ north = 3 ~~ east = 4 ~~ west = 5 */
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
		System.out.println("~~~~~~~~~~ORANGEDUST~~~~~~~~~~");
		System.out.println("item stack: " + itemStack);
		System.out.println("player: " + player);
		System.out.println("world: " + world.getWorldChunkManager());
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		System.out.println("z: " + z);
		System.out.println("side: " + side);
		System.out.println("Block-x: " + Bx);
		System.out.println("Block-y: " + By);
		System.out.println("Block-z: " + Bz);
		System.out.println();
		return false;
	}
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase mob, EntityLivingBase player) {
		System.out.println("~~~~~~~~~~ORANGEDUST~~~~~~~~~~");
		System.out.println("Item Stack: " + par1ItemStack);
		System.out.println("mob: " + mob);
		System.out.println("Player: " + player);
		System.out.println();
		return false;
	}
	
	public boolean canItemEditBlocks() {
		return true;
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		return item;
	}
}
