package ad.Genis231.Blocks;

import ad.Genis231.lib.Ref;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ADBlockContainer extends BlockContainer {
	
	protected ADBlockContainer(int id, Material material, String name) {
		super(id, material);
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
}
