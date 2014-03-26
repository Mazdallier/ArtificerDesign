package ad.Genis231.BaseClass;

import net.minecraft.item.Item;
import ad.Genis231.lib.Ref;

public class ADItem extends Item {
	
	/** Basic Constructor
	 * @param name This is the UnlocalizedName */
	public ADItem(String name) {
		super();
		this.setCreativeTab(Ref.MainTab);
		this.setUnlocalizedName(name);
	}
	
	/** Basic Constructor with texture mapping
	 * @param name This is the UnlocalizedName
	 * @param Texture This is the Texture for said item */
	public ADItem(String name, String Texture) {
		super();
		this.setCreativeTab(Ref.MainTab);
		this.setUnlocalizedName(name);
		this.setTextureName(Texture);
	}
	
}
