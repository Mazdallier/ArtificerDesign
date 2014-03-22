package ad.Genis231.Containers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.TileEntity.ITableTile;
import ad.Genis231.lib.ADBlocks;

public class ITableContainer extends Container {
	
	protected ITableTile tile;
	World world;
	int size;
	
	public ITableContainer(InventoryPlayer inventoryPlayer, ITableTile tile, World world, int X, int Y, int Z, Block block) {
		this.tile = tile;
		this.world = world;
		size = block == ADBlocks.Itable1 ? 3 : 4;
		
		if (block == ADBlocks.Itable1) {
			addSlotToContainer(new Slot(tile, 0, 33, 13));
			addSlotToContainer(new Slot(tile, 1, 33, 49));
			addSlotToContainer(new Slot(tile, 2, 117, 31));
		} else {
			addSlotToContainer(new Slot(tile, 0, 42, 7));
			addSlotToContainer(new Slot(tile, 1, 12, 31));
			addSlotToContainer(new Slot(tile, 2, 12, 53));
			addSlotToContainer(new Slot(tile, 3, 118, 25));
		}
		
		bindPlayerInventory(inventoryPlayer);
	}
	
	@Override public boolean canInteractWith(EntityPlayer player) {
		return tile.isUseableByPlayer(player);
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
			itemstack = slot.getStack();
			
			if (slotNumber < 4) {
				if (!this.mergeItemStack(itemstack, 4, this.inventorySlots.size(), true)) { return null; }
			} else if (!this.mergeItemStack(itemstack, 0, 4, false)) { return null; }
			
			if (itemstack.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return itemstack;
	}
	
	@Override public Slot getSlotFromInventory(IInventory inven, int slot) {
		if (slot == 2)
			inven.isItemValidForSlot(slot, null);
		return null;
	}
	
}
