package ad.Genis231.Blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import ad.Genis231.lib.textures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BPP extends Block {
	/** The mob type that can trigger this pressure plate. */
	private EnumMobType MobTrigger;
	
	private float min = 0.0625F;
	private float max = 0.9375F;
	
	public BPP(int ID, EnumMobType mob) {
		super(ID, Material.wood);
		
		this.setTickRandomly(true);
		this.Pressed(this.getMetaFromWeight(15));
		this.MobTrigger = mob;
	}
	
	/**
	 * Sets the block's bounds for rendering it as an item
	 */
	public void setBlockBoundsForItemRender() {
		float f = 0.5F;
		float f1 = 0.125F;
		float f2 = 0.5F;
		this.setBlockBounds(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
	}
	
	/** Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the mask.) Parameters: World, X, Y, Z, mask, list, colliding entity */
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity entity) {
		boolean North = this.canConnect(world, x, y, z - 1);
		boolean South = this.canConnect(world, x, y, z + 1);
		boolean East = this.canConnect(world, x - 1, y, z);
		boolean West = this.canConnect(world, x + 1, y, z);
		
		float minX = min;
		float maxX = max;
		float minZ = min;
		float maxZ = max;
		
		if (North) minZ = 0.0F;
		
		if (South) maxZ = 1.0F;
		
		if (North || South) {
			this.setBlockBounds(minX, 0.0F, minZ, maxX, min, maxZ);
			super.addCollisionBoxesToList(world, x, y, z, par5AxisAlignedBB, par6List, entity);
		}
		
		minZ = min;
		maxZ = max;
		
		if (East) minX = min;
		
		if (West) maxX = 1.0F - min;
		
		if (East || West || !North && !South) {
			this.setBlockBounds(minX, 0.0F, minZ, maxX, min, maxZ);
			super.addCollisionBoxesToList(world, x, y, z, par5AxisAlignedBB, par6List, entity);
		}
		
		if (North) minZ = 0.0F;
		
		if (South) maxZ = 1.0F;
		
		this.setBlockBounds(minX, 0.0F, minZ, maxX, min, maxZ);
	}
	
	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		boolean North = this.canConnect(block, x, y, z - 1);
		boolean South = this.canConnect(block, x, y, z + 1);
		boolean East = this.canConnect(block, x - 1, y, z);
		boolean West = this.canConnect(block, x + 1, y, z);
		float minX = min;
		float maxX = max;
		float minZ = min;
		float maxZ = max;
		
		if (North) {
			minZ = 0.0F;
		}
		
		if (South) {
			maxZ = 1.0F;
		}
		
		if (East) {
			minX = 0.0F;
		}
		
		if (West) {
			maxX = 1.0F;
		}
		
		this.Pressed(block.getBlockMetadata(x, y, z));
		this.setBlockBounds(minX, 0.0F, minZ, maxX, min, maxZ);
	}
	
	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared face of two adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	/**
	 * Returns true if the specified block can be connected by a fence
	 */
	public boolean canConnect(IBlockAccess plate, int x, int y, int z) {
		int blockID = plate.getBlockId(x, y, z);
		
		if (blockID != this.blockID && blockID != Block.fenceGate.blockID) {
			Block block = Block.blocksList[blockID];
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		} else {
			return true;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon(textures.CPP);
	}
	
	// Pressure Plate STUFF
	
	protected void Pressed(int meta) {
		boolean flag = this.getPowerSupply(meta) > 0;
		float f = 0.0625F;
		
		if (flag) {
			this.setBlockBounds(f, 0.0F, f, 1.0F - f, 0.03125F, 1.0F - f);
		} else {
			this.setBlockBounds(f, 0.0F, f, 1.0F - f, 0.0625F, 1.0F - f);
		}
	}
	
	/** How many world ticks before ticking */
	public int tickRate(World par1World) {
		return 10;
	}
	
	/** Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been cleared to be reused) */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}
	
	/** Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z */
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.doesBlockHaveSolidTopSurface(x, y - 1, z) || BlockFence.isIdAFence(world.getBlockId(x, y - 1, z));
	}
	
	/** Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are their own) Args: x, y, z, neighbor blockID */
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockChange) {
		
		if (!world.doesBlockHaveSolidTopSurface(x, y - 1, z) && !BlockFence.isIdAFence(world.getBlockId(x, y - 1, z))) {
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
		}
	}
	
	/** Ticks the block if it's been scheduled */
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (!world.isRemote) {
			int l = this.getPowerSupply(world.getBlockMetadata(x, y, z));
			
			if (l > 0) {
				this.TogglesPlateStatus(world, x, y, z, l);
			}
		}
	}
	
	/** Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity */
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (!world.isRemote) {
			int meta = this.getPowerSupply(world.getBlockMetadata(x, y, z));
			
			if (meta == 0) {
				this.TogglesPlateStatus(world, x, y, z, meta);
			}
		}
	}
	
	/** Checks if there are mobs on the plate. If a mob is on the plate and it is off, it turns it on, and vice versa. */
	protected void TogglesPlateStatus(World world, int x, int y, int z, int meta) {
		int i1 = this.getPlateState(world, x, y, z);
		boolean flag = meta > 0;
		boolean flag1 = i1 > 0;
		
		if (meta != i1) {
			world.setBlockMetadataWithNotify(x, y, z, this.getMetaFromWeight(i1), 2);
			this.updateBlocks(world, x, y, z);
			world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
		}
		
		if (!flag1 && flag) {
			world.playSoundEffect((double) x + 0.5D, (double) y + 0.1D, (double) z + 0.5D, "random.click", 0.3F, 0.5F);
		} else if (flag1 && !flag) {
			world.playSoundEffect((double) x + 0.5D, (double) y + 0.1D, (double) z + 0.5D, "random.click", 0.3F, 0.6F);
		}
		
		if (flag1) {
			world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
		}
	}
	
	protected AxisAlignedBB getSensitiveAABB(int x, int y, int z) {
		float f = 0.125F;
		return AxisAlignedBB.getAABBPool().getAABB((double) ((float) x + f), (double) y, (double) ((float) z + f), (double) ((float) (x + 1) - f), (double) y + 0.25D, (double) ((float) (z + 1) - f));
	}
	
	/** Called on server worlds only when the block has been replaced by a different block ID, or the same block with a different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old metadata */
	public void breakBlock(World world, int x, int y, int z, int oldID, int oldMeta) {
		if (this.getPowerSupply(oldMeta) > 0) {
			this.updateBlocks(world, x, y, z);
		}
		
		super.breakBlock(world, x, y, z, oldID, oldMeta);
	}
	
	protected void updateBlocks(World world, int x, int y, int z) {
		world.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
		world.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
	}
	
	/** Can this block provide power. Only wire currently seems to have this change based on its state. */
	public boolean canProvidePower() {
		return true;
	}
	
	/**
	 * Returns the current state of the pressure plate. Returns a value between 0 and 15 based on the number of items on it.
	 */
	protected int getPlateState(World par1World, int par2, int par3, int par4) {
		List list = null;
		
		list = par1World.getEntitiesWithinAABB(EntityLivingBase.class, this.getSensitiveAABB(par2, par3, par4));
		
		if (list != null && !list.isEmpty()) {
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				Entity entity = (Entity) iterator.next();
				
				if (!entity.doesEntityNotTriggerPressurePlate()) { return 15; }
			}
		}
		
		return 0;
	}
	
	/**
	 * Argument is metadata. Returns power level (0-15)
	 */
	protected int getPowerSupply(int par1) {
		return par1 == 1 ? 15 : 0;
	}
	
	/**
	 * Argument is weight (0-15). Return the metadata to be set because of it.
	 */
	protected int getMetaFromWeight(int par1) {
		return par1 > 0 ? 1 : 0;
	}
	
	/**
	 * Returns true if the block is emitting indirect/weak redstone power on the specified side. If isBlockNormalCube returns true, standard redstone propagation rules will apply instead and this will not be called. Args: World, X, Y, Z, side. Note that the side is reversed - eg it is 1 (up) when checking the bottom of the block.
	 */
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return this.getPowerSupply(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
	}
	
	/**
	 * Returns true if the block is emitting direct/strong redstone power on the specified side. Args: World, X, Y, Z, side. Note that the side is reversed - eg it is 1 (up) when checking the bottom of the block.
	 */
	public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return par5 == 1 ? this.getPowerSupply(par1IBlockAccess.getBlockMetadata(par2, par3, par4)) : 0;
	}
}
