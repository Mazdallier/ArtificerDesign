package ad.Genis231.Containers;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.TileEntitys.ITableTile;

public class ITableContainer extends Container {
    
    protected ITableTile tileEntity;
    World world;
    IInventory inventory = (IInventory) tileEntity;
    int size;
    
    public ITableContainer(InventoryPlayer inventoryPlayer, ITableTile tile, World w, int X, int Y, int Z, int T) {
        tileEntity = tile;
        world = w;
        size = T == blocks.ItableT1.blockID ? 2 : 3;
        // the Slot constructor takes the IInventory and the slot number in that it binds to
        // and the x-y coordinates it resides on-screen
        if (T == blocks.ItableT1.blockID) {
            addSlotToContainer(new Slot(tileEntity, 0, 26, 11));
            addSlotToContainer(new Slot(tileEntity, 1, 26, 51));
        } else {
            addSlotToContainer(new Slot(tileEntity, 0, 36, 10));
            addSlotToContainer(new Slot(tileEntity, 1, 6, 30));
            addSlotToContainer(new Slot(tileEntity, 2, 36, 50));
        }
        
        
        // commonly used vanilla code that adds the player's inventory
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
    public void onContainerClosed(EntityPlayer player)
    {
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
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);
        
        // null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();
            
            // merges the item into player inventory since its in the tileEntity
            if (slot < 9) {
                if (!this.mergeItemStack(stackInSlot, 0, 35, true)) { return null; }
            }
            // places it into the tileEntity is possible since its in the player inventory
            else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) { return null; }
            
            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }
            
            if (stackInSlot.stackSize == stack.stackSize) { return null; }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }
    
    @Override
    public Slot getSlotFromInventory(IInventory inven, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);
        if (slot == 2) inven.isItemValidForSlot(slot, null);
        return null;
    }
    
    
}
