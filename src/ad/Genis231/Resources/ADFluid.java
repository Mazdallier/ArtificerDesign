package ad.Genis231.Resources;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import ad.Genis231.Refrence.Ref;

public class ADFluid extends BlockFluidClassic {
	
	protected ADFluid(Fluid fluid, String name) {
		super(fluid, Material.water);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockName(name);
		this.setBlockUnbreakable();
		this.setLightOpacity(3);
	}
}
