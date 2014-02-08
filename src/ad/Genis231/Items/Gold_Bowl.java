package ad.Genis231.Items;

import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.lib.textures;

public class Gold_Bowl extends ADItem {
	
	public Gold_Bowl(int id, String name) {
		super(id, name);
		setMaxStackSize(1);
		setTextureName(textures.GoldBowl);
		setUnlocalizedName("GoldBowl");
	}
	
}
