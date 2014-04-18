package ad.Genis231.Items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import ad.Genis231.Resources.ADTool;

import com.google.common.collect.Sets;

public class Shovel extends ADTool {
	private static final Set<Block> set = Sets.newHashSet(new Block[] { Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium });
	
	public Shovel(String name, String texture, CreativeTabs tab) {
		super(name, texture, 1.0F, Item.ToolMaterial.EMERALD, set);
		this.setCreativeTab(tab);
		this.setMaxDamage(5);
	}
}
