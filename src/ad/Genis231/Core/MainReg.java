package ad.Genis231.Core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.Blocks.FalseLoot;
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.Items.PitTrap;
import cpw.mods.fml.common.registry.GameRegistry;

public class MainReg {
	
	public static void basic() {
		/* Blocks */
		Registery.Register(ADBlock.RedGemOre, "RedGemOre", "Red Gem Ore");
		Registery.Register(ADBlock.FalsePitTrap, "NullBlock");
		Registery.Register(ADBlock.Dam, "DamBlock", "Dam");
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
		
		Registery.RegisterMulti(ADBlock.FalseLoot, "FalseLoot", FalseLoot.BlockTextures);
		Registery.RegisterMulti(ADItem.PitTrap, "Vine Mat ", PitTrap.UnlocalizedArray);
	}
	
	public static void recipeGReg() {
		// Blocks
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Dam), "QWQ", "ASA", "QDQ", 'Q', Blocks.stone, 'W', Blocks.trapdoor, 'A', ADItem.PureGem, 'S', Items.water_bucket, 'D', Items.redstone);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Drill), "XXX", "BDB", "IBI", 'X', Blocks.stone, 'B', ADItem.PureGem, 'D', Items.diamond, 'I', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.BearTrap), "TIT", "SSS", 'T', ADBlock.Spike, 'I', ADItem.PureGem, 'S', Items.iron_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Itable1), "QWE", "RTR", "UIU", 'Q', ADItem.AngelicBlood, 'W', Items.bowl, 'E', ADItem.DemonicBlood, 'R', Blocks.enchanting_table, 'T', Blocks.diamond_block, 'U', ADItem.PureGem, 'I', ADItem.DirtyGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Itable2), "QWE", "RTR", "UIU", 'Q', ADItem.AngelicBlood, 'W', ADItem.GoldBowl, 'E', ADItem.DemonicBlood, 'R', ADBlock.Itable1, 'T', Blocks.diamond_block, 'U', ADItem.PureGem, 'I', ADItem.DirtyGem);
		
		// Items
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.GoldBowl), "X X", " X ", 'X', Items.gold_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlock.Spike), " X ", "XGX", 'X', Blocks.cobblestone, 'G', ADItem.PureGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.PureGem), "XXX", "XQX", "XXX", 'X', ADItem.AngelicBlood, 'Q', ADItem.DirtyGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.RestoredJournal), "SGP", "BLP", "SGP", 'S', Items.string, 'B', Items.book, 'G', Items.gold_ingot, 'L', Items.leather, 'P', Items.paper);
		GameRegistry.addShapedRecipe(new ItemStack(ADItem.DragonBreathe), "PPP", "BLB", "PPP", 'B', Items.glass_bottle, 'L', Items.lava_bucket, 'P', Items.paper);
		
		// Shapeless
		GameRegistry.addShapelessRecipe(new ItemStack(ADItem.OrangeDust), Items.glowstone_dust, Items.redstone, Items.redstone);
		
		// Vine Mats
		{
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, 0), "QQQ", "VXV", "XVX", 'Q', Blocks.dirt, 'V', Blocks.vine, 'X', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, 1), "QQQ", "VXV", "XVX", 'Q', Blocks.sand, 'V', Blocks.vine, 'X', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, 2), "QQQ", "VXV", "XVX", 'Q', Blocks.stone, 'V', Blocks.vine, 'X', Items.stick);
			
			for (int i = 3; i < 10; i++) {
				GameRegistry.addShapedRecipe(new ItemStack(ADItem.PitTrap, 1, i), "QQQ", "VXV", "XVX", 'Q', new ItemStack(ADItem.PitTrap, 1, i - 3), 'X', Items.stick, 'V', Blocks.vine);
			}
		}
	}
	
	public static void Worlds() {
		GameRegistry.registerWorldGenerator(new BDiaGen(), 0);
	}
}
