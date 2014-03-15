package ad.Genis231.Gui;

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
	
	int x, y;
	int buttonWidth = 30;
	int buttonHeight = 20;
	int buttonX, buttonY;
	int spaceing = 60;
	
	int drillWidth;
	int drillHeight;
	int delay;
	
	int tX, tY, tZ;
	
	DrillTile tile;
	
	public DrillGui(DrillTile te) {
		super(new DrillContainer());
		
		tile = te;
		
		drillWidth = tile.getWidth();
		drillHeight = tile.getHeight();
		delay = tile.getDelay();
		
		tX = tile.xCoord;
		tY = tile.yCoord;
		tZ = tile.zCoord;
	}
	
	@Override public void initGui() {
		super.initGui();
		x = this.width / 2;
		y = this.height / 2;
		
		buttonX = x - (buttonWidth / 3);
		buttonY = y - (buttonHeight / 3);
		
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
		switch (button.id) {
			case 0:
				drillWidth -= 5;
				break;
			
			case 1:
				drillWidth += 5;
				break;
			
			case 2:
				drillHeight -= 5;
				break;
			
			case 3:
				drillHeight += 5;
				break;
			
			case 4:
				if (delay >= 5)
					delay -= 5;
				break;
			
			case 5:
				delay += 5;
				
				break;
		}
		
		Artificer.packets.sendToServer(new DrillPacket(drillWidth, drillHeight, delay, tX, tY, tZ));
		
		drillWidth = tile.getWidth();
		drillHeight = tile.getHeight();
		delay = tile.getDelay();
	}
	
	@Override protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		mc.fontRenderer.drawString("Width: " + drillWidth, buttonX - spaceing, y, Color.BLUE.getRGB());
		mc.fontRenderer.drawString("Height: " + drillHeight, buttonX, y, Color.BLUE.getRGB());
		mc.fontRenderer.drawString("Speed: " + delay, buttonX + spaceing, y, Color.BLUE.getRGB());
	}
}
