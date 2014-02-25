package ad.Genis231.Mobs;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class dwarfMob extends EntityMob {
	public dwarfMob(World world) {
		super(world);
		
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIBreakDoor(this));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		
	}
	
	protected boolean isAIEnabled() {
		return true;
	}
	
	// TODO DROP GOD DAMN ITEMS
}
