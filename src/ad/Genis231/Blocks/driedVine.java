package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import ad.Genis231.BaseClass.ADBlock;

public class driedVine extends ADBlock {
	
	public driedVine(String name, String Texture) {
		super(Material.vine, name, Texture);
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
}
