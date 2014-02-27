package ad.Genis231.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.TileEntity.VMTile;

public class VMContainer extends Container {
	
	protected VMTile tileEntity;
	World world;
	IInventory inventory = (IInventory) tileEntity;
	
	public VMContainer(InventoryPlayer inventoryPlayer, VMTile tile, World w, int X, int Y, int Z) {
		tileEntity = tile;
		world = w;
		
		addSlotToContainer(new Slot(tileEntity, 0, 33, 13));
		addSlotToContainer(new Slot(tileEntity, 1, 33, 49));
	}
	
	@Override public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.isUseableByPlayer(player);
	}
	
	@Override public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNumber);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotNumber < 4) {
				if (!this.mergeItemStack(itemstack1, 4, this.inventorySlots.size(), true)) { return null; }
			} else if (!this.mergeItemStack(itemstack1, 0, 4, false)) { return null; }
			
			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return itemstack;
	}
}
