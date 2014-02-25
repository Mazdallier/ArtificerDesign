package ad.Genis231.Blocks;

import ad.Genis231.BaseClasses.ADBlock;
import net.minecraft.block.material.Material;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(String name,String texture) {
		super(Material.rock, name, texture);
		setHardness(10.0f);
	}
}
