package ad.Genis231.Gui.Resources;

import ad.Genis231.Gui.Tabs.DrillTab;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.Refrence.textures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class RenderIcons{
	GuiScreen gui;
	Tab tab;
	PlayerRace race;
	ArrayList<BookTabs> icons;
	ResourceLocation texture;
	int x, y;
	public final int maxLines = 16;
	Minecraft mc;
	List<String> page;

	public RenderIcons(Minecraft mc,GuiScreen gui,Tab tab,PlayerRace race,int x,int y){
		this.gui = gui;
		this.tab = tab;
		this.race = race;
		this.x = x;
		this.y = y;
		this.texture = textures.SkillBookIcons[race.getID()];
		this.mc = mc;

	}

	public void registerIcons(){
		this.icons.clear();
		{
			this.icons.add(new DrillTab(x + 90,y + 85));
		}
		clean();
	}

	public void clean(){
		for(int i = 0; i < this.icons.size(); i++){
			if(this.icons.get(i).getRace() != this.race || this.icons.get(i).getTab() != this.tab) this.icons.remove(i);
		}
	}

	public ArrayList<String> renderToolTip(int mouseX,int mouseY){
		ArrayList<String> list;
		BookTabs tab = getNode(mouseX,mouseY);

		if(this.icons == null || tab == null) return null;

		list = tab.toolTip(new ArrayList<String>());

		return list;
	}

	public List<String> renderPage(int newPage,boolean clicked,BookTabs tab){
		if(!clicked && page != null) return page;

		List<String> list;

		double maxPages;

		if(this.icons == null || tab == null) return null;

		list = tab.getDesc(clicked);

		maxPages = (double) list.size() / (double) this.maxLines;

		if(newPage > maxPages) return null;

		int newSize = this.maxLines * (newPage + 1);

		if(maxPages >= newPage){
			page = list.subList(this.maxLines * newPage,newSize < list.size() ? newSize : list.size());
			return page;
		}else return list;

	}

	public int getMaxPages(BookTabs tab){
		List<String> list;
		list = tab.getDesc(false);
		return (list.size() - 1) / this.maxLines;
	}

	public BookTabs getNode(int mouseX,int mouseY){
		if(icons == null) return null;

		for(BookTabs i : icons){
			int minX = i.getX();
			int maxX = minX + i.getWidth();
			int minY = i.getY();
			int maxY = minY + i.getHeight();

			if(minX <= mouseX && maxX >= mouseX && minY <= mouseY && maxY >= mouseY) return i;
		}

		return null;
	}

	public void draw(){
		mc.getTextureManager().bindTexture(this.texture);

		if(icons == null) return;

		for(BookTabs i : icons){
			gui.drawTexturedModalRect(i.getX(),i.getY(),i.getGridX(),i.getGridY(),i.getWidth(),i.getHeight());
		}

	}
}
