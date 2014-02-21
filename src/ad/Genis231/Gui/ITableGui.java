package ad.Genis231.Gui;

import net.minecraft.block.Block;
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
	Block block;
	ITableTile table;
	float roar;
	
	public ITableGui(InventoryPlayer inventoryPlayer, ITableTile tileEntity, World world, int x, int y, int z, Block block) {
		super(new ITableContainer(inventoryPlayer, tileEntity, world, x, y, z, block));
		this.block = block;
		table = tileEntity;
	}
	
	@Override protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		this.mc.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}
	
	@Override protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(block == ADBlock.Itable1 ? textures.t1 : textures.t2);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, 176, 165);
		
		roar = table.getBurn();
		
		if (table.hasItem())
			if (block == ADBlock.Itable1) {
				// 56
				this.drawTexturedModalRect(x + 55, y + 17, 176, 0, (int) (roar * 2.8), 43);
			} else if (block == ADBlock.Itable2) {
				// 79
				this.drawTexturedModalRect(x + 34, y + 12, 176, 0, (int) (roar * 3.95), 55);
			}
	}
}
