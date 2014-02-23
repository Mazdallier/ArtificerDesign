package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.lib.textures;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(String name,String texture) {
		super(Material.rock, name, texture);
		setHardness(10.0f);
	}
}
