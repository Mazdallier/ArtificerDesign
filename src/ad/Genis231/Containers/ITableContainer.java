package ad.Genis231.Containers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.TileEntity.ITableTile;

public class ITableContainer extends Container {
	
	protected ITableTile tileEntity;
	World world;
	int size;
	
	public ITableContainer(InventoryPlayer inventoryPlayer, ITableTile tile, World w, int X, int Y, int Z, Block block) {
		tileEntity = tile;
		world = w;
		size = block == ADBlock.Itable1 ? 3 : 4;
		
		if (block == ADBlock.Itable1) {
			addSlotToContainer(new Slot(tile, 0, 33, 13));
			addSlotToContainer(new Slot(tile, 1, 33, 49));
			addSlotToContainer(new Slot(tile, 2, 117, 31));
		} else {
			addSlotToContainer(new Slot(tile, 0, 42, 7));
			addSlotToContainer(new Slot(tile, 1, 12, 31));
			addSlotToContainer(new Slot(tile, 2, 12, 53));
			addSlotToContainer(new Slot(tile, 3, 118, 25));
		}
		
	}
	
	@Override public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.isUseableByPlayer(player);
	}
	
	/** Called when the container is closed. */
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		ItemStack items;
		if (!this.world.isRemote) {
			
			for (int i = 0; i < size; i++) {
				items = this.getSlot(i).getStack();
				if (items != null) {
					player.entityDropItem(items, items.stackSize);
					this.getSlot(i).putStack(null);
				}
			}
		}
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
