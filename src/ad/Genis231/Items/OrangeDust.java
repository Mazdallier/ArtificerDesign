package ad.Genis231.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.world.World;

public class OrangeDust extends ADItem {
	public OrangeDust(String name, String texture) {
		super(name, texture);
		setUnlocalizedName("OrangeDust");
	}
	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		IInventory inv = getInventory(world, x, y, z);
		ItemStack block;
		
		if (inv != null) {
			for (int i = 0; i < inv.getSizeInventory(); i++) {
				block = inv.getStackInSlot(i);
				
				if (block != null)
					System.out.println(block.getDisplayName() + "x" + block.stackSize);
			}
		}
		
		return false;
	}
	
	IInventory getInventory(World world, int x, int y, int z) {
		return TileEntityHopper.func_145893_b(world, x, y, z);
	}
}
