package ad.Genis231.Mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ad.Genis231.Items.items;

public class StatueMob extends EntityMob {
    
    public StatueMob(World world) {
        super(world);
        float speed = 5.0F;
        this.setSize(1.0f, 2.3f);
        // this.tasks.addTask(0, new EntityAISwimming(this));
        // this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, speed, false));
        // this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        // this.tasks.addTask(3, new EntityAIWander(this, speed));
        // this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        // this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16, true));
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public int getAttackStrength(Entity mob) {
        return 4;
    }
    
    protected int getDropItemId() {
        return items.VBlood.itemID;
    }
}

