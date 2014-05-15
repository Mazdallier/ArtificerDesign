package ad.Genis231.Items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.Refrence.Names;
import ad.Genis231.Resources.ADItem;
import ad.Genis231.TileEntity.DrillTile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DrillPart extends ADItem {
	int type;
	int[] damage = { 100, 250, 500, 1000 };
	String[] names = { "Wood_", "Stone_", "Iron_", "Diamond_" };
	
	public DrillPart() {
		super("");
		this.setHasSubtypes(true);
	}
	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
		if (world.getTileEntity(x, y, z) instanceof DrillTile) {
			DrillTile tile = (DrillTile) world.getTileEntity(x, y, z);
			tile.setDrill(item.getItemDamage(), damage[item.getItemDamage()]);
			
			if (!player.capabilities.isCreativeMode) {
				item.stackSize--;
			}
		}
		
		return true;
	}
	
	@SideOnly(Side.CLIENT) public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < damage.length; ++i) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override public String getUnlocalizedName(ItemStack item) {
		return "item." + this.names[item.getItemDamage()] + Names.DRILL;
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("Number of Blocks: " + damage[item.getItemDamage()]);
		list.add("(does " + ((double) damage[item.getItemDamage()]) / 100 + " layers in a 10x10 hole)");
	}
}
