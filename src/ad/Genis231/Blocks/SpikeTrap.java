package ad.Genis231.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SpikeTrap extends Block {
	
	public SpikeTrap(int id) {
		super(id, Material.ground);
		setBlockBounds(0.0F, 0.0F, 0.0F, 40F, 40.0F, 40.0F);
		setTextureName("sand");
		
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
}
