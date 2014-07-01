package ad.Genis231.Gui.Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.XMLReader;

public class RenderIcons {
	GuiScreen gui;
	Tab tab;
	PlayerRace race;
	ArrayList<BookTabs> icons = new ArrayList<BookTabs>();
	ResourceLocation texture;
	int x, y;
	public final int maxLines = 16;
	Minecraft mc;
	List<String> page = new ArrayList<String>();
	
	public RenderIcons(Minecraft mc, GuiScreen gui, Tab tab, PlayerRace race, int x, int y) {
		this.gui = gui;
		this.tab = tab;
		this.race = race;
		this.x = x;
		this.y = y;
		this.texture = textures.SkillBookIcons[race.getID()];
		this.mc = mc;
		
	}
	
	public void draw() {
		mc.getTextureManager().bindTexture(this.texture);
		
		if (icons == null)
			return;
		
		for (BookTabs i : icons) {
			gui.drawTexturedModalRect(i.getX(), i.getY(), i.getGridX(), i.getGridY(), i.getWidth(), i.getHeight());
		}
		
	}
	
	public int getMaxPages(BookTabs tab) {
		List<String> list = new ArrayList<String>();
		list = tab.getDesc(false);
		return (list.size() - 1) / this.maxLines;
	}
	
	public BookTabs getNode(int mouseX, int mouseY) {
		if (icons == null)
			return null;
		
		for (BookTabs i : icons) {
			int minX = i.getX();
			int maxX = minX + i.getWidth();
			int minY = i.getY();
			int maxY = minY + i.getHeight();
			
			if (minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY)
				return i;
		}
		
		return null;
	}
	
	private XMLReader initXML(PlayerRace race) {
		XMLReader reader = new XMLReader();
		
		switch (race) {
			case DWARF:
				reader.initXML("dwarf.xml");
				return reader;
			case ELF:
				reader.initXML("elf.xml");
				return reader;
			case HUMAN:
				reader.initXML("human.xml");
				return reader;
			case ORC:
				reader.initXML("orc.xml");
				return reader;
			default:
				System.out.println("Invalid Race (race == null)");
				return reader;
		}
	}
	
	public void registerIcons() {
		this.icons.clear();
		{
			XMLReader reader = initXML(race);
			
			ArrayList<HashMap<String, String>> temp = reader.getNodes();
			
			for (HashMap<String, String> nodes : temp) {
				BookTabs tabs = new BookTabs(nodes, race);
				
				if (this.tab == tabs.getTab())
					icons.add(tabs);
			}
		}
	}
	
	public List<String> renderPage(int mouseX, int mouseY, int newPage, boolean clicked, BookTabs tab) {
		if (!clicked && page != null)
			return page;
		
		List<String> list = new ArrayList<String>();
		
		double maxPages;
		
		if (this.icons == null || tab == null)
			return null;
		
		list = tab.getDesc(clicked);
		
		maxPages = (double) list.size() / (double) this.maxLines;
		
		if (newPage > maxPages)
			return null;
		
		int newSize = this.maxLines * (newPage + 1);
		
		if (maxPages >= newPage) {
			page = list.subList(this.maxLines * newPage, newSize < list.size() ? newSize : list.size());
			return page;
		} else
			return list;
		
	}
	
	public ArrayList<String> renderToolTip(int mouseX, int mouseY) {
		ArrayList<String> list = new ArrayList<String>();
		BookTabs tab = getNode(mouseX, mouseY);
		
		if (this.icons == null || tab == null)
			return null;
		
		list = tab.toolTip(new ArrayList<String>());
		
		return list;
	}
}
