package ad.Genis231.Gui.Resources;

import ad.Genis231.Player.PlayerRace;
import ad.Genis231.Resources.BookReader;

import java.util.ArrayList;

public class BookTabs{
	int gridX, gridY;
	int x, y;
	final int width = 16, height = 16;
	PlayerRace race;
	Tab tab;
	ArrayList<String> total = new ArrayList<String>();
	String desc;

	/**
	 * ALWAYS start counting from 0
	 *
	 * @param xGrix count from the left side over
	 * @param yGrid row+extra row, 'row' will put u at the first row so dont add if you just want that
	 * @param x     this is where you want it to render in the book
	 * @param y     this is where you want it to render in the book
	 */
	public BookTabs(int gridX,int gridY,int x,int y,String desc,PlayerRace race,Tab tab){
		this.gridX = gridX;
		this.gridY = gridY;
		this.x = x;
		this.y = y;
		this.desc = desc;
		this.race = race;
		this.tab = tab;
	}

	public void renderPage(){
	}

	public ArrayList<String> toolTip(ArrayList<String> list){
		list.add("THIS HAS NO TOOLTIP!");

		return list;
	}

	public ArrayList<String> getDesc(boolean clicked){
		if(clicked) this.total = new BookReader(this.desc).getText();

		return this.total;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getGridX(){
		return this.gridX * this.width;
	}

	public int getGridY(){
		return this.gridY * this.height;
	}

	public int getWidth(){
		return this.width - 1;
	}

	public int getHeight(){
		return this.height - 1;
	}

	public PlayerRace getRace(){
		return this.race;
	}

	public Tab getTab(){
		return this.tab;
	}
}
