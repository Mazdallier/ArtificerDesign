package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import ad.Genis231.Blocks.Entity.CustomExplosion;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;

public class FakeFire extends BlockFire {
	
	public FakeFire(int par1) {
		super(par1);
		this.disableStats();
		this.setHardness(0.0F);
		this.setLightValue(1.0F);
		this.setStepSound(soundWoodFootstep);
		this.setCreativeTab(Ref.TAB);
		this.setTextureName(textures.Fire);
	}
	
	public void initializeBlock() {}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {}
	
	public static void explode(World world, int x, int y, int z) {
		CustomExplosion explosion = new CustomExplosion(world, (Entity) null, x, y, z, 3.0f);
		explosion.isFlaming = true;
		explosion.isSmoking = true;
		
		explosion.doExplosionA();
		explosion.doExplosionB(true);
		
		System.out.println("BOOOM!!!!!");
		
	}
	
}
