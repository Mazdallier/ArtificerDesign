package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.lib.textures;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(String name) {
		super(Material.rock, name);
		setHardness(25.0f);
		this.setBlockTextureName(textures.DwarvenStone);
	}
}
