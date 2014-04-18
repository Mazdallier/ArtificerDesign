package ad.Genis231.Items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import ad.Genis231.Resources.ADTool;

public class Axe extends ADTool{
    private static final Set<Block> set = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin});

	public Axe(String name,String texture,CreativeTabs tab){
		super(name, texture, 1.0F, Item.ToolMaterial.EMERALD, set);
		this.setCreativeTab(tab);
		this.setMaxDamage(500);
	}
}
