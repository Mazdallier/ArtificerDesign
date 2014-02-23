package ad.Genis231.Items;

import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.lib.ItemTexture;

public class GoldBowl extends ADItem {
	
	public GoldBowl(String name) {
		super(name);
		setMaxStackSize(1);
		setTextureName(ItemTexture.GoldBowl);
	}
}
