package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlockModel;
import ad.Genis231.TileEntity.SpikeTileEntity;

public class Spike extends ADBlockModel {
	
	public Spike(String name) {
		super(Material.rock, name);
		this.setBlockBounds(0F, 0.0F, 0F, 1F, 0F, 1F);
		this.setHardness(5.0f);
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return new SpikeTileEntity();
	}
	
	@Override public int getRenderType() {
		return Ref.SpikeRender;
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
		
		if (!(entity instanceof EntityItem))
			entity.attackEntityFrom(DamageSource.generic, 4.0F);
	}
}
