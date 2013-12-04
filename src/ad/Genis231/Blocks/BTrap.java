package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import ad.Genis231.Render.TileEntity.BearTrapTile;
import ad.Genis231.Render.TileEntity.SpikeTile;
import ad.Genis231.lib.Ref;

public class BTrap extends BlockContainer {
	
	public BTrap(int id) {
		super(id, Material.rock);
		this.setBlockBounds(0F, 0.0F, 0F, 1F, 0F, 1F);
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
		//TODO updates the State of the Block and makes you have to reset it;
		entity.attackEntityFrom(DamageSource.generic, 1.0F);
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return Ref.BTrapRender;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new BearTrapTile();
	}
	
	public int idDropped(int par1, Random random, int par3) {
		return this.blockID;
	}
}
