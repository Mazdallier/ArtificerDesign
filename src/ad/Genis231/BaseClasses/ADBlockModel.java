package ad.Genis231.BaseClasses;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;

public class ADBlockModel extends BlockContainer {
	
	public ADBlockModel(int id, Material material, String name) {
		super(id, material);
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
	}
	
	@Override public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override public boolean isOpaqueCube() {
		return false;
	}
	
	@Override public TileEntity createNewTileEntity(World world) {
		return null;
	}
}
