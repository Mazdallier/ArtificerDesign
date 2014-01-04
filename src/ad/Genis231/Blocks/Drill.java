package ad.Genis231.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ad.Genis231.Blocks.drill.DrillThread;
import ad.Genis231.lib.ADLog;
import ad.Genis231.lib.textures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Drill extends Block {
	
	Thread DrillThread;
	
	@SideOnly(Side.CLIENT)
	public static Icon oddSideIcon;
	@SideOnly(Side.CLIENT)
	public static Icon evenSideIcon;
	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon botIcon;
	
	public Drill(int id) {
		super(id, Material.rock);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighbor) {
		if (world.isBlockIndirectlyGettingPowered(x, y, z) && !world.isRemote) {
			DrillThread = new Thread(new DrillThread(world, x, y, z));
			DrillThread.start();
		}
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
