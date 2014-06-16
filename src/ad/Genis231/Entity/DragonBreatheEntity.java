package ad.Genis231.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import ad.Genis231.Blocks.FakeFire;

public class DragonBreatheEntity extends EntitySnowball {
	public DragonBreatheEntity(World par1World, EntityLivingBase par2EntityLivingBase, ItemStack item) {
		super(par1World, par2EntityLivingBase);
	}
	
	/** Called when this EntityThrowable hits a block or entity. */
	protected void onImpact(MovingObjectPosition bottle) {
		if (!this.worldObj.isRemote) {
			FakeFire.explode(worldObj, bottle.blockX, bottle.blockY, bottle.blockZ);
		}
		
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}
