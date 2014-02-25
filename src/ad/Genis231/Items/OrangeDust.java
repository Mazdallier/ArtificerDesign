package ad.Genis231.Items;

import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.lib.ItemTexture;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OrangeDust extends ADItem {
	public OrangeDust(String name) {
		super(name);
		setMaxStackSize(64);
		setUnlocalizedName("OrangeDust");
		setTextureName(ItemTexture.OrangeDust);
	}
	
	/* bottom = 0 ~~ top=1 ~~ south = 2 ~~ north = 3 ~~ east = 4 ~~ west = 5 */
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
		if (world.isRemote) {
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
			System.out.println("\n");
		}
		return false;
	}
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase mob, EntityLivingBase player) {
		System.out.println("~~~~~~~~~~ORANGEDUST~~~~~~~~~~");
		System.out.println("Item Stack: " + par1ItemStack);
		System.out.println("mob: " + mob);
		System.out.println("Player: " + player);
		System.out.println("\n");
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		return item;
	}
}
