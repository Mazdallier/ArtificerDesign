package ad.Genis231.Core.Resources;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class InventoryHelper{
	private static Minecraft mc = Minecraft.getMinecraft();

	public static ItemStack getItem(IInventory inv,int slot){
		if(inv.getSizeInventory() < slot) return inv.getStackInSlot(slot);
		return null;
	}

	public static IInventory getInventorySide(ForgeDirection dir){
		MovingObjectPosition clicked = mc.objectMouseOver;

		if(clicked != null){
			return getInventorySide(mc.theWorld,clicked.blockX + dir.offsetX,clicked.blockY + dir.offsetY,clicked.blockZ + dir.offsetZ,dir);
		}

		return null;
	}

	public static IInventory getInventorySide(World world,int x,int y,int z,ForgeDirection dir){
		return getInventory(world,x + dir.offsetX,y + dir.offsetY,z + dir.offsetZ);
	}

	public static IInventory getInventory(){
		MovingObjectPosition objectMouseOver = mc.objectMouseOver;

		if(objectMouseOver != null){
			return getInventory(mc.theWorld,objectMouseOver.blockX,objectMouseOver.blockY,objectMouseOver.blockZ);
		}

		return null;
	}

	public static IInventory getInventory(World world,int x,int y,int z){
		return TileEntityHopper.func_145893_b(world,x,y,z);
	}

	public static void addBlock(IInventory inv,ItemStack item,int side){
		TileEntityHopper.func_145889_a(inv,item,side);
	}
}
