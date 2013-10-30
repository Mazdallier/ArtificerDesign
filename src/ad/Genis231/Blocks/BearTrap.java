package ad.Genis231.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.TileEntitys.BTrapTile;
import ad.Genis231.lib.Ref;

public class BearTrap extends BlockContainer {
	
	public BearTrap(int id) {
		super(id, Material.rock);
	}
	
	@Override public boolean renderAsNormalBlock() {
		
		return false;
	}
	
	@Override public boolean isOpaqueCube() {
		
		return false;
	}
	
	@Override public int getRenderType() {
		
		return Ref.BTrapRender;
	}
	
	@Override public TileEntity createNewTileEntity(World world) {
		
		return new BTrapTile();
	}
}
