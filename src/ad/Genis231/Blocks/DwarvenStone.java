package ad.Genis231.Blocks;

import ad.Genis231.lib.textures;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DwarvenStone extends Block{

	public DwarvenStone(int id) {
		super(id,Material.rock);
		setHardness(25.0f);
		setTextureName(textures.DStone);
	}
	
}
