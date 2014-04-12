package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADBlockModel;
import ad.Genis231.TileEntity.GeneratorTile;
import ad.Genis231.lib.Ref;

public class GeneratorBlock extends ADBlockModel {
	
	public GeneratorBlock(String name) {
		super(Material.iron, name);
	}
	
	@Override public int getRenderType() {
		return Ref.GeneratorRender;
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return new GeneratorTile();
	}
}
