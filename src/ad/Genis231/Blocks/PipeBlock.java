package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlockModel;
import ad.Genis231.TileEntity.PipeTileEntity;

public class PipeBlock extends ADBlockModel {
	float min = 0.2f;
	float max = 0.8f;
	
	public PipeBlock(String name) {
		super(Material.glass, name);
		this.setBlockBounds(min, min, min, max, max, max);
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return new PipeTileEntity();
	}
	
	// TODO: fix this mess! .-.
	
	// public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB AABB, List list, Entity entity) {
	// if (world.isRemote)
	// return;
	//
	// float minX, minY, minZ;
	// float maxX, maxY, maxZ;
	//
	// boolean negX = world.getTileEntity(x - 1, y, z) instanceof PipeTileEntity;
	// boolean negY = world.getTileEntity(x, y - 1, z) instanceof PipeTileEntity;
	// boolean negZ = world.getTileEntity(x, y, z - 1) instanceof PipeTileEntity;
	//
	// boolean posX = world.getTileEntity(x + 1, y, z) instanceof PipeTileEntity;
	// boolean posY = world.getTileEntity(x, y + 1, z) instanceof PipeTileEntity;
	// boolean posZ = world.getTileEntity(x, y, z + 1) instanceof PipeTileEntity;
	//
	// minX = negX ? 0f : min;
	// minY = negY ? 0f : min;
	// minZ = negZ ? 0f : min;
	//
	// maxX = posX ? 1f : max;
	// maxY = posY ? 1f : max;
	// maxZ = posZ ? 1f : max;
	//
	// this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
	// }
	
	@Override public int getRenderType() {
		return Ref.PipeRender;
	}
}
