package ad.Genis231.Core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.Items.PitTrap;
import cpw.mods.fml.common.registry.GameRegistry;

public class MainReg {
	
	public static void basic() {
		/* Blocks */
		Registery.Register(ADBlock.RedGemOre, "RedGemOre", "Red Gem Ore");
		Registery.Register(ADBlock.FalsePitTrap, "NullBlock");
		Registery.Register(ADBlock.Dam, "DamBlock", "Dam");
		Registery.Register(ADBlock.FalseLoot, "FalseLoot", "False Loot");
		Registery.Register(ADBlock.Itable1, "Itable1", "Imbueing Table (teir 1)");
		Registery.Register(ADBlock.Itable2, "Itable2", "Imbueing Table (teir 2)");
		Registery.Register(ADBlock.Spike, "SpikePit", "Spike Pit");
		Registery.Register(ADBlock.BearTrap, "BearTrap", "Bear Trap");
		Registery.Register(ADBlock.Drill, "Drill", "Drill (Broken)");
		Registery.Register(ADBlock.DwarvenStone, "DwarvenStone", "Dwarven Stone");
		Registery.Register(ADBlock.GreenFire, "GreenFire", "Green Fire of DOOM!!");
		
		/* Items */
		Registery.Register(ADItem.OrangeDust, "OrangeDust", "Orange Dust");
		Registery.Register(ADItem.PureGem, "PureGem", "Purified Gem");
		Registery.Register(ADItem.DirtyGem, "DirtyGem", "Impure Gem");
		Registery.Register(ADItem.GoldBowl, "GoldBowl", "Gold Bowl");
		Registery.Register(ADItem.AngelicBlood, "AngelicBlood", "Blessed Elve's Blood");
		Registery.Register(ADItem.DemonicBlood, "DemonicBlood", "Tainted Orc's Blood");
		
		Registery.Register(ADItem.RestoredJournal, "RestoredJournal", "Restored Journal");
		Registery.Register(ADItem.DragonBreathe, "DragonBreathe", "Dragon's Breathe");
		
		Registery.RegisterMulti(ADItem.PitTrap, "VineMat", PitTrap.UnlocalizedArray);
	}
	
	public static void recipeGReg() {
		// Blocks
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Dam), "QWQ", "ASA", "QDQ", 'Q', Block.stone, 'W', Block.trapdoor, 'A', ADItem.PureGem, 'S', Item.bucketWater, 'D', Item.redstone);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Drill), "XXX", "BDB", "IBI", 'X', Block.stone, 'B', ADItem.PureGem, 'D', Item.diamond, 'I', Item.ingotIron);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.BearTrap), "TIT", "SSS", 'T', ADBlock.Spike, 'I', ADItem.PureGem, 'S', Item.ingotIron);
		
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Itable1), "QWE", "RTR", "UIU", 'Q', ADItem.AngelicBlood, 'W', Item.bowlEmpty, 'E', ADItem.DemonicBlood, 'R', Block.enchantmentTable, 'T', Block.blockDiamond, 'U', ADItem.PureGem, 'I', ADItem.DirtyGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Itable2), "QWE", "RTR", "UIU", 'Q', ADItem.AngelicBlood, 'W', ADItem.GoldBowl, 'E', ADItem.DemonicBlood, 'R', ADBlock.Itable1, 'T', Block.blockDiamond, 'U', ADItem.PureGem, 'I', ADItem.DirtyGem);
		
		// Items
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.GoldBowl), "X X", " X ", 'X', Item.ingotGold);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Spike), " X ", "X X", 'X', Block.cobblestone);
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.PureGem), "XXX", "XQX", "XXX", 'X', ADItem.AngelicBlood, 'Q', ADItem.DirtyGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.RestoredJournal), "SGP", "BLP", "SGP", 'S', Item.silk, 'B', Item.book, 'G', Item.ingotGold, 'L', Item.leather, 'P', Item.paper);
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.DragonBreathe), "PPP", "BLB", "PPP", 'B', Item.glassBottle, 'L', Item.bucketLava, 'P', Item.paper);
		
		// Shapeless
		GameRegistry.addShapelessRecipe(new ItemStack(ADItem.OrangeDust), Item.glowstone, Item.redstone, Item.redstone);
		
		// Pit-Trap
		{
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, 0), "QQQ", " X ", "X X", 'Q', Block.dirt, 'X', Item.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, 1), "QQQ", " X ", "X X", 'Q', Block.sand, 'X', Item.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, 2), "QQQ", " X ", "X X", 'Q', Block.stone, 'X', Item.stick);
			
			for (int i = 3; i < 10; i++) {
				GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, i), "QQQ", " X ", "X X", 'Q', new ItemStack(ADItem.PitTrap, 1, i - 3), 'X', Item.stick);
			}
		}
	}
	
	public static void Worlds() {
		GameRegistry.registerWorldGenerator(new BDiaGen());
	}
	
	public static void Modifiers() {
		MinecraftForge.setBlockHarvestLevel(ADBlock.RedGemOre, "pickaxe", 2);
	}
}
