package ad.Genis231.Gui;

public class BookIcons {
	int gridX, gridY;
	int x, y;
	final int width = 16, height = 16;
	
	// boolean isActive = false;
	
	/** ALWAYS start counting from 0
	 * @param xGrix count from the left side over
	 * @param yGrid row+extra row, 'row' will put u at the first row so dont add if you just want that
	 * @param x this is where you want it to render in the book
	 * @param y this is where you want it to render in the book */
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
}
