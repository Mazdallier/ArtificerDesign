package ad.Genis231.Blocks;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import ad.Genis231.lib.ADLog;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;

public class FakeFire extends BlockFire {
	boolean Smoke;
	
	public FakeFire(int par1, boolean toggle) {
		super(par1);
		this.disableStats();
		this.setHardness(0.0F);
		this.setLightValue(1.0F);
		this.setStepSound(soundWoodFootstep);
		this.setCreativeTab(Ref.TAB);
		this.setTextureName(textures.Fire);
		Smoke = toggle;
	}
	
	public void initializeBlock() {}
	
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		ADLog.logger.info("CLICKED!!");
	}
	
	public void randomDisplayTick(World world, int x, int y, int z, Random rng) {
		int rate = 24;
		
		if (Smoke) {
			if (rng.nextInt(24) == 0) {
				world.playSound((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), "fire.fire", 1.0F + rng.nextFloat(), rng.nextFloat() * 0.7F + 0.3F, false);
			}
			
			int l;
			float f;
			float f1;
			float f2;
			
			if (!world.doesBlockHaveSolidTopSurface(x, y - 1, z) && !Block.fire.canBlockCatchFire(world, x, y - 1, z, UP)) {
				if (Block.fire.canBlockCatchFire(world, x - 1, y, z, EAST)) {
					for (l = 0; l < rate; ++l) {
						f = (float) x + rng.nextFloat() * 0.1F;
						f1 = (float) y + rng.nextFloat();
						f2 = (float) z + rng.nextFloat();
						world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
					}
				}
				
				if (Block.fire.canBlockCatchFire(world, x + 1, y, z, WEST)) {
					for (l = 0; l < rate; ++l) {
						f = (float) (x + 1) - rng.nextFloat() * 0.1F;
						f1 = (float) y + rng.nextFloat();
						f2 = (float) z + rng.nextFloat();
						world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
					}
				}
				
				if (Block.fire.canBlockCatchFire(world, x, y, z - 1, SOUTH)) {
					for (l = 0; l < rate; ++l) {
						f = (float) x + rng.nextFloat();
						f1 = (float) y + rng.nextFloat();
						f2 = (float) z + rng.nextFloat() * 0.1F;
						world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
					}
				}
				
				if (Block.fire.canBlockCatchFire(world, x, y, z + 1, NORTH)) {
					for (l = 0; l < rate; ++l) {
						f = (float) x + rng.nextFloat();
						f1 = (float) y + rng.nextFloat();
						f2 = (float) (z + 1) - rng.nextFloat() * 0.1F;
						world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
					}
				}
				
				if (Block.fire.canBlockCatchFire(world, x, y + 1, z, DOWN)) {
					for (l = 0; l < rate; ++l) {
						f = (float) x + rng.nextFloat();
						f1 = (float) (y + 1) - rng.nextFloat() * 0.1F;
						f2 = (float) z + rng.nextFloat();
						world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
					}
				}
			} else {
				for (l = 0; l < Math.round(rate * 0.75); ++l) {
					f = (float) x + rng.nextFloat();
					f1 = (float) y + rng.nextFloat() * 0.5F + 0.5F;
					f2 = (float) z + rng.nextFloat();
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
	
}
