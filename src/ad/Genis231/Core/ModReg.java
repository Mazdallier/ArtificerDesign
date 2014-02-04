package ad.Genis231.Core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.Items.ADItem;
import ad.Genis231.Items.pit_trap;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModReg {
	
	public static void basic() {
		/* Blocks */
		Registery.Register(ADBlock.BDiamond_ore, "BDOre", "Dirty Blood Gem Ore");
		Registery.Register(ADBlock.FPTrap, "null_Block");
		Registery.Register(ADBlock.Dam, "dam_block", "Dam");
		Registery.Register(ADBlock.FalseLoot, "FalseLoot", "False Loot");
		Registery.Register(ADBlock.ItableT1, "Itable1", "Imbueing Table teir1");
		Registery.Register(ADBlock.ItableT2, "Itable2", "Imbueing Table teir2");
		Registery.Register(ADBlock.Spike, "SpikePit", "Spike Pit");
		Registery.Register(ADBlock.BTrap, "BTrap", "Bear Trap");
		Registery.Register(ADBlock.Drill, "Drill", "Drill (WIP)");
		Registery.Register(ADBlock.DwarvenStone, "DStone", "Dwarven Stone");
		
		/* Items */
		Registery.Register(ADItem.ODust, "ORangeDust", "Orange Dust");
		Registery.Register(ADItem.GBowl, "GoldBowl", "Gold Bowl");
		Registery.Register(ADItem.ABlood, "AngelicBlood", "Blessed Elve's Blood");
		Registery.Register(ADItem.DBlood, "DemonicBlood", "Tainted Orc's Blood");
		
		Registery.RegisterMulti(ADItem.PTrap, "VineMat", pit_trap.UnlocalizedArray);
	}
	
	public static void recipeGReg() {
		// Blocks
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Dam), "QWQ", "ASA", "QDQ", 'Q', Block.stone, 'W', Block.trapdoor, 'A', ADItem.ABlood, 'S', Item.bucketWater, 'D', Item.redstone);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Drill), "XXX", "BDB", "IBI", 'X', Block.stone, 'B', ADItem.ABlood, 'D', Item.diamond, 'I', Item.ingotIron);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.BTrap), "TIT", "SSS", 'T', ADBlock.Spike, 'I', ADItem.ABlood, 'S', Item.ingotIron);
		
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.ItableT1), "QWE", "RTR", "UIU", 'Q', ADItem.ABlood, 'W', Item.bowlEmpty, 'E', ADItem.DBlood, 'R', Block.enchantmentTable, 'T', Block.blockDiamond, 'U', ADItem.ABlood, 'I', ADItem.DBlood);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.ItableT2), "QWE", "RTR", "UIU", 'Q', ADItem.ABlood, 'W', ADItem.GBowl, 'E', ADItem.DBlood, 'R', ADBlock.ItableT1, 'T', Block.blockDiamond, 'U', ADItem.ABlood, 'I', ADItem.DBlood);
		
		// Items
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.GBowl), "X X", " X ", 'X', Item.ingotGold);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Spike), " X ", "X X", 'X', Block.cobblestone);
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.ABlood), "XXX", "XQX", "XXX", 'X', ADItem.ABlood, 'Q', ADItem.DBlood);
		
		// Shapeless
		GameRegistry.addShapelessRecipe(new ItemStack(ADItem.ODust), Item.glowstone, Item.redstone, Item.redstone);
		
		// Pit-Trap
		{
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PTrap, 1, 0), "QQQ", " X ", "X X", 'Q', Block.dirt, 'X', Item.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PTrap, 1, 1), "QQQ", " X ", "X X", 'Q', Block.sand, 'X', Item.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PTrap, 1, 2), "QQQ", " X ", "X X", 'Q', Block.stone, 'X', Item.stick);
			
			for (int i = 3; i < 10; i++) {
				GameRegistry.addShapedRecipe(new ItemStack(ADItem.PTrap, 1, i), "QQQ", " X ", "X X", 'Q', new ItemStack(ADItem.PTrap, 1, i - 3), 'X', Item.stick);
			}
		}
	}
	
	public static void Worlds() {
		GameRegistry.registerWorldGenerator(new BDiaGen());
	}
	
	public static void Modifiers() {
		MinecraftForge.setBlockHarvestLevel(ADBlock.BDiamond_ore, "pickaxe", 2);
	}
}
