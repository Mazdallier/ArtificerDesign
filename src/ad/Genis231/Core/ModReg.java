package ad.Genis231.Core;

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
		/*Blocks*/
		Registery.Register(blocks.BDiamond_ore, "BDOre", "Dirty Blood Gem Ore");
		Registery.Register(blocks.FPTrap, "null_Block");
		Registery.Register(blocks.Dam, "dam_block", "Dam (WIP)");
		Registery.Register(blocks.FalseLoot, "FalseLoot", "False Loot");
		Registery.Register(blocks.ItableT1, "Itable1", "Imbueing Table teir1");
		Registery.Register(blocks.ItableT2, "Itable2", "Imbueing Table teir2");
		Registery.Register(blocks.GlowDirt, "GlowDirt", "Glow Dirt");
		Registery.Register(blocks.Spike, "SpikeTrap", "Spike Trap");
		
		/*Items*/
		Registery.Register(items.ODust, "ORangeDust", "Orange Dust");
		Registery.Register(items.DBdirty, "BDdirty", "Impure Red Diamond");
		Registery.Register(items.BDPure, "BDPure", "Blood Infussed Diamond");
		Registery.Register(items.GBowl, "GoldBowl", "Gold Bowl");
		Registery.Register(items.VBlood, "VampireBlood", "Vampire Blood");
		
		Registery.RegisterMulti(items.PTrap, "pit-trap", pit_trap.UnlocalizedArray);
	}
	
	public static void recipeGReg() {
		final ItemStack ODStack = new ItemStack(items.ODust, 1);
		final ItemStack RedstoneStack = new ItemStack(Item.redstone, 1);
		final ItemStack GlowstoneStack = new ItemStack(Item.glowstone, 1);
		
		GameRegistry.addShapelessRecipe(ODStack, GlowstoneStack, RedstoneStack, RedstoneStack);
		GameRegistry.addShapedRecipe(new ItemStack(items.GBowl), "X X", " X ", 'X', new ItemStack(Item.ingotGold, 1));
		
	}
	
	public static void Worlds() {
		GameRegistry.registerWorldGenerator(new BDiaGen());
	}
	
	public static void Modifiers() {
		MinecraftForge.setBlockHarvestLevel(blocks.BDiamond_ore, "pickaxe", 2);
	}
	
}
