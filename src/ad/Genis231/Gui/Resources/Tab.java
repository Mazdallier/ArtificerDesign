package ad.Genis231.Gui.Resources;

public enum Tab{
	ONE(0),
	TWO(1),
	THREE(2),
	FOUR(3),
	FIVE(4),
	SIX(5),
	SEVEN(6),
	EIGHT(7);

	int id;

	Tab(int id){
		this.id = id;
	}

	public int getID(){
		return this.id;
	}
}
