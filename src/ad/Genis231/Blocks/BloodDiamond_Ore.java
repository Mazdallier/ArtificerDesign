package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import ad.Genis231.Items.items;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;

public class BloodDiamond_Ore extends Block {
	protected BloodDiamond_Ore(int id) {
		super(id, Material.rock);
		setUnlocalizedName("BDOre");
		setLightValue(1.0F);
		setHardness(10.0f);
		setTextureName(textures.BDO);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return items.DBdirty.itemID;
	}
	
	protected boolean canSilkHarvest() {
		return true;
	}
	
	public boolean isGenMineableReplaceable(World world, int x, int y, int z, int target) {
		return blockID == target;
	}
	
	public int quantityDroppedWithBonus(int par1, Random random) {
		int output;
		output = random.nextInt(5);
		
		System.out.println(output);
		if (output != 0) {
			return output;
		} else {
			return 1;
		}
	}
}
