package ad.Genis231.Blocks.Dwarf;

import net.minecraft.block.material.Material;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlock;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(String name, String texture) {
		super(Material.rock, name, texture);
		setHardness(10.0f);
		this.setCreativeTab(Ref.DwarfTab);
	}
}
