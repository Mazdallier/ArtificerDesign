package ad.Genis231.Gui.Tabs;

import java.util.ArrayList;

import net.minecraft.client.renderer.texture.TextureMap;
import ad.Genis231.Gui.Resources.BookTabs;
import ad.Genis231.Gui.Resources.Tab;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.lib.StringColor;

public class DrillTab extends BookTabs {
	
	public DrillTab(int x, int y) {
		super(0, 0, x, y,"Drill", PlayerRace.DWARF, Tab.ONE);
	}
	
	@Override public ArrayList<String> toolTip(ArrayList<String> list) {
		list.add(StringColor.Light_Red + "If the tooltip dose not render correctly change ur window size");
		list.add(StringColor.Light_Red + "this will be fixed soon-ish");
		list.add("");
		list.add("This is an example of a tooltip");
		list.add("The tooltip can be pretty useful!!");
		list.add("It can display the status of the item to research");
		list.add("It can show what it requires to make or be researched");
		list.add("And pretty much anything else! :D");
		list.add("");
		list.add("dont get the wrong idea this is just an overview ");
		list.add("each node will have its own page in more detail :)");
		list.add("");
		list.add(StringColor.Purple + "You " + StringColor.Orange + "can " + StringColor.Pink + "add " + StringColor.Light_Green + "colors!!");
		
		return list;
	}
}
