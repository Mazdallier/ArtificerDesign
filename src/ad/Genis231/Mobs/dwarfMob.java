package ad.Genis231.Mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class dwarfMob extends EntityMob {
    public float speed = 0.5F;
    
    public dwarfMob(World world) {
        super(world);
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, speed, false));
        this.tasks.addTask(2, new EntityAIEatGrass(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, speed * 4));
        this.tasks.addTask(4, new EntityAIMoveTowardsTarget(this, speed, 20));
        this.tasks.addTask(5, new EntityAIWander(this, speed));
    }
    
    protected boolean isAIEnabled() {
        return true;
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    protected int getDropItemId() {
        return Block.bedrock.blockID;
    }
}
