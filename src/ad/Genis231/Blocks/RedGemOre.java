package ad.Genis231.Blocks;

import java.util.Random;

import ad.Genis231.BaseClass.ADBlock;
import ad.Genis231.lib.ADItems;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class RedGemOre extends ADBlock {
	public RedGemOre(String name, String texture) {
		super(Material.rock, name, texture);
		this.setLightLevel(1.0F);
		setHardness(5.0f);
	}
		
	protected boolean canSilkHarvest() {
		return true;
	}
	
	@Override public Item getItemDropped(int one, Random rand, int two) {		
		return ADItems.DirtyGem;
		
	}
	
	public int quantityDroppedWithBonus(int par1, Random random) {
		int output;
		output = random.nextInt(5);
		
		if (output > 0) {
			return output;
		} else {
			return 1;
		}
	}
}
