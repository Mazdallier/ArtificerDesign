package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADBlockModel;
import ad.Genis231.TileEntity.SpikeTile;
import ad.Genis231.lib.Ref;

public class SpikeTrap extends ADBlockModel {
	
	public SpikeTrap(int id, String name) {
		super(id, Material.rock, name);
		this.setBlockBounds(0F, 0.0F, 0F, 1F, 0F, 1F);
		this.setHardness(5.0f);
	}
	
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
		
		if (!(entity instanceof EntityItem))
			entity.attackEntityFrom(DamageSource.generic, 4.0F);
	}
	
	@Override public int getRenderType() {
		return Ref.SpikeRender;
	}
	
	@Override public TileEntity createNewTileEntity(World world) {
		return new SpikeTile();
	}
	
	public int idDropped(int par1, Random random, int par3) {
		return ADBlock.Spike.blockID;
	}
}
