package ad.Genis231.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import ad.Genis231.Containers.CoiningContainer;
import ad.Genis231.Refrence.textures;
import ad.Genis231.TileEntity.CoiningTileEntity;

public class CoiningGui extends GuiContainer {
	
	public CoiningGui(InventoryPlayer inventoryPlayer, CoiningTileEntity tile, World world, int x, int y, int z) {
		super(new CoiningContainer(inventoryPlayer, tile, world, x, y, z));
	}
	
	@Override protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.mc.getTextureManager().bindTexture(textures.CoiningGui);
		
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		this.drawTexturedModalRect(x, y, 0, 0, 176, 165);
		this.drawTexturedModalRect(x + 65, y + 28, 176, 0, 60, 43);
		
	}
	
}
