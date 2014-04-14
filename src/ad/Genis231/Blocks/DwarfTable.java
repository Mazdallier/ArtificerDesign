package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADBlockModel;
import ad.Genis231.TileEntity.model.DTableTile;
import ad.Genis231.lib.Ref;

public class DwarfTable extends ADBlockModel {
	
	public DwarfTable(String name) {
		super(Material.rock, name);
	}
	
	@Override public int getRenderType() {
		return Ref.DTableRender;
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return new DTableTile();
	}
}
