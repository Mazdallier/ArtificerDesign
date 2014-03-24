package ad.Genis231.Blocks;

import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import ad.Genis231.Entity.CustomExplosion;
import ad.Genis231.lib.BlockTexture;
import ad.Genis231.lib.Ref;

public class FakeFire extends BlockFire {
	
	public FakeFire(String name) {
		super();
		this.disableStats();
		this.setHardness(0.0F);
		this.setCreativeTab(Ref.TAB);
		this.setBlockTextureName(BlockTexture.Fire);
		this.setLightLevel(1.0F);
		this.setBlockName(name);
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
		entity.attackEntityFrom(DamageSource.inFire, 1.0F);
	}
	
	public static void explode(World world, int x, int y, int z) {
		CustomExplosion explosion = new CustomExplosion(world, (Entity) null, x, y, z, 5.0f);
		explosion.isFlaming = true;
		explosion.isSmoking = true;
		explosion.doExplosionA();
		explosion.doExplosionB(true);
		
	}
}
