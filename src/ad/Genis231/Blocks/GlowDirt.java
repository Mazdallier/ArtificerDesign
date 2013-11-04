package ad.Genis231.Blocks;

import java.util.Random;

import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class GlowDirt extends Block {

	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;
	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon botIcon;

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

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		this.setLightValue(1.0F);
		world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));

		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY,
				hitZ);
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.getBlockLightValue(x, y, z) != 0) {
			this.setLightValue((float) (world.getBlockLightValue(x, y, z) - 1));
			world.scheduleBlockUpdate(x, y, z, blockID, this.tickRate(world));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		sideIcon = icon.registerIcon(Ref.Resource_FOLDER + "GDirt_side");
		topIcon = icon.registerIcon(Ref.Resource_FOLDER + "GDirt_top");
		botIcon = icon.registerIcon(Ref.Resource_FOLDER + "GDirt_bot");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		switch (side) {
		case 0:
			return botIcon;
		case 1:
			return topIcon;
		default:
			return sideIcon;
		}
	}
}
