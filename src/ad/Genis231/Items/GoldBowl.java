package ad.Genis231.Items;

import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.lib.textures;

public class GoldBowl extends ADItem {
	
	public GoldBowl(int id, String name) {
		super(id, name);
		setMaxStackSize(1);
		setTextureName(textures.GoldBowl);
		setUnlocalizedName("GoldBowl");
	}
	
}
