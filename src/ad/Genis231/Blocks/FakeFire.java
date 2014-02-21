package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;

public class FakeFire extends BlockFire {
	
	public FakeFire() {
		this.disableStats();
		this.setHardness(0.0F);
		this.setCreativeTab(Ref.TAB);
		this.setBlockTextureName(textures.Fire);
		this.setLightLevel(1.0F);
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
		entity.attackEntityFrom(DamageSource.inFire, 1.0F);
	}
	
	public static void func_149843_e() {}
	
	@Override public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {}
	
	public static void explode(World world, int x, int y, int z) {
		// CustomExplosion explosion = new CustomExplosion(world, (Entity) null, x, y, z, 5.0f);
		//
		// explosion.isFlaming = true;
		// explosion.isSmoking = true;
		//
		// explosion.doExplosionA();
		// explosion.doExplosionB(true);
		
		System.out.println("BOOOM!!!!!");
		
	}
}
