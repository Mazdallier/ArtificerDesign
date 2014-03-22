package ad.Genis231.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import ad.Genis231.Containers.CoiningContainer;
import ad.Genis231.TileEntity.CoiningTile;

public class CoiningGui extends GuiContainer {
	
	public CoiningGui(InventoryPlayer inventoryPlayer, CoiningTile tile, World world, int x, int y, int z) {
		super(new CoiningContainer(inventoryPlayer, tile, world, x, y, z));
	}
	
	@Override protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {}
}
