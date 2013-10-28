package ad.Genis231.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SpikeTrap extends Block {
	
	public SpikeTrap(int id) {
		super(id, Material.ground);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
		setTextureName("sand");
		
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
}
