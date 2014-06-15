package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlockModel;
import ad.Genis231.TileEntity.PipeTileEntity;

public class PipeBlock extends ADBlockModel {
	
	public PipeBlock(String name) {
		super(Material.glass, name);
	}
	
	@Override public int getRenderType() {
		return Ref.PipeRender;
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return new PipeTileEntity();
	}
}
