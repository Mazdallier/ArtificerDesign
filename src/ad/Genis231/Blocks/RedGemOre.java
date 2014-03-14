package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;

import java.util.Random;

public class RedGemOre extends ADBlock {
	public RedGemOre(String name, String texture) {
		super(Material.rock, name, texture);
		this.setLightLevel(1.0F);
		setHardness(5.0f);
	}
	
	// TODO add Gem to Drop!!!!
	
	protected boolean canSilkHarvest() {
		return true;
	}
	
	public int quantityDroppedWithBonus(int par1, Random random) {
		int output;
		output = random.nextInt(5);
		
		System.out.println(output);
		if (output > 0) {
			return output;
		} else {
			return 1;
		}
	}
}
