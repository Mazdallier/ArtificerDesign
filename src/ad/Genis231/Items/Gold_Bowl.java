package ad.Genis231.Items;

import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;
import net.minecraft.item.Item;

public class Gold_Bowl extends Item {
	
	public Gold_Bowl(int id) {
		super(id);
		setMaxStackSize(1);
		setTextureName(textures.GoldBowl);
		setUnlocalizedName("GoldBowl");
	}
	
}
