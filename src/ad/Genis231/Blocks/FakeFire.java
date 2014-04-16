package ad.Genis231.Blocks;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class FakeFire extends BlockFire{

	public FakeFire(String name){
		super();
		this.disableStats();
		this.setHardness(0.0F);
		this.setCreativeTab(Ref.MainTab);
		this.setBlockTextureName(textures.Fire);
		this.setLightLevel(1.0F);
		this.setBlockName(name);
	}

	public void onEntityCollidedWithBlock(World world,int x,int y,int z,Entity entity){
		super.onEntityWalking(world,x,y,z,entity);
		entity.attackEntityFrom(DamageSource.inFire,1.0F);
	}

	public static void explode(World world,int x,int y,int z){
		world.createExplosion( null,(double) x,(double) y,(double) z,5.0f,true);
	}
}
