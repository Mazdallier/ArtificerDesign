package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.Blocks.Thread.DrillThread;
import ad.Genis231.lib.textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Drill extends ADBlock {
	
	Thread DrillThread;
	
	@SideOnly(Side.CLIENT) public static Icon oddSideIcon;
	@SideOnly(Side.CLIENT) public static Icon evenSideIcon;
	@SideOnly(Side.CLIENT) public static Icon topIcon;
	@SideOnly(Side.CLIENT) public static Icon botIcon;
	
	int size = 32;
	
	public Drill(int id, String name) {
		super(id, Material.rock, name);
		this.setTickRandomly(true);
	}
	
	/** How many world ticks before ticking */
	public int tickRate(World world) {
		return 5;
	}
	
	@SuppressWarnings("deprecation")
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighbor) {
		if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
			// ModLoader.getMinecraftInstance().thePlayer.addChatMessage("~This block no longer works!! they created an excess of Threads which is a HUGE stability issue!! to be fixed eventually...");
			// ModLoader.getMinecraftInstance().thePlayer.addChatMessage("~don't ask me why it sends it twice, it SHOULD only be once but i guess it doesn't like me .-.");
			// ModLoader.getMinecraftInstance().thePlayer.addChatMessage("");
			
			DrillThread = new Thread(new DrillThread(world, x, y, z, size));
			DrillThread.start();
			world.tickUpdates(world.isBlockIndirectlyGettingPowered(x, y, z));
		}
	}
	
	/** Ticks the block if it's been scheduled */
	public void updateTick(World world, int x, int y, int z, Random par5Random) {
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		evenSideIcon = icon.registerIcon(textures.DrillArray[0]);
		oddSideIcon = icon.registerIcon(textures.DrillArray[1]);
		topIcon = icon.registerIcon(textures.DrillArray[2]);
		botIcon = icon.registerIcon(textures.DrillArray[3]);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		switch (side) {
			case 0:
				return botIcon;
			case 1:
				return topIcon;
			case 2:
				return evenSideIcon;
			case 3:
				return evenSideIcon;
			case 4:
				return oddSideIcon;
			default:
				return oddSideIcon;
		}
	}
}
