package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlock;

public class AirBlock extends ADBlock {
	
	public AirBlock(String name) {
		super(Material.iron, name, Ref.Texture_FOLDER + "air");
		this.setBlockUnbreakable();
		this.setCreativeTab(null);
	}
	
	@Override public boolean isOpaqueCube() {
		return false;
	}
}
