package ad.Genis231.Gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Gui.Resources.BookTabs;
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
	List<String> page = new ArrayList<String>();
	BookTabs currentNode;
	int currentPage;
	int arrowX, arrowY;
	int arrowSpace;
	int arrowW, arrowH;
	FontRenderer font;
	Minecraft mc = Minecraft.getMinecraft();
	
	public SkillBookGui(EntityPlayer player, World world) {
		this.font = this.mc.fontRenderer;
		
		ItemStack temp = player.inventory.getStackInSlot(player.inventory.currentItem);
		if (temp != null)
			race = this.getRacefromBook(temp);
	}
	
	protected void mouseClicked(int mouseX, int mouseY, int clicked) {
		if (clicked == 0) {
			if (this.isMain)
				currentTab = getClickedTab(x, y, mouseX, mouseY);
			renderPage(mouseX, mouseY, true);
		} else if (clicked == 1) {
			this.currentNode = null;
			this.isMain = true;
		}
	}
	
	@Override public void drawScreen(int mouseX, int mouseY, float par3) {
		x = (width - textWidth) / 2;
		y = (height - textHeight) / 2;
		this.mc.getTextureManager().bindTexture(textures.SkillBook);
		this.drawTexturedModalRect(x, y, 0, 0, textWidth, textHeight);
		
		arrowX = x + 10;
		arrowY = y + 175;
		arrowSpace = 155;
		arrowW = 16;
		arrowH = 9;
		
		if (this.isMain) {
			drawTabWithPriority(this.currentTab);
			drawIcons(mouseX, mouseY);
			this.currentPage = 0;
		} else {
			if (this.currentPage > 0)
				this.drawTexturedModalRect(arrowX, arrowY, 0, textHeight + 1, arrowW, arrowH);
			if (hasNextPage())
				this.drawTexturedModalRect(arrowX + arrowSpace, arrowY, 17, textHeight + 1, arrowW, arrowH);
			
			if (page != null)
				for (int i = 0; i < this.page.size(); i++) {
					this.fontRendererObj.drawString(this.page.get(i), x + 6, y + 6 + (10 * i), Color.BLACK.getRGB());
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
			ArrayList<String> list = icons.renderToolTip(mouseX, mouseY);
			
			ScaledResolution scale = new ScaledResolution(this.mc.gameSettings, this.width, this.height);
			float width = scale.getScaledWidth() / 1.6f;
			float height = scale.getScaledHeight() / 4.0f;
			
			icons.draw();
			if (list != null) {
				GL11.glPushMatrix();
				GL11.glScalef(0.75f, 0.75f, 0.0f);
				GL11.glTranslatef(width, height, 0.0f);
				this.drawHoveringText(list, mouseX, mouseY, this.font);
				GL11.glPopMatrix();
			}
		}
	}
	
	boolean renderPage(int mouseX, int mouseY, boolean clicked) {
		List<String> temp = new ArrayList<String>();
		int pageNumber = this.currentPage;
		if (clicked)
			pageNumber += this.getNewPage(mouseX, mouseY);
		
		if (pageNumber < 0)
			pageNumber = 0;
		
		if (initIcons()) {
			
			if (this.currentNode == null)
				this.currentNode = icons.getNode(mouseX, mouseY);
			
			temp = icons.renderPage(mouseX, mouseY, pageNumber, this.currentNode);
			
			if (temp != null) {
				this.page = temp;
				this.currentPage = pageNumber;
				this.isMain = false;
				return true;
			}
		}
		
		return false;
	}
	
	int getNewPage(int mouseX, int mouseY) {
		int minX = this.arrowX;
		int maxX = minX + this.arrowW;
		
		int minY = this.arrowY;
		int maxY = minY + this.arrowH;
		
		if (minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY)
			return -1;
		
		minX += this.arrowSpace;
		maxX += this.arrowSpace;
		
		if (minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY)
			return 1;
		
		return 0;
	}
	
	boolean hasNextPage() {
		if (initIcons() && this.currentNode != null)
			return this.currentPage < icons.getMaxPages(this.currentNode);
		return false;
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
