package ad.Genis231.Resources;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Refrence.Ref;

public class ADBlockModel extends BlockContainer {
	
	public ADBlockModel(Material material, String name) {
		super(material);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockName(name);
		this.setHardness(0.0F);
		this.setBlockTextureName("");
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}
	
	@Override public boolean isOpaqueCube() {
		return false;
	}
	
	@Override public boolean renderAsNormalBlock() {
		return false;
	}
}
