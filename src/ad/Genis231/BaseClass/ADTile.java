package ad.Genis231.BaseClass;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;

public class ADTile extends BlockContainer {
	
	public ADTile(Material material, String name,String texture) {
		super(material);
		this.setCreativeTab(Ref.TAB);
		this.setBlockTextureName(texture);
		this.setBlockName(name);
	}

	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
	
}
