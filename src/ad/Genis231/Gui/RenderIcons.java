package ad.Genis231.Gui;

import java.util.ArrayList;

import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.lib.textures;

public class RenderIcons {
	Gui gui;
	Tab tab;
	PlayerRace race;
	ArrayList<BookIcons> icons = new ArrayList<BookIcons>();
	ResourceLocation texture;
	
	public RenderIcons(Gui gui, Tab tab, PlayerRace race) {
		this.gui = gui;
		this.tab = tab;
		this.race = race;
		
		this.texture = textures.SkillBookIcons[race.getID()];
		
	}
	
	public void registerIcons() {
		switch (tab) {
			case ONE:
				this.registerTabOne();
				break;
			case TWO:
				this.registerTabTwo();
				break;
			case THREE:
				this.registerTabThree();
				break;
			case FOUR:
				this.registerTabFour();
				break;
			case FIVE:
				this.registerTabFive();
				break;
			case SIX:
				this.registerTabSix();
				break;
			case SEVEN:
				this.registerTabSeven();
				break;
			case EIGHT:
				this.registerTabEight();
				break;
			default:
				break;
		}
	}
	
	public void registerTabOne() {}
	
	public void registerTabTwo() {}
	
	public void registerTabThree() {}
	
	public void registerTabFour() {}
	
	public void registerTabFive() {}
	
	public void registerTabSix() {}
	
	public void registerTabSeven() {}
	
	public void registerTabEight() {}
	
	public void draw() {
		if (icons == null)
			return;
		
		for (BookIcons i : icons) {
			gui.drawTexturedModalRect(i.getX(), i.getY(), i.getGridX(), i.getGridY(), i.getWidth(), i.getHeight());
		}
		
		icons.clear();
	}
}
