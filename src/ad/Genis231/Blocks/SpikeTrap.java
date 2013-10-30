package ad.Genis231.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.TileEntitys.SpikeTile;
import ad.Genis231.lib.Ref;

public class SpikeTrap extends BlockContainer {
	
	public SpikeTrap(int id) {
		super(id, Material.rock);
        this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
	}
	
	@Override public boolean renderAsNormalBlock() {
		
		return false;
	}
	
	@Override public boolean isOpaqueCube() {
		
		return false;
	}
	
	@Override public int getRenderType() {
		
		return Ref.SpikeRender;
	}
	
	@Override public TileEntity createNewTileEntity(World world) {
		
		return new SpikeTile();
	}
}
