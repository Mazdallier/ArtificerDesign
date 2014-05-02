package ad.Genis231.Items.Drill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.Resources.ADItem;
import ad.Genis231.TileEntity.DrillTile;

public class DrillPart extends ADItem {
	
	public DrillPart(String name, int damage) {
		super(name);
		this.setMaxDamage(damage);
	}
	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
		if (world.getTileEntity(x, y, z) instanceof DrillTile) {
			DrillTile tile = (DrillTile) world.getTileEntity(x, y, z);
			tile.setDrill(new ItemStack(this, 1, this.getMaxDamage()));
		}
		
		return true;
	}
}
