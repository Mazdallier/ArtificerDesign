package ad.Genis231.Gui;

public class BookIcons {
	int gridX, gridY;
	int x, y;
	final int width = 13, height = 13;
	boolean isActive = false;
	
	public BookIcons(int gridX, int gridY, int x, int y) {
		this.gridX = gridX;
		this.gridY = gridY;
		this.x = x;
		this.y = y;
		// this.isActive = isActive;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getGridX() {
		return this.gridX * this.width - 1;
	}
	
	public int getGridY() {
		return this.gridY * this.height - 1;
	}
	
	public int getWidth() {
		return this.width - 1;
	}
	
	public int getHeight() {
		return this.height - 1;
	}
}
