package ad.Genis231.Blocks.ItemBlocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class LiquidAle extends ItemBlock {
	
	public LiquidAle(Block block) {
		super(block);
	}
	@Override @SideOnly(Side.CLIENT) public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool) {
		list.add(":3 dont drink too much!!");
	}
}