package ad.Genis231.Gui;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
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
	int x, y;
	Minecraft mc;
	
	public RenderIcons(Minecraft mc, Gui gui, Tab tab, PlayerRace race, int x, int y) {
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
		
		switch (tab) {
			case ONE:
				this.registerTabOne(0);
				break;
			case TWO:
				this.registerTabTwo(2);
				break;
			case THREE:
				this.registerTabThree(4);
				break;
			case FOUR:
				this.registerTabFour(6);
				break;
			case FIVE:
				this.registerTabFive(8);
				break;
			case SIX:
				this.registerTabSix(10);
				break;
			case SEVEN:
				this.registerTabSeven(12);
				break;
			case EIGHT:
				this.registerTabEight(14);
				break;
			default:
				break;
		}
	}
	
	void registerTabOne(int row) {}
	
	void registerTabTwo(int row) {}
	
	void registerTabThree(int row) {}
	
	void registerTabFour(int row) {}
	
	void registerTabFive(int row) {}
	
	void registerTabSix(int row) {}
	
	void registerTabSeven(int row) {}
	
	void registerTabEight(int row) {}
	
	public void draw() {
		Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
		
		if (icons == null)
			return;
		
		for (BookIcons i : icons) {
			System.out.printf("X:%d Y:%d GridX:%d GridY:%d Width:%d Height:%d\n", i.getX(), i.getY(), i.getGridX(), i.getGridY(), i.getWidth(), i.getHeight());
			gui.drawTexturedModalRect(i.getX(), i.getY(), i.getGridX(), i.getGridY(), i.getWidth(), i.getHeight());
		}
		
		icons.clear();
	}
}
