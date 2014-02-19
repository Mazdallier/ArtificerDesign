package ad.Genis231.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.Blocks.PitTrapBlock;
import ad.Genis231.lib.textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PitTrap extends ADItem {
	
	public PitTrap(int id, String name) {
		super(id, name);
		this.setHasSubtypes(true);
	}
	
	public static Icon[] IconArray = new Icon[9];
	public static final String[] UnlocalizedArray = { "Dirt Teir 1", "Sand Teir 1", "Stone Teir 1", "Dirt Teir 2", "Sand Teir 2", "Stone Teir 2", "Dirt Teir 3", "Sand Teir 3", "Stone Teir 3" };
	public static final int[] tiers = { 8, 16, 32 };
	
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
			mx = world.getBlockId(mx - 1, y, z) == 0 ? x - i : mx;
			mX = world.getBlockId(mX + 1, y, z) == 0 ? x + i : mX;
			
			mz = world.getBlockId(x, y, mz - 1) == 0 ? z - i : mz;
			mZ = world.getBlockId(x, y, mZ + 1) == 0 ? z + i : mZ;
			
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
				System.out.println("EVERYTHING WORKS!!!");
				
				PitTrapBlock.toggle = false;
				ADBlock.fill(world, mx, y, mz, mX, y, mZ, ADBlock.FalsePitTrap.blockID, item.getItemDamage() % 3, true);
				PitTrapBlock.toggle = true;
			}
		}
	}
	
	private boolean area(World world, int mx, int mX, int y, int mz, int mZ) {
		for (int x = mx; x <= mX; x++) {
			for (int z = mz; z <= mZ; z++) {
				if (!ADBlock.blockIsSide(world, x, y, z, 0, 0) || !ADBlock.blockIsSide(world, x, y, z, 0, 1))
					return false;
			}
		}
		return true;
	}
	
	private boolean border(World world, int mx, int mX, int y, int mz, int mZ) {
		for (int x = mx; x < mX; x++) {
			if (ADBlock.blockIsSide(world, x, y, mz, 0, 2) || ADBlock.blockIsSide(world, x, y, mZ, 0, 3))
				return false;
		}
		
		for (int z = mz; z < mZ; z++) {
			if (ADBlock.blockIsSide(world, mx, y, z, 0, 4) || ADBlock.blockIsSide(world, mX, y, z, 0, 5))
				return false;
		}
		
		return true;
	}
	
	public void getSubItems(int ID, CreativeTabs CreativeTabs, List ItemList) {
		for (int i = 0; i < 9; i++) {
			ItemList.add(new ItemStack(ID, 1, i));
		}
	}
	
	int getRange(ItemStack item) {
		if (item.getItemDamage() < 3)
			return tiers[0];
		else if (item.getItemDamage() < 6)
			return tiers[1];
		else
			return tiers[2];
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return this.getUnlocalizedName() + UnlocalizedArray[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		for (int i = 0; i < IconArray.length; i++)
			IconArray[i] = icon.registerIcon("artificer:Pit_Trap/" + textures.PitTrapArray[i]);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int meta) {
		return IconArray[meta];
	}
}
