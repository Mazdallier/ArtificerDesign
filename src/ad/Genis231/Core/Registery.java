package ad.Genis231.Core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Registery {
	/* Blocks */
	public static void Register(Block block, String name) {
		GameRegistry.registerBlock(block, name);
	}
	
	public static void Register(Block block, String name, String stuff) {
		Register(block, name);
		LanguageRegistry.addName(block, stuff);
	}
	
	public static void RegisterMulti(Block block, String name, String[] array) {
		GameRegistry.registerBlock(block, name);
		
		for (int i = 0; i < array.length; i++)
			LanguageRegistry.addName(block, array[new ItemStack(block, 1, i).getItemDamage()]);
	}
	
	/* Items */
	public static void Register(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}
	
	public static void Register(Item item, String name, String stuff) {
		Register(item, name);
		LanguageRegistry.addName(item, stuff);
	}
	
	public static void RegisterMulti(Item item, String name, String[] array) {
		Register(item, name);
		
		for (int i = 0; i < array.length; i++) {
			LanguageRegistry.addName(item, array[i]);
			
			LanguageRegistry.instance().addStringLocalization(item.getUnlocalizedName() + array[i] + ".name", name + array[i]);
		}
	}
}
