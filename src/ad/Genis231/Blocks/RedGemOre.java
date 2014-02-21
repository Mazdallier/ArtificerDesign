package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.lib.textures;

public class RedGemOre extends ADBlock {
	public RedGemOre(String name) {
		super(Material.rock, name);
		this.setLightLevel(1.0F);
		setHardness(5.0f);
		setBlockTextureName(textures.RedGemOre);
	}
	
	//TODO add Gem to Drop!!!!
	
	
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
