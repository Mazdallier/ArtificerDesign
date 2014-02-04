package ad.Genis231.Mobs;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class dwarfMob extends EntityMob {
	public float speed = 0.5F;
	
	public dwarfMob(World world) {
		super(world);
		
		this.tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 4.0F));
		this.tasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityChicken.class, 0, true));
		this.tasks.addTask(2, new EntityAIWander(this, 0.5F));
	}
	
	protected boolean isAIEnabled() {
		return true;
	}
}
