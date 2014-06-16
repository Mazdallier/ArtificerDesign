package ad.Genis231.Items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import ad.Genis231.Resources.ADTool;

import com.google.common.collect.Sets;

public class Pickaxe extends ADTool {
	private static final Set<Block> set = Sets.newHashSet(new Block[] { Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail });
	
	public Pickaxe(String name, String texture, CreativeTabs tab) {
		super(name, texture, 1.0F, Item.ToolMaterial.EMERALD, set);
		this.setCreativeTab(tab);
		this.setMaxDamage(500);
	}
}
