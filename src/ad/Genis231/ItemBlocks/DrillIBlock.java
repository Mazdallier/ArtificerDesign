package ad.Genis231.ItemBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class DrillIBlock extends ItemBlock{

	public DrillIBlock(Block block){
		super(block);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item,EntityPlayer player,List list,boolean bool){
		list.add("100% works just needs restone");
		list.add("needs balanceing");
		list.add("needs a new texture cough* cough*");
	}

}
