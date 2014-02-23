package ad.Genis231.BaseClasses;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;

public class ADBlockGui extends ADBlockModel {
	
	public ADBlockGui(Material material, String name) {
		super(material, name);
		this.setCreativeTab(Ref.TAB);
		this.setBlockName(name);
		this.setHardness(0.0F);
	}
}
