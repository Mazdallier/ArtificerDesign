package ad.Genis231.Gui.Resources;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import ad.Genis231.Gui.Tabs.DrillTab;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.lib.textures;

public class RenderIcons {
	GuiScreen gui;
	Tab tab;
	PlayerRace race;
	ArrayList<BookTabs> icons = new ArrayList<BookTabs>();
	ResourceLocation texture;
	int x, y;
	Minecraft mc;
	
	public RenderIcons(Minecraft mc, GuiScreen gui, Tab tab, PlayerRace race, int x, int y) {
		this.gui = gui;
		this.tab = tab;
		this.race = race;
		this.x = x;
		this.y = y;
		this.texture = textures.SkillBookIcons[race.getID()];
		this.mc = mc;
		
	}
	
	public void registerIcons() {
		icons.clear();
		{
			icons.add(new DrillTab(x + 90, y + 85, PlayerRace.DWARF, Tab.ONE));
		}
		clean();
	}
	
	public void clean() {
		for (int i = 0; i < icons.size(); i++) {
			if (icons.get(i).getRace() != this.race || icons.get(i).getTab() != this.tab)
				icons.remove(i);
		}
	}
	
	public ArrayList renderToolTip(int x, int y, int mouseX, int mouseY) {
		if (icons == null)
			return null;
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (BookTabs i : icons) {
			int minX = i.getX();
			int maxX = minX + i.getWidth();
			int minY = i.getY();
			int maxY = minY + i.getHeight();
			
			if (minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY) {
				list = i.toolTip(new ArrayList<String>());
				return list;
			}
		}
		
		return null;
	}
	
	public void draw() {
		mc.getTextureManager().bindTexture(this.texture);
		
		if (icons == null)
			return;
		
		for (BookTabs i : icons) {
			gui.drawTexturedModalRect(i.getX(), i.getY(), i.getGridX(), i.getGridY(), i.getWidth(), i.getHeight());
		}
		
	}
}
