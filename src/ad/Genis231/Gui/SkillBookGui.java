package ad.Genis231.Gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import ad.Genis231.lib.textures;

public class SkillBookGui extends GuiScreen {
	int textWidth = 192;
	int textHeight = 192;
	
	int tabWidth = 12;
	int tabHeight = 24;
	int space = 20;
	int currentTab = 0;
	
	int x;
	int y;
	
	public SkillBookGui(EntityPlayer player, World world) {}
	
	protected void mouseClicked(int mouseX, int mouseY, int clicked) {
		if (clicked == 0)
			currentTab = getClickedTab(x, y, mouseX, mouseY);
	}
	
	@Override public void drawScreen(int mouseX, int mouseY, float par3) {
		this.mc.getTextureManager().bindTexture(textures.SkillBook);
		
		x = (width - textWidth) / 2;
		y = (height - textHeight) / 2;
		
		this.drawTexturedModalRect(x, y, 0, 0, textWidth, textHeight);
		drawTabWithPriority(this.currentTab);
		
		super.drawScreen(mouseX, mouseY, par3);
	}
	
	void drawTabWithPriority(int tabNumber) {
		for (int i = 0; i < 8; i++) {
			if (i != tabNumber)
				this.drawTexturedModalRect(x - tabWidth, y + (space * i) + 5, this.textWidth + 1, (tabHeight + 1) * i, tabWidth, tabHeight);
		}
		
		this.drawTexturedModalRect(x - tabWidth - 5, y + (space * tabNumber) + 5, this.textWidth + 1, (tabHeight + 1) * tabNumber, tabWidth + 5, tabHeight);
	}
	
	int getClickedTab(int x, int y, int mouseX, int mouseY) {
		
		for (int i = 0; i < 8; i++) {
			int minX = x - tabWidth;
			int maxX = minX + tabWidth;
			
			int minY = y + (space * i) + 5;
			int maxY = minY + tabHeight;
			
			if (minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY)
				return i;
		}
		
		return this.currentTab;
	}
}
