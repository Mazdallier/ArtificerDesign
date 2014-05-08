package ad.Genis231.Gui.Resources;

import java.util.ArrayList;
import java.util.HashMap;

import ad.Genis231.Gui.SkillBookGui;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.Resources.BookReader;
import ad.Genis231.Resources.StringColor;

public class BookTabs {
	int gridX, gridY;
	int x, y;
	final int width = 16, height = 16;
	Tab tab;
	ArrayList<String> total = new ArrayList<String>();
	String title;
	String tooltip;
	String file;
	
	public BookTabs(HashMap<String, String> nodes, PlayerRace race) {
		this.gridX = Integer.parseInt(nodes.get("gridX").trim());
		this.gridY = Integer.parseInt(nodes.get("gridY").trim());
		this.x = Integer.parseInt(nodes.get("posX").trim());
		this.y = Integer.parseInt(nodes.get("posY").trim());
		this.tooltip = nodes.get("desc");
		this.title = nodes.get("name");
		this.tab = Tab.values()[Integer.parseInt(nodes.get("tab").trim()) - 1];
		this.file = race.getName() + "/" + nodes.get("page");
	}
	
	public void renderPage() {}
	
	public ArrayList<String> toolTip(ArrayList<String> list) {
		String[] temp = tooltip.split("\n");
		
		list.add(StringColor.Light_Red + title);
		
		for (String i : temp)
			list.add(i);
		
		return list;
	}
	
	public ArrayList<String> getDesc(boolean clicked) {
		if (clicked)
			this.total = new BookReader(this.file).getText();
		
		return this.total;
	}
	
	public int getX() {
		return this.x + SkillBookGui.x;
	}
	
	public int getY() {
		return this.y + SkillBookGui.y;
	}
	
	public int getGridX() {
		return this.gridX * this.width;
	}
	
	public int getGridY() {
		return this.gridY * this.height;
	}
	
	public int getWidth() {
		return this.width - 1;
	}
	
	public int getHeight() {
		return this.height - 1;
	}
	
	public Tab getTab() {
		return this.tab;
	}
}
