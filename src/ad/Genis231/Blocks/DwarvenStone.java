package ad.Genis231.Blocks;

import ad.Genis231.lib.textures;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DwarvenStone extends ADBlock{

	public DwarvenStone(int id,String name) {
		super(id,Material.rock,name);
		setHardness(25.0f);
		setTextureName(textures.DStone);
	}
	
}
