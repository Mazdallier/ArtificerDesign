package ad.Genis231.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.TileEntity.ITableTile;

public class ITableContainer extends Container {
	
	protected ITableTile tileEntity;
	World world;
	IInventory inventory = (IInventory) tileEntity;
	int size;
	
	public ITableContainer(InventoryPlayer inventoryPlayer, ITableTile tile, World w, int X, int Y, int Z, int T) {
		tileEntity = tile;
		world = w;
		size = T == ADBlock.ItableT1.blockID ? 3 : 4;
		
		if (T == ADBlock.ItableT1.blockID) {
			addSlotToContainer(new Slot(tileEntity, 0, 33, 13));
			addSlotToContainer(new Slot(tileEntity, 1, 33, 49));
			addSlotToContainer(new Slot(tileEntity, 2, 117, 31));
		} else {
			addSlotToContainer(new Slot(tileEntity, 0, 42, 7));
			addSlotToContainer(new Slot(tileEntity, 1, 12, 31));
			addSlotToContainer(new Slot(tileEntity, 2, 12, 53));
			addSlotToContainer(new Slot(tileEntity, 3, 118, 25));
		}
		
		bindPlayerInventory(inventoryPlayer);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.isUseableByPlayer(player);
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
	
	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		ItemStack items;
		if (!this.world.isRemote) {
			
			for (int i = 0; i < size; i++) {
				items = this.getSlot(i).getStack();
				if (items != null) {
					player.dropPlayerItem(items);
					this.getSlot(i).putStack(null);
				}
			}
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNumber);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotNumber <  4) {
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
	
	@Override
	public Slot getSlotFromInventory(IInventory inven, int slot) {
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if (slot == 2) inven.isItemValidForSlot(slot, null);
		return null;
	}
	
}
