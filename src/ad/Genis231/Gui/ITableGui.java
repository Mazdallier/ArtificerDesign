package ad.Genis231.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.Containers.ITableContainer;
import ad.Genis231.TileEntity.ITableTile;
import ad.Genis231.lib.textures;

public class ITableGui extends GuiContainer {
	int blockid;
	
	public ITableGui(InventoryPlayer inventoryPlayer, ITableTile tileEntity, World world, int x, int y, int z, int id) {
		super(new ITableContainer(inventoryPlayer, tileEntity, world, x, y, z, id));
		blockid = id;
	}
	
	@Override protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}
	
	@Override protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(blockid == ADBlock.ItableT1.blockID ? textures.t1 : textures.t2);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}
