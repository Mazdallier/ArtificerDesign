package ad.Genis231.Containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import ad.Genis231.TileEntity.CoiningTile;

public class CoiningContainer extends Container {
	CoiningTile tile;
	World world;
	int size=2;
	
	public CoiningContainer(InventoryPlayer inventoryPlayer, CoiningTile tile, World wrld, int X, int Y, int Z) {
		this.tile = tile;
		
		addSlotToContainer(new Slot(tile, 0, 33, 13));
		addSlotToContainer(new Slot(tile, 1, 33, 49));
		
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
	
}
