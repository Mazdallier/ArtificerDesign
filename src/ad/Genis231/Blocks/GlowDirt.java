package ad.Genis231.Blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GlowDirt extends Block {
	
	public GlowDirt(int id) {
		super(id, Material.ground);
		setLightValue(0);
	}
	
	public int tickRate(World par1World) {
		return 1;
	}
	
	public void onEntityWalking(World world, int x, int y, int z, Entity player) {
		this.setLightValue(1.0F);
		world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
		
		super.onEntityWalking(world, x, y, z, player);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		this.setLightValue(1.0F);
		world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
		
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}
	
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.getBlockLightValue(x, y, z) != 0) {
			this.setLightValue((float) (world.getBlockLightValue(x, y, z) - 1));
			world.scheduleBlockUpdate(x, y, z, blockID, this.tickRate(world));
		}
	}
}
