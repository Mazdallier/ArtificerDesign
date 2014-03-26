package ad.Genis231.BaseClass;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import ad.Genis231.lib.Ref;

public class ADLiquid extends BlockFluidClassic {
	
	protected ADLiquid(Fluid fluid, String name) {
		super(fluid, Material.water);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockName(name);
		this.setBlockUnbreakable();
		this.setLightOpacity(3);
	}
}
