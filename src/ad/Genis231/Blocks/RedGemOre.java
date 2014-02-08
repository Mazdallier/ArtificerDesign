package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.lib.textures;

public class RedGemOre extends ADBlock {
	public RedGemOre(int id, String name) {
		super(id, Material.rock, name);
		setLightValue(1.0F);
		setHardness(5.0f);
		setTextureName(textures.RedGemOre);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return ADItem.DemonicBlood.itemID;
	}
	
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
