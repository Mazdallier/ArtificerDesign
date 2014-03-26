package ad.Genis231.lib.ItemBlocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BearTrap extends ItemBlock{

	public BearTrap(Block block) {
		super(block);
	}
	
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add("Still needs animations");
		list.add("Need to finish the model for it");
		list.add("Needs a new texture");
	}
}
