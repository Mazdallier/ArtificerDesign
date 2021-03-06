package ad.Genis231.Gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import ad.Genis231.Core.ADItems;
import ad.Genis231.Gui.Resources.BookTabs;
import ad.Genis231.Gui.Resources.RenderIcons;
import ad.Genis231.Gui.Resources.Tab;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;

public class SkillBookGui extends GuiScreen {
	int textWidth = 192, textHeight = 192;
	int tabWidth = 15, tabHeight = 30;
	public static int x, y;
	public static int tabSpace = 23;
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
	int arrowGap = 11;
	FontRenderer font;
	int maxPages;
	Minecraft mc;
	
	public SkillBookGui(EntityPlayer player) {
		mc = Minecraft.getMinecraft();
		this.font = mc.fontRenderer;
		
		ItemStack currentBook = player.inventory.getStackInSlot(player.inventory.currentItem);
		
		if (currentBook != null)
			race = this.getRacefromBook(currentBook);
	}
	
	void drawIcons(int mouseX, int mouseY) {
		if (initIcons()) {
			ArrayList<String> list = icons.renderToolTip(mouseX, mouseY);
			
			// ScaledResolution scale = new
			// ScaledResolution(this.mc.gameSettings, this.width, this.height);
			// float width = scale.getScaledWidth() / 12;
			// float height = scale.getScaledHeight() / 4.5f;
			
			icons.draw();
			if (list != null) {
				GL11.glPushMatrix();
				{
					// GL11.glScalef(0.75f, 0.75f, 0.0f);
					// GL11.glTranslatef(width, height, 0.0f);
					this.drawHoveringText(list, mouseX, mouseY, this.font);
				}
				GL11.glPopMatrix();
			}
		}
	}
	
	@Override public void drawScreen(int mouseX, int mouseY, float par3) {
		x = (width - textWidth) / 2;
		y = (height - textHeight) / 2;
		this.mc.getTextureManager().bindTexture(textures.SkillBooks[race.getID()]);
		this.drawTexturedModalRect(x, y, 0, 0, textWidth, textHeight);
		
		arrowX = x + 10;
		arrowY = y + 175;
		arrowSpace = 155;
		arrowW = 17;
		arrowH = 9;
		
		if (this.isMain) {
			drawTabWithPriority(this.currentTab);
			drawIcons(mouseX, mouseY);
			this.currentPage = 0;
		} else {
			if (this.currentPage > 0)
				if (getNewPage(mouseX, mouseY) == -1)
					this.drawTexturedModalRect(arrowX, arrowY, 0, textHeight + arrowGap, arrowW, arrowH);
				else
					this.drawTexturedModalRect(arrowX, arrowY, 0, textHeight + 1, arrowW, arrowH);
			
			if (hasNextPage())
				if (getNewPage(mouseX, mouseY) == 1)
					this.drawTexturedModalRect(arrowX + arrowSpace, arrowY, 17, textHeight + arrowGap, arrowW, arrowH);
				else
					this.drawTexturedModalRect(arrowX + arrowSpace, arrowY, 17, textHeight + 1, arrowW, arrowH);
			
			this.font.drawString(this.currentPage + 1 + "/" + (this.maxPages + 1), this.arrowX + (this.arrowSpace / 2), this.arrowY, Color.BLACK.getRGB());
			
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
				this.drawTexturedModalRect(x - tabWidth, y + (tabSpace * i) + 1, this.textWidth + 1, (tabHeight + 1) * i, tabWidth, tabHeight);
		}
		
		this.drawTexturedModalRect(x - tabWidth - 7, y + (tabSpace * tab.getID()) + 1, this.textWidth + 1, (tabHeight + 1) * tab.getID(), tabWidth + 7, tabHeight);
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			for (int i = 0; i < 8; i++) {
				int minX = x - tabWidth;
				int maxX = minX + tabWidth;
				
				int minY = y + (tabSpace * i) + 5;
				int maxY = minY + tabHeight - 10;
				
				this.mc.getTextureManager().bindTexture(new ResourceLocation(Ref.Resource_FOLDER, "textures/gui/temp.png"));
				
				this.drawTexturedModalRect(minX, minY, 0, 0, maxX - minX, maxY - minY);
			}
	}
	
	Tab getClickedTab(int x, int y, int mouseX, int mouseY) {
		for (int i = 0; i < Tab.values().length; i++) {
			int minX = x - tabWidth;
			int maxX = minX + tabWidth;
			
			int minY = y + (tabSpace * i) + 5;
			int maxY = minY + tabHeight - 10;
			
			if (minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY)
				return Tab.values()[i];
		}
		
		return this.currentTab;
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
	
	PlayerRace getRacefromBook(ItemStack item) {
		if (item.getItem() == ADItems.humanBook)
			return PlayerRace.HUMAN;
		if (item.getItem() == ADItems.dwarfBook)
			return PlayerRace.DWARF;
		if (item.getItem() == ADItems.elfBook)
			return PlayerRace.ELF;
		if (item.getItem() == ADItems.orcBook)
			return PlayerRace.ORC;
		
		return null;
	}
	
	boolean hasNextPage() {
		if (initIcons() && this.currentNode != null) {
			this.maxPages = icons.getMaxPages(this.currentNode);
			return this.currentPage < this.maxPages;
		}
		return false;
	}
	
	boolean initIcons() {
		icons = new RenderIcons(this.mc, this, this.currentTab, this.race, x, y);
		icons.registerIcons();
		
		return icons != null;
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
	
	boolean renderPage(int mouseX, int mouseY, boolean clicked) {
		List<String> temp;
		int pageNumber = this.currentPage;
		
		if (clicked)
			pageNumber += this.getNewPage(mouseX, mouseY);
		
		if (pageNumber < 0)
			pageNumber = 0;
		
		if (initIcons()) {
			
			if (this.currentNode == null)
				this.currentNode = icons.getNode(mouseX, mouseY);
			
			temp = icons.renderPage(mouseX, mouseY, pageNumber, clicked, this.currentNode);
			
			if (temp != null) {
				this.page = temp;
				this.currentPage = pageNumber;
				this.isMain = false;
				return true;
			}
		}
		
		return false;
	}
}
