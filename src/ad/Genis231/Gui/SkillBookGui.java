package ad.Genis231.Gui;

import java.util.ArrayList;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Gui.Resources.RenderIcons;
import ad.Genis231.Gui.Resources.Tab;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.lib.ADItems;
import ad.Genis231.lib.textures;

public class SkillBookGui extends GuiScreen {
	int textWidth = 192;
	int textHeight = 192;
	
	int tabWidth = 12;
	int tabHeight = 24;
	int space = 20;
	Tab currentTab = Tab.ONE;
	PlayerRace race;
	int x, y;
	RenderIcons icons;
	
	public SkillBookGui(EntityPlayer player, World world) {
		ItemStack temp = player.inventory.getStackInSlot(player.inventory.currentItem);
		if (temp != null)
			race = this.getRacefromBook(temp);
	}
	
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
		drawIcons(mouseX, mouseY);
		
		super.drawScreen(mouseX, mouseY, par3);
	}
	
	void drawTabWithPriority(Tab tab) {
		for (int i = 0; i < 8; i++) {
			if (i != tab.getID())
				this.drawTexturedModalRect(x - tabWidth, y + (space * i) + 5, this.textWidth + 1, (tabHeight + 1) * i, tabWidth, tabHeight);
		}
		
		this.drawTexturedModalRect(x - tabWidth - 5, y + (space * tab.getID()) + 5, this.textWidth + 1, (tabHeight + 1) * tab.getID(), tabWidth + 5, tabHeight);
	}
	
	Tab getClickedTab(int x, int y, int mouseX, int mouseY) {
		
		for (int i = 0; i < 8; i++) {
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
		icons = new RenderIcons(this.mc, this, this.currentTab, this.race, this.x, this.y);
		icons.registerIcons();
		icons.draw();
		
		ArrayList list = icons.renderToolTip(x, y, mouseX, mouseY);
		FontRenderer font = this.fontRendererObj;
		ScaledResolution scale = new ScaledResolution(this.mc.gameSettings, this.width, this.height);
		float width = scale.getScaledWidth()/1.4f;
		float height = scale.getScaledHeight() / 4.0f;
		
		if (list != null) {
			GL11.glPushMatrix();
			GL11.glScalef(0.75f, 0.75f, 0.0f);
			GL11.glTranslatef(width, height, 0.0f);
			this.drawHoveringText(list, mouseX, mouseY, font);
			GL11.glPopMatrix();
		}
		
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
