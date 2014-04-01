package ad.Genis231.Gui;

import java.awt.Color;
import java.util.ArrayList;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.Gui.Resources.RenderIcons;
import ad.Genis231.Gui.Resources.Tab;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.lib.ADItems;
import ad.Genis231.lib.textures;

public class SkillBookGui extends GuiScreen {
	int textWidth = 192, textHeight = 192;
	int tabWidth = 12, tabHeight = 24;
	int x, y;
	int space = 20;
	Tab currentTab = Tab.ONE;
	PlayerRace race;
	RenderIcons icons;
	boolean isMain = true;
	ArrayList<String> desc = new ArrayList<String>();
	
	public SkillBookGui(EntityPlayer player, World world) {
		ItemStack temp = player.inventory.getStackInSlot(player.inventory.currentItem);
		if (temp != null)
			race = this.getRacefromBook(temp);
	}
	
	protected void mouseClicked(int mouseX, int mouseY, int clicked) {
		if (clicked == 0) {
			currentTab = getClickedTab(x, y, mouseX, mouseY);
			renderDesc(mouseX, mouseY);
		} else if (clicked == 1) {
			this.isMain = true;
		}
	}
	
	@Override public void drawScreen(int mouseX, int mouseY, float par3) {
		x = (width - textWidth) / 2;
		y = (height - textHeight) / 2;
		this.mc.getTextureManager().bindTexture(textures.SkillBook);
		this.drawTexturedModalRect(x, y, 0, 0, textWidth, textHeight);
		
		if (this.isMain) {
			drawTabWithPriority(this.currentTab);
			drawIcons(mouseX, mouseY);
		} else {
			if (desc != null) {
				for (int i = 0; i < this.desc.size(); i++) {
					this.fontRendererObj.drawString(this.desc.get(i), x + 6, y + 6 + (10 * i), Color.BLACK.getRGB());
				}
			}
		}
		
		super.drawScreen(mouseX, mouseY, par3);
	}
	
	void drawTabWithPriority(Tab tab) {
		for (int i = 0; i < Tab.values().length; i++) {
			if (i != tab.getID())
				this.drawTexturedModalRect(x - tabWidth, y + (space * i) + 5, this.textWidth + 1, (tabHeight + 1) * i, tabWidth, tabHeight);
		}
		
		this.drawTexturedModalRect(x - tabWidth - 5, y + (space * tab.getID()) + 5, this.textWidth + 1, (tabHeight + 1) * tab.getID(), tabWidth + 5, tabHeight);
	}
	
	Tab getClickedTab(int x, int y, int mouseX, int mouseY) {
		for (int i = 0; i < Tab.values().length; i++) {
			int minX = x - tabWidth;
			int maxX = minX + tabWidth;
			
			int minY = y + (space * i) + 5;
			int maxY = minY + tabHeight;
			
			if (minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY)
				return Tab.values()[i];
		}
		
		return this.currentTab;
	}
	
	void drawIcons(int mouseX, int mouseY) {
		if (initIcons()) {
			ArrayList<String> list = icons.mouseOver(x, y, mouseX, mouseY, true);
			
			icons.draw();
			if (list != null)
				this.drawHoveringText(list, mouseX, mouseY, this.fontRendererObj);
		}
	}
	
	void renderDesc(int mouseX, int mouseY) {
		if (initIcons()) {
			this.desc = icons.mouseOver(this.x, this.y, mouseX, mouseY, false);
			this.isMain = desc==null;
		}
	}
	
	boolean initIcons() {
		icons = new RenderIcons(this.mc, this, this.currentTab, this.race, this.x, this.y);
		icons.registerIcons();
		
		return icons != null;
	}
	
	PlayerRace getRacefromBook(ItemStack item) {
		if (item.getItem() == ADItems.HumanBook)
			return PlayerRace.HUMAN;
		if (item.getItem() == ADItems.DwarfBook)
			return PlayerRace.DWARF;
		if (item.getItem() == ADItems.ElfBook)
			return PlayerRace.ELF;
		if (item.getItem() == ADItems.OrcBook)
			return PlayerRace.ORC;
		
		return null;
	}
}
