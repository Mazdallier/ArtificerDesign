package ad.Genis231.Gui.Resources;

public class BookIcons {
	int x;
	int y;
	int width = 13;
	int height = 13;
	boolean isActive = false;
	
	public BookIcons(int x, int y, boolean isActive) {
		this.x = x;
		this.y = y;
		this.isActive = isActive;
	}
	
	public int getTX() {
		return this.x * this.width - 1;
	}
	
	public int getTY() {
		return this.y * this.height - 1;
	}
	
	public int getWidth() {
		return this.width - 1;
	}
	
	public int getHeight() {
		return this.height - 1;
	}
}
