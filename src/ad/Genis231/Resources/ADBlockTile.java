package ad.Genis231.Resources;

import ad.Genis231.Refrence.Ref;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ADBlockTile extends BlockContainer{

	public ADBlockTile(Material material,String name,String texture){
		super(material);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockTextureName(texture);
		this.setBlockName(name);
	}

	public ADBlockTile(Material material,String name){
		super(material);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockName(name);
	}

	@Override
	public TileEntity createNewTileEntity(World var1,int var2){
		return null;
	}

}
