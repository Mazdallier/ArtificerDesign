package ad.Genis231.Gui.Screen;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import ad.Genis231.Containers.DrillContainer;
import ad.Genis231.Core.Artificer;
import ad.Genis231.Network.Packets.DrillPacket;
import ad.Genis231.TileEntity.DrillTile;

public class DrillGui extends GuiContainer {
	Minecraft mc = Minecraft.getMinecraft();
	
	DrillTile tile;
	
	int centerX, centerY;
	int buttonWidth = 30;
	int buttonHeight = 20;
	int buttonX, buttonY;
	int spaceing = 60;
	
	int color = Color.BLUE.getRGB();
	
	int Width;
	int Height;
	int delay;
	
	int tileX, tileY, tileZ;
	
	
	
	public DrillGui(DrillTile te) {
		super(new DrillContainer());
		
		this.tile = te;
		
		this.Width = tile.getWidth();
		this.Height = tile.getHeight();
		this.delay = tile.getDelay();
		
		this.tileX = tile.xCoord;
		this.tileY = tile.yCoord;
		this.tileZ = tile.zCoord;
	}
	
	@SuppressWarnings("unchecked") @Override public void initGui() {
		super.initGui();
		
		this.centerX = this.width / 2;
		this.centerY = this.height / 2;
		
		this.buttonX = centerX - (buttonWidth / 3);
		this.buttonY = centerY - (buttonHeight / 3);
		
		// make buttons
		// id, x, y, width, height, text
		
		// Width
		buttonList.add(new GuiButton(0, buttonX - spaceing, buttonY - spaceing, buttonWidth, buttonHeight, "--"));
		buttonList.add(new GuiButton(1, buttonX - spaceing, buttonY + spaceing, buttonWidth, buttonHeight, "++"));
		
		// Height
		buttonList.add(new GuiButton(2, buttonX, buttonY - spaceing, buttonWidth, buttonHeight, "--"));
		buttonList.add(new GuiButton(3, buttonX, buttonY + spaceing, buttonWidth, buttonHeight, "++"));
		
		// Speed
		buttonList.add(new GuiButton(4, buttonX + spaceing, buttonY - spaceing, buttonWidth, buttonHeight, "--"));
		buttonList.add(new GuiButton(5, buttonX + spaceing, buttonY + spaceing, buttonWidth, buttonHeight, "++"));
	}
	
	@Override protected void actionPerformed(GuiButton button) {
		Width = tile.getWidth();
		Height = tile.getHeight();
		delay = tile.getDelay();
		
		switch (button.id) {
			case 0:
				this.Width -= 5;
				break;
			
			case 1:
				this.Width += 5;
				break;
			
			case 2:
				this.Height -= 5;
				break;
			
			case 3:
				this.Height += 5;
				break;
			
			case 4:
				if (delay >= 5)
					this.delay -= 5;
				break;
			
			case 5:
				this.delay += 5;
				
				break;
		}
		
		Artificer.packets.sendToServer(new DrillPacket(Width, Height, delay, tileX, tileY, tileZ));
	}
	
	@Override protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		mc.fontRenderer.drawString("Width: " + Width, buttonX - spaceing, centerY, color);
		mc.fontRenderer.drawString("Height: " + Height, buttonX, centerY, color);
		mc.fontRenderer.drawString("Speed: " + delay, buttonX + spaceing, centerY, color);
	}
}