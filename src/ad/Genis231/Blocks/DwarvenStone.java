package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.lib.textures;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(int id, String name) {
		super(id, Material.rock, name);
		setHardness(25.0f);
		setTextureName(textures.DwarvenStone);
	}
	
}
