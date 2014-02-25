package ad.Genis231.BaseClasses;

import ad.Genis231.lib.Ref;
import net.minecraft.block.material.Material;

public class ADBlockGui extends ADBlockModel {
	
	public ADBlockGui(Material material, String name) {
		super(material, name);
		this.setCreativeTab(Ref.TAB);
		this.setBlockName(name);
		this.setHardness(0.0F);
	}
}
