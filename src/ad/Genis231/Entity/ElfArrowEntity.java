package ad.Genis231.Entity;

import ad.Genis231.Core.ADItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public class ElfArrowEntity extends EntityArrow {
	private int field_145791_d = -1;
	private int field_145792_e = -1;
	private int field_145789_f = -1;
	private Block stuckBlock;
	private int inData;
	private boolean inGround;
	/** 1 if the player can pick up the arrow */
	public int canBePickedUp;
	/** Seems to be some sort of timer for animating an arrow. */
	public int arrowShake;
	/** The owner of this arrow. */
	public Entity shootingEntity;
	private int ticksInGround;
	private int ticksInAir;
	private double damage = 2.0D;
	/** The amount of knockback an arrow applies when it hits a mob. */
	private int knockbackStrength;
	
	public ElfArrowEntity(World world) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
	}
	
	public ElfArrowEntity(World world, double x, double y, double z) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.setSize(0.5F, 0.5F);
		this.setPosition(x, y, z);
		this.yOffset = 0.0F;
	}
	
	public ElfArrowEntity(World world, EntityLivingBase player, EntityLivingBase entity, float z, float direction) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = player;
		
		if (player instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}
		
		this.posY = player.posY + (double) player.getEyeHeight() - 0.10000000149011612D;
		double d0 = entity.posX - player.posX;
		double d1 = entity.boundingBox.minY + (double) (entity.height / 3.0F) - this.posY;
		double d2 = entity.posZ - player.posZ;
		double d3 = (double) MathHelper.sqrt_double(d0 * d0 + d2 * d2);
		
		if (d3 >= 1.0E-7D) {
			float f2 = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			float f3 = (float) (-(Math.atan2(d1, d3) * 180.0D / Math.PI));
			double d4 = d0 / d3;
			double d5 = d2 / d3;
			this.setLocationAndAngles(player.posX + d4, this.posY, player.posZ + d5, f2, f3);
			this.yOffset = 0.0F;
			float f4 = (float) d3 * 0.2F;
			this.setThrowableHeading(d0, d1 + (double) f4, d2, z, direction);
		}
	}
	
	public ElfArrowEntity(World world, EntityLivingBase player, float z) {
		super(world);
		this.renderDistanceWeight = 10.0D;
		this.shootingEntity = player;
		
		if (player instanceof EntityPlayer) {
			this.canBePickedUp = 1;
		}
		
		this.setSize(0.5F, 0.5F);
		this.setLocationAndAngles(player.posX, player.posY + (double) player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
		this.posX -= (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		this.posY -= 0.10000000149011612D;
		this.posZ -= (double) (MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		this.motionX = (double) (-MathHelper.sin(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
		this.motionZ = (double) (MathHelper.cos(this.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float) Math.PI));
		this.motionY = (double) (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, z * 1.5F, 1.0F);
	}
	
	protected void entityInit() {
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
	}
	
	/** Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction. */
	public void setThrowableHeading(double a, double x, double y, float z, float direction) {
		float f2 = MathHelper.sqrt_double(a * a + x * x + y * y);
		a /= (double) f2;
		x /= (double) f2;
		y /= (double) f2;
		a += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) direction;
		x += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) direction;
		y += this.rand.nextGaussian() * (double) (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double) direction;
		a *= (double) z;
		x *= (double) z;
		y *= (double) z;
		this.motionX = a;
		this.motionY = x;
		this.motionZ = y;
		float f3 = MathHelper.sqrt_double(a * a + y * y);
		this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(a, y) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(x, (double) f3) * 180.0D / Math.PI);
		this.ticksInGround = 0;
	}
	
	/** Sets the position and rotation. Only difference from the other one is no bounding on the rotation. Args: posX, posY, posZ, yaw, pitch */
	@SideOnly(Side.CLIENT) public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int unknown) {
		this.setPosition(x, y, z);
		this.setRotation(yaw, pitch);
	}
	
	/** Sets the velocity to the args. Args: x, y, z */
	@SideOnly(Side.CLIENT) public void setVelocity(double x, double y, double z) {
		this.motionX = x;
		this.motionY = y;
		this.motionZ = z;
		
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt_double(x * x + z * z);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(x, z) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(y, (double) f) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.ticksInGround = 0;
		}
	}
	
	/** Called to update the entity's position/logic. */
	public void onUpdate() {
		super.onUpdate();
		
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f) * 180.0D / Math.PI);
		}
		
		Block block = this.worldObj.getBlock(this.field_145791_d, this.field_145792_e, this.field_145789_f);
		
		if (block.getMaterial() != Material.air) {
			block.setBlockBoundsBasedOnState(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f);
			AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f);
			
			if (axisalignedbb != null && axisalignedbb.isVecInside(this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ))) {
				this.inGround = true;
			}
		}
		
		if (this.arrowShake > 0) {
			--this.arrowShake;
		}
		
		if (this.inGround) {
			int j = this.worldObj.getBlockMetadata(this.field_145791_d, this.field_145792_e, this.field_145789_f);
			
			if (block == this.stuckBlock && j == this.inData) {
				++this.ticksInGround;
				
				if (this.ticksInGround == 1200) {
					this.setDead();
				}
			} else {
				this.inGround = false;
				this.motionX *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionY *= (double) (this.rand.nextFloat() * 0.2F);
				this.motionZ *= (double) (this.rand.nextFloat() * 0.2F);
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
		} else {
			++this.ticksInAir;
			Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
			Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
			vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
			vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			
			if (movingobjectposition != null) {
				vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
			}
			
			Entity entity = null;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			int i;
			float f1;
			
			for (i = 0; i < list.size(); ++i) {
				Entity entity1 = (Entity) list.get(i);
				
				if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)) {
					f1 = 0.3F;
					AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double) f1, (double) f1, (double) f1);
					MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);
					
					if (movingobjectposition1 != null) {
						double d1 = vec31.distanceTo(movingobjectposition1.hitVec);
						
						if (d1 < d0 || d0 == 0.0D) {
							entity = entity1;
							d0 = d1;
						}
					}
				}
			}
			
			if (entity != null) {
				movingobjectposition = new MovingObjectPosition(entity);
			}
			
			if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
				EntityPlayer entityplayer = (EntityPlayer) movingobjectposition.entityHit;
				
				if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer) this.shootingEntity).canAttackPlayer(entityplayer)) {
					movingobjectposition = null;
				}
			}
			
			float f2;
			float f4;
			
			if (movingobjectposition != null) {
				if (movingobjectposition.entityHit != null) {
					f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					int k = MathHelper.ceiling_double_int((double) f2 * this.damage);
					
					if (this.getIsCritical()) {
						k += this.rand.nextInt(k / 2 + 2);
					}
					
					DamageSource damagesource;
					
					if (this.shootingEntity == null) {
						damagesource = DamageSource.causeArrowDamage(this, this);
					} else {
						damagesource = DamageSource.causeArrowDamage(this, this.shootingEntity);
					}
					
					if (this.isBurning() && !(movingobjectposition.entityHit instanceof EntityEnderman)) {
						movingobjectposition.entityHit.setFire(5);
					}
					
					if (movingobjectposition.entityHit.attackEntityFrom(damagesource, (float) k)) {
						if (movingobjectposition.entityHit instanceof EntityLivingBase) {
							EntityLivingBase entitylivingbase = (EntityLivingBase) movingobjectposition.entityHit;
							
							if (!this.worldObj.isRemote) {
								entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
							}
							
							if (this.knockbackStrength > 0) {
								f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
								
								if (f4 > 0.0F) {
									movingobjectposition.entityHit.addVelocity(this.motionX * (double) this.knockbackStrength * 0.6000000238418579D / (double) f4, 0.1D, this.motionZ * (double) this.knockbackStrength * 0.6000000238418579D / (double) f4);
								}
							}
							
							if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase) {
								EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
								EnchantmentHelper.func_151385_b((EntityLivingBase) this.shootingEntity, entitylivingbase);
							}
							
							if (this.shootingEntity != null && movingobjectposition.entityHit != this.shootingEntity && movingobjectposition.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
								((EntityPlayerMP) this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
							}
						}
						
						this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
						
						if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
							this.setDead();
						}
					} else {
						this.motionX *= -0.10000000149011612D;
						this.motionY *= -0.10000000149011612D;
						this.motionZ *= -0.10000000149011612D;
						this.rotationYaw += 180.0F;
						this.prevRotationYaw += 180.0F;
						this.ticksInAir = 0;
					}
				} else {
					this.field_145791_d = movingobjectposition.blockX;
					this.field_145792_e = movingobjectposition.blockY;
					this.field_145789_f = movingobjectposition.blockZ;
					this.stuckBlock = block;
					this.inData = this.worldObj.getBlockMetadata(this.field_145791_d, this.field_145792_e, this.field_145789_f);
					this.motionX = (double) ((float) (movingobjectposition.hitVec.xCoord - this.posX));
					this.motionY = (double) ((float) (movingobjectposition.hitVec.yCoord - this.posY));
					this.motionZ = (double) ((float) (movingobjectposition.hitVec.zCoord - this.posZ));
					f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
					this.posX -= this.motionX / (double) f2 * 0.05000000074505806D;
					this.posY -= this.motionY / (double) f2 * 0.05000000074505806D;
					this.posZ -= this.motionZ / (double) f2 * 0.05000000074505806D;
					this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
					this.inGround = true;
					this.arrowShake = 7;
					this.setIsCritical(false);
					
					if (this.stuckBlock.getMaterial() != Material.air) {
						this.stuckBlock.onEntityCollidedWithBlock(this.worldObj, this.field_145791_d, this.field_145792_e, this.field_145789_f, this);
					}
				}
			}
			
			if (this.getIsCritical()) {
				for (i = 0; i < 4; ++i) {
					this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double) i / 4.0D, this.posY + this.motionY * (double) i / 4.0D, this.posZ + this.motionZ * (double) i / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
				}
			}
			
			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
			
			for (this.rotationPitch = (float) (Math.atan2(this.motionY, (double) f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
				;
			}
			
			while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
				this.prevRotationPitch += 360.0F;
			}
			
			while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
				this.prevRotationYaw -= 360.0F;
			}
			
			while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
				this.prevRotationYaw += 360.0F;
			}
			
			this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
			this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
			float f3 = 0.99F;
			f1 = 0.05F;
			
			if (this.isInWater()) {
				for (int l = 0; l < 4; ++l) {
					f4 = 0.25F;
					this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double) f4, this.posY - this.motionY * (double) f4, this.posZ - this.motionZ * (double) f4, this.motionX, this.motionY, this.motionZ);
				}
				
				f3 = 0.8F;
			}
			
			if (this.isWet()) {
				this.extinguish();
			}
			
			this.motionX *= (double) f3;
			this.motionY *= (double) f3;
			this.motionZ *= (double) f3;
			this.motionY -= (double) f1;
			this.setPosition(this.posX, this.posY, this.posZ);
			this.func_145775_I();
		}
	}
	
	/** (abstract) Protected helper method to write subclass entity data to NBT. */
	public void writeEntityToNBT(NBTTagCompound data) {
		data.setShort("xTile", (short) this.field_145791_d);
		data.setShort("yTile", (short) this.field_145792_e);
		data.setShort("zTile", (short) this.field_145789_f);
		data.setShort("life", (short) this.ticksInGround);
		data.setByte("inTile", (byte) Block.getIdFromBlock(this.stuckBlock));
		data.setByte("inData", (byte) this.inData);
		data.setByte("shake", (byte) this.arrowShake);
		data.setByte("inGround", (byte) (this.inGround ? 1 : 0));
		data.setByte("pickup", (byte) this.canBePickedUp);
		data.setDouble("damage", this.damage);
	}
	
	/** (abstract) Protected helper method to read subclass entity data from NBT. */
	public void readEntityFromNBT(NBTTagCompound data) {
		this.field_145791_d = data.getShort("xTile");
		this.field_145792_e = data.getShort("yTile");
		this.field_145789_f = data.getShort("zTile");
		this.ticksInGround = data.getShort("life");
		this.stuckBlock = Block.getBlockById(data.getByte("inTile") & 255);
		this.inData = data.getByte("inData") & 255;
		this.arrowShake = data.getByte("shake") & 255;
		this.inGround = data.getByte("inGround") == 1;
		
		if (data.hasKey("damage", 99)) {
			this.damage = data.getDouble("damage");
		}
		
		if (data.hasKey("pickup", 99)) {
			this.canBePickedUp = data.getByte("pickup");
		} else if (data.hasKey("player", 99)) {
			this.canBePickedUp = data.getBoolean("player") ? 1 : 0;
		}
	}
	
	/** Called by a player entity when they collide with an entity */
	public void onCollideWithPlayer(EntityPlayer player) {
		if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0) {
			boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;
			
			if (this.canBePickedUp == 1 && !player.inventory.addItemStackToInventory(new ItemStack(ADItems.elfArrow, 1))) {
				flag = false;
			}
			
			if (flag) {
				this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				player.onItemPickup(this, 1);
				this.setDead();
			}
		}
	}
	
	/** Whether the arrow has a stream of critical hit particles flying behind it. */
	public void setIsCritical(boolean isCrit) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		
		if (isCrit) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -2)));
		}
	}
	
	/** Whether the arrow has a stream of critical hit particles flying behind it. */
	public boolean getIsCritical() {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		return (b0 & 1) != 0;
	}
}
