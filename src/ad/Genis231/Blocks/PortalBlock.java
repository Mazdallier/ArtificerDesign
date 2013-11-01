package ad.Genis231.Blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PortalBlock extends BlockPortal {
	public PortalBlock(int id) {
		super(id);
		this.setTickRandomly(true);
	}
	
	/** Ticks the block if it's been scheduled */
	public void updateTick(World world, int x, int y, int z, Random random) {
		super.updateTick(world, x, y, z, random);
		
		if (world.provider.isSurfaceWorld() && random.nextInt(2000) < world.difficultySetting) {
			int l;
			
			for (l = y; !world.doesBlockHaveSolidTopSurface(x, l, z) && l > 0; --l) {
				;
			}
			
			if (l > 0 && !world.isBlockNormalCube(x, l + 1, z)) {
				Entity entity = ItemMonsterPlacer.spawnCreature(world, 57, (double) x + 0.5D, (double) l + 1.1D, (double) z + 0.5D);
				
				if (entity != null) {
					entity.timeUntilPortal = entity.getPortalCooldown();
				}
			}
		}
	}
	
	/** Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has beencleared to be reused) */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
	
	/** Updates the blocks bounds based on its current state. Args: world, x, y, z */
	public void setBlockBoundsBasedOnState(IBlockAccess ThisBlock, int x, int y, int z) {
		float f;
		float f1;
		
		if (ThisBlock.getBlockId(x - 1, y, z) != this.blockID && ThisBlock.getBlockId(x + 1, y, z) != this.blockID) {
			f = 0.125F;
			f1 = 0.5F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		} else {
			f = 0.5F;
			f1 = 0.125F;
			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
		}
	}
	
	/** Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared face of two adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block. */
	public boolean isOpaqueCube() {
		return false;
	}
	
	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	/** Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z */
	public boolean tryToCreatePortal(World world, int x, int y, int z) {
		byte b0 = 0;
		byte b1 = 0;
		
		if (world.getBlockId(x - 1, y, z) == Block.glass.blockID || world.getBlockId(x + 1, y, z) == Block.glass.blockID) {
			b0 = 1;
		}
		
		if (world.getBlockId(x, y, z - 1) == Block.glass.blockID || world.getBlockId(x, y, z + 1) == Block.glass.blockID) {
			b1 = 1;
		}
		
		if (b0 == b1) {
			return false;
		} else {
			if (world.isAirBlock(x - b0, y, z - b1)) {
				x -= b0;
				z -= b1;
			}
			
			int l;
			int i1;
			
			for (l = -1; l <= 2; ++l) {
				for (i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
						int j1 = world.getBlockId(x + b0 * l, y + i1, z + b1 * l);
						boolean isAirBlock = world.isAirBlock(x + b0 * l, y + i1, z + b1 * l);
						
						if (flag) {
							if (j1 != Block.glass.blockID) { return false; }
						}
						else if (!isAirBlock && j1 != Block.fire.blockID) { return false; }
					}
				}
			}
			
			for (l = 0; l < 2; ++l) {
				for (i1 = 0; i1 < 3; ++i1) {
					world.setBlock(x + b0 * l, y + i1, z + b1 * l, Block.portal.blockID, 0, 2);
				}
			}
			
			return true;
		}
	}
	
	/** Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are their own) Args: x, y, z, neighbor blockID */
	public void onNeighborBlockChange(World world, int x, int y, int z, int NBlock) {
		byte b0 = 0;
		byte b1 = 1;
		
		if (world.getBlockId(x - 1, y, z) == this.blockID || world.getBlockId(x + 1, y, z) == this.blockID) {
			b0 = 1;
			b1 = 0;
		}
		
		int i1;
		
		for (i1 = y; world.getBlockId(x, i1 - 1, z) == this.blockID; --i1) {
			;
		}
		
		if (world.getBlockId(x, i1 - 1, z) != Block.glass.blockID) {
			world.setBlockToAir(x, y, z);
		} else {
			int j1;
			
			for (j1 = 1; j1 < 4 && world.getBlockId(x, i1 + j1, z) == this.blockID; ++j1) {
				;
			}
			
			if (j1 == 3 && world.getBlockId(x, i1 + j1, z) == Block.glass.blockID) {
				boolean flag = world.getBlockId(x - 1, y, z) == this.blockID || world.getBlockId(x + 1, y, z) == this.blockID;
				boolean flag1 = world.getBlockId(x, y, z - 1) == this.blockID || world.getBlockId(x, y, z + 1) == this.blockID;
				
				if (flag && flag1) {
					world.setBlockToAir(x, y, z);
				} else {
					if ((world.getBlockId(x + b0, y, z + b1) != Block.glass.blockID || world.getBlockId(x - b0, y, z - b1) != this.blockID) && (world.getBlockId(x - b0, y, z - b1) != Block.glass.blockID || world.getBlockId(x + b0, y, z + b1) != this.blockID)) {
						world.setBlockToAir(x, y, z);
					}
				}
			} else {
				world.setBlockToAir(x, y, z);
			}
		}
	}
	
	/** Returns true if the given side of this block type should be rendered, if the adjacent block is at the given coordinates. Args: blockAccess, x, y, z, side */
	@SideOnly(Side.CLIENT) public boolean shouldSideBeRendered(IBlockAccess thisBlock, int x, int y, int z, int side) {
		if (thisBlock.getBlockId(x, y, z) == this.blockID) {
			return false;
		} else {
			boolean flag = thisBlock.getBlockId(x - 1, y, z) == this.blockID && thisBlock.getBlockId(x - 2, y, z) != this.blockID;
			boolean flag1 = thisBlock.getBlockId(x + 1, y, z) == this.blockID && thisBlock.getBlockId(x + 2, y, z) != this.blockID;
			boolean flag2 = thisBlock.getBlockId(x, y, z - 1) == this.blockID && thisBlock.getBlockId(x, y, z - 2) != this.blockID;
			boolean flag3 = thisBlock.getBlockId(x, y, z + 1) == this.blockID && thisBlock.getBlockId(x, y, z + 2) != this.blockID;
			boolean flag4 = flag || flag1;
			boolean flag5 = flag2 || flag3;
			return flag4 && side == 4 ? true : (flag4 && side == 5 ? true : (flag5 && side == 2 ? true : flag5 && side == 3));
		}
	}
	
	/** Returns the quantity of items to drop on block destruction */
	public int quantityDropped(Random par1Random) {
		return 0;
	}
	
	/** Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity */
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity.ridingEntity == null && entity.riddenByEntity == null) {
			if (entity instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP) entity;
				if (entity.dimension != Ref.PortalNumber) {
					player.mcServer.getConfigurationManager().transferPlayerToDimension(player, Ref.PortalNumber, new Teleporter(player.mcServer.worldServerForDimension(Ref.PortalNumber)));
				} else {
					//player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 1, new Teleporter(player.mcServer.worldServerForDimension(1)));
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)/**Returns which pass should this block be rendered on. 0 for solids and 1 for alpha*/
	public int getRenderBlockPass() {
		return 1;
	}
	
	@SideOnly(Side.CLIENT)/**A randomly called display update to be able to add particles or other items for display*/
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (random.nextInt(100) == 0) {
			world.playSound((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "portal.portal", 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
		}
		
		for (int l = 0; l < 4; ++l) {
			double d0 = (double) ((float) x + random.nextFloat());
			double d1 = (double) ((float) y + random.nextFloat());
			double d2 = (double) ((float) z + random.nextFloat());
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			int i1 = random.nextInt(2) * 2 - 1;
			d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			
			if (world.getBlockId(x - 1, y, z) != this.blockID && world.getBlockId(x + 1, y, z) != this.blockID) {
				d0 = (double) x + 0.5D + 0.25D * (double) i1;
				d3 = (double) (random.nextFloat() * 2.0F * (float) i1);
			} else {
				d2 = (double) z + 0.5D + 0.25D * (double) i1;
				d5 = (double) (random.nextFloat() * 2.0F * (float) i1);
			}
			world.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
		}
	}
	
	@SideOnly(Side.CLIENT)/**only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)*/
	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}
}