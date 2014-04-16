package ad.Genis231.Blocks.Dwarf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlockModel;
import ad.Genis231.TileEntity.DTableTile;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DwarfTable extends ADBlockModel{

	public DwarfTable(String name){
		super(Material.rock,name);
		this.setCreativeTab(Ref.DwarfTab);
	}

	@Override
	public int getRenderType(){
		return Ref.DTableRender;
	}

	@Override
	public TileEntity createNewTileEntity(World var1,int var2){
		return new DTableTile();
	}
}
