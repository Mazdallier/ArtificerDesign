package ad.Genis231.Blocks.Entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.Blocks.FakeFire;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DragonBreatheEntity extends EntityThrowable {
	public DragonBreatheEntity(World par1World, EntityLivingBase par2EntityLivingBase, ItemStack item) {
		super(par1World, par2EntityLivingBase);
	}
	
	/** Called when this EntityThrowable hits a block or entity. */
	protected void onImpact(MovingObjectPosition bottle) {
		if (!this.worldObj.isRemote) {
		FakeFire.explode(worldObj,bottle.blockX,bottle.blockY,bottle.blockZ);
		}
		
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
	
}
