package ad.Genis231.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import ad.Genis231.TileEntitys.SpikeTile;
import ad.Genis231.lib.Ref;

public class SpikeTrap extends BlockContainer {
	
	public SpikeTrap(int id) {
		super(id, Material.rock);
	}
	public static int side = 0;
	
	//World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	public int onBlockPlaced(World world, int x, int y, int z, int s, float hitX, float hitY, float hitZ, int meta) {
		side = s;
		return meta;
	}
	
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
		entity.attackEntityFrom(DamageSource.generic, 1.0F);
	}
	
	@Override public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override public boolean isOpaqueCube() {
		return false;
	}
	
	@Override public int getRenderType() {
		return Ref.SpikeRender;
	}
	
	@Override public TileEntity createNewTileEntity(World world) {
		return new SpikeTile();
	}
}
