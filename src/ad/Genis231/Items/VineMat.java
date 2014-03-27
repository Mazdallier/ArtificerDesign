package ad.Genis231.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ad.Genis231.BaseClass.ADBlock;
import ad.Genis231.BaseClass.ADItem;
import ad.Genis231.Blocks.PitTrapBlock;
import ad.Genis231.lib.ADBlocks;
import ad.Genis231.lib.ItemTexture;
import ad.Genis231.lib.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VineMat extends ADItem {
	public static IIcon[] IconArray = new IIcon[9];
	public static final int[] tiers = { 8, 16, 32 };
	
	public VineMat(String name) {
		super(name);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		int range = this.getRange(item);
		list.add("Size of trap: "+ range+"x"+range);
	}
	
	/** item ~~ player ~~ world ~~ x ~~ y ~~ z ~~ side ~~ south = 2 ~~ north = 3 ~~ east = 4 ~~ west = 5 */
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
		if (!world.isRemote) {
			switch (ForgeDirection.getOrientation(side)) {
				case NORTH:
					init(world, x, y, z - 1, item);
					break;
				case SOUTH:
					init(world, x, y, z + 1, item);
					break;
				case WEST:
					init(world, x - 1, y, z, item);
					break;
				case EAST:
					init(world, x + 1, y, z, item);
					break;
				default:
					break;
			}
		}
		return true;
	}
	
	private void init(World world, int x, int y, int z, ItemStack item) {
		int mx = x, mX = x, mz = z, mZ = z;
		
		for (int i = 0; i <= getRange(item); i++) {
			mx = world.isAirBlock(mx - 1, y, z) ? x - i : mx;
			mX = world.isAirBlock(mX + 1, y, z) ? x + i : mX;
			
			mz = world.isAirBlock(x, y, mz - 1) ? z - i : mz;
			mZ = world.isAirBlock(x, y, mZ + 1) ? z + i : mZ;
			
		}
		
		if (Math.abs(mX - mx) <= getRange(item) && Math.abs(mZ - mz) <= getRange(item))
			set(world, mx, mX, y, mz, mZ, item);
	}
	
	private void set(World world, int fx, int fX, int y, int fz, int fZ, ItemStack item) {
		int mx, mX, mz, mZ;
		
		mx = fx <= fX ? fx : fX;
		mX = fx <= fX ? fX : fx;
		
		mz = fz <= fZ ? fz : fZ;
		mZ = fz <= fZ ? fZ : fz;
		
		if (border(world, mx, mX, y, mz, mZ)) {
			if (area(world, mx, mX, y, mz, mZ)) {
				
				PitTrapBlock.toggle = false;
				ADBlock.fill(world, mx, y, mz, mX, y, mZ, ADBlocks.FalsePitTrap, item.getItemDamage() % 3, true);
				PitTrapBlock.toggle = true;
			}
		}
	}
	
	private boolean area(World world, int mx, int mX, int y, int mz, int mZ) {
		for (int x = mx; x <= mX; x++) {
			for (int z = mz; z <= mZ; z++) {
				if (!ADBlock.blockIsSide(world, x, y, z, Blocks.air, 0) || !ADBlock.blockIsSide(world, x, y, z, Blocks.air, 1))
					return false;
			}
		}
		return true;
	}
	
	private boolean border(World world, int mx, int mX, int y, int mz, int mZ) {
		for (int x = mx; x < mX; x++) {
			if (ADBlock.blockIsSide(world, x, y, mz, Blocks.air, 2) || ADBlock.blockIsSide(world, x, y, mZ, Blocks.air, 3))
				return false;
		}
		
		for (int z = mz; z < mZ; z++) {
			if (ADBlock.blockIsSide(world, mx, y, z, Blocks.air, 4) || ADBlock.blockIsSide(world, mX, y, z, Blocks.air, 5))
				return false;
		}
		
		return true;
	}
	
	int getRange(ItemStack item) {
		if (item.getItemDamage() < 3)
			return tiers[0];
		else if (item.getItemDamage() < 6)
			return tiers[1];
		else
			return tiers[2];
	}
	
	@SideOnly(Side.CLIENT) public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 9; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override public int getMetadata(int meta) {
		return meta;
	}
	
	@Override public String getUnlocalizedName(ItemStack itemstack) {
		return this.getUnlocalizedName() + Names.VineMat[itemstack.getItemDamage()];
	}
	
	@Override @SideOnly(Side.CLIENT) public void registerIcons(IIconRegister icon) {
		for (int i = 0; i < IconArray.length; i++)
			IconArray[i] = icon.registerIcon("artificer:Pit_Trap/" + ItemTexture.PitTrap[i]);
	}
	
	/** Gets an icon index based on an item's damage value */
	@SideOnly(Side.CLIENT) public IIcon getIconFromDamage(int meta) {
		return IconArray[meta];
	}
}
