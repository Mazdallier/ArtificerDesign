package ad.Genis231.Core;

import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADItem;
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.TileEntity.model.BearTrapTile;
import ad.Genis231.TileEntity.model.ITable1;
import ad.Genis231.TileEntity.model.ITable2;
import ad.Genis231.TileEntity.model.SpikeTile;
import ad.Genis231.lib.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MainReg {
	
	public static void basic() {
		/* Blocks */
		GameRegistry.registerBlock(ADBlock.RedGemOre, Names.RED_GEM);
		GameRegistry.registerBlock(ADBlock.FalsePitTrap, "null");
		GameRegistry.registerBlock(ADBlock.Dam, Names.DAM_BLOCK);
		GameRegistry.registerBlock(ADBlock.Itable1, Names.IT1);
		GameRegistry.registerBlock(ADBlock.Itable2, Names.IT2);
		GameRegistry.registerBlock(ADBlock.Spike, Names.SPIKE);
		GameRegistry.registerBlock(ADBlock.BearTrap, Names.BTRAP);
		GameRegistry.registerBlock(ADBlock.Drill, Names.DRILL);
		GameRegistry.registerBlock(ADBlock.DwarvenStone, Names.DSTONE);
		GameRegistry.registerBlock(ADBlock.GreenFire, Names.GFIRE);
		GameRegistry.registerBlock(ADBlock.FalseLoot, Names.FALSE_LOOT);
		GameRegistry.registerBlock(ADBlock.DVine, Names.DVINE);
		
		/* Items */
		GameRegistry.registerItem(ADItem.OrangeDust, Names.ODUST);
		GameRegistry.registerItem(ADItem.PureGem, Names.PGEM);
		GameRegistry.registerItem(ADItem.DirtyGem, Names.IGEM);
		GameRegistry.registerItem(ADItem.GoldBowl, Names.GBOWL);
		GameRegistry.registerItem(ADItem.AngelicBlood, Names.ABLOOD);
		GameRegistry.registerItem(ADItem.DemonicBlood, Names.DBLOOD);
		GameRegistry.registerItem(ADItem.RestoredJournal, Names.RESTORED_JOURNAL);
		GameRegistry.registerItem(ADItem.DragonBreathe, Names.DREATHE);
		GameRegistry.registerItem(ADItem.VineMat, Names.VINE_MAT);
		GameRegistry.registerItem(ADItem.Coin, Names.COIN);
		GameRegistry.registerItem(ADItem.Rope, Names.ROPE);

        GameRegistry.registerTileEntity(BearTrapTile.class,"BearTrap");
        GameRegistry.registerTileEntity(ITable1.class,"IT1");
        GameRegistry.registerTileEntity(ITable2.class,"IT2");
        GameRegistry.registerTileEntity(SpikeTile.class,"SpikeTrap");
        GameRegistry.registerTileEntity(DrillTile.class,"Drill");
        GameRegistry.registerTileEntity(ITable1.class,"ITable");
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
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.VineMat, 1, 0), "QQQ", "VXV", "XVX", 'Q', Blocks.dirt, 'V', Blocks.vine, 'X', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.VineMat, 1, 1), "QQQ", "VXV", "XVX", 'Q', Blocks.sand, 'V', Blocks.vine, 'X', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItem.VineMat, 1, 2), "QQQ", "VXV", "XVX", 'Q', Blocks.stone, 'V', Blocks.vine, 'X', Items.stick);
			
			for (int i = 3; i < 10; i++) {
				GameRegistry.addShapedRecipe(new ItemStack(ADItem.VineMat, 1, i), "QQQ", "VXV", "XVX", 'Q', new ItemStack(ADItem.VineMat, 1, i - 3), 'X', Items.stick, 'V', Blocks.vine);
			}
		}
	}
	
	public static void Worlds() {
		GameRegistry.registerWorldGenerator(new BDiaGen(), 0);
	}
}
