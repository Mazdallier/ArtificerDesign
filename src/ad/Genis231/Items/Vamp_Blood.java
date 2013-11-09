package ad.Genis231.Items;

import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;
import net.minecraft.item.Item;

public class Vamp_Blood extends Item {
	
	public Vamp_Blood(int id) {
		super(id);
		setMaxStackSize(16);
		setUnlocalizedName("VampireBlood");
		setTextureName(textures.VampBlood);
	}
}
