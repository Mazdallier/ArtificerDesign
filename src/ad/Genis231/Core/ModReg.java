package ad.Genis231.Core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.Items.items;
import ad.Genis231.Items.pit_trap;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModReg {
	
	public static void basic() {
		/* Blocks */
		Registery.Register(blocks.BDiamond_ore, "BDOre", "Dirty Blood Gem Ore");
		Registery.Register(blocks.FPTrap, "null_Block");
		Registery.Register(blocks.Dam, "dam_block", "Dam");
		Registery.Register(blocks.FalseLoot, "FalseLoot", "False Loot");
		Registery.Register(blocks.ItableT1, "Itable1", "Imbueing Table teir1");
		Registery.Register(blocks.ItableT2, "Itable2", "Imbueing Table teir2");
		Registery.Register(blocks.Spike, "SpikePit", "Spike Pit");
		Registery.Register(blocks.BTrap,"BTrap","Bear Trap");
		Registery.Register(blocks.PressurePlate,"CPPlate","Custom Pressure Plate (WIP)");
		Registery.Register(blocks.Drill,"Drill","Drill (WIP)");
		Registery.Register(blocks.DwarvenStone,"DStone","Dwarven Stone");
		
		/* Items */
		Registery.Register(items.ODust, "ORangeDust", "Orange Dust");
		Registery.Register(items.DBdirty, "BDdirty", "Impure Red Gem");
		Registery.Register(items.BDPure, "BDPure", "Purified Red Gem");
		Registery.Register(items.GBowl, "GoldBowl", "Gold Bowl");
		Registery.Register(items.ABlood, "AngelicBlood", "Blessed Elve's Blood");
		Registery.Register(items.DBlood, "DemonicBlood", "Tainted Orc's Blood");
		
		Registery.RegisterMulti(items.PTrap, "VineMat", pit_trap.UnlocalizedArray);
	}
	
	public static void recipeGReg() {
		GameRegistry.addShapedRecipe(new ItemStack(items.GBowl), "X X", " X ", 'X', Item.ingotGold);
		GameRegistry.addShapedRecipe(new ItemStack(blocks.Spike), " X ", "X X", 'X', Block.cobblestone);
		GameRegistry.addShapedRecipe(new ItemStack(blocks.Dam), "QWQ", "ASA", "QDQ", 'Q', Block.stone, 'W', Block.trapdoor, 'A', items.BDPure, 'S', Item.bucketWater, 'D', Item.redstone);
		GameRegistry.addShapedRecipe(new ItemStack(items.BDPure), "XXX", "XQX", "XXX", 'X', items.ABlood, 'Q', items.DBdirty);
		
		{
			GameRegistry.addShapedRecipe(new ItemStack(items.PTrap, 1, 0), "QQQ", " X ", "X X", 'Q', Block.dirt, 'X', Item.stick);
			GameRegistry.addShapedRecipe(new ItemStack(items.PTrap, 1, 1), "QQQ", " X ", "X X", 'Q', Block.sand, 'X', Item.stick);
			GameRegistry.addShapedRecipe(new ItemStack(items.PTrap, 1, 2), "QQQ", " X ", "X X", 'Q', Block.stone, 'X', Item.stick);
			
			for (int i = 3; i < 10; i++) {
				GameRegistry.addShapedRecipe(new ItemStack(items.PTrap, 1, i), "QQQ", " X ", "X X", 'Q', new ItemStack(items.PTrap, 1, i - 3), 'X', Item.stick);
			}
		}
	}
	
	public static void Worlds() {
		GameRegistry.registerWorldGenerator(new BDiaGen());
	}
	
	public static void Modifiers() {
		MinecraftForge.setBlockHarvestLevel(blocks.BDiamond_ore, "pickaxe", 2);
	}
}
