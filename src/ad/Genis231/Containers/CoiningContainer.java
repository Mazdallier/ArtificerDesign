package ad.Genis231.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.TileEntity.CoiningTileEntity;

public class CoiningContainer extends Container {
	CoiningTileEntity tile;
	
	public CoiningContainer(InventoryPlayer inventoryPlayer, CoiningTileEntity tile, World world, int X, int Y, int Z) {
		this.tile = tile;
		
		addSlotToContainer(new Slot(tile, 0, 44, 29));
		addSlotToContainer(new Slot(tile, 1, 116, 29));
		
		bindPlayerInventory(inventoryPlayer);
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}
	
	@Override public boolean canInteractWith(EntityPlayer player) {
		return tile.isUseableByPlayer(player);
	}
	
	@Override public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNumber);
		
		if (slot != null && slot.getHasStack()) {
			itemstack = slot.getStack();
			
			if (slotNumber < 2) {
				if (!this.mergeItemStack(itemstack, 2, this.inventorySlots.size(), true)) { return null; }
			} else if (!this.mergeItemStack(itemstack, 0, 2, false)) { return null; }
			
			if (itemstack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return itemstack;
	}
}
