package ad.Genis231.Core;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import ad.Genis231.ItemBlocks.AleIBlock;
import ad.Genis231.ItemBlocks.DrillIBlock;
import ad.Genis231.Mobs.savageDwarf;
import ad.Genis231.Mobs.traderDwarf;
import ad.Genis231.Mobs.warriorDwarf;
import ad.Genis231.Refrence.ADBlocks;
import ad.Genis231.Refrence.ADItems;
import ad.Genis231.Refrence.Names;
import ad.Genis231.TileEntity.CoiningTile;
import ad.Genis231.TileEntity.DTableTile;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.TileEntity.SpikeTile;
import ad.Genis231.TileEntity.WMMastTile;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MainReg {
	public static final Fluid ale = new Fluid("DwarvenAle");
	
	public static void Core() {
		FluidRegistry.registerFluid(ale);
		
		List<Block> blocks = ADBlocks.getBlocks();
		List<Item> items = ADItems.getItems();
		
		for (Block current : blocks)
			GameRegistry.registerBlock(current, current.getUnlocalizedName());
		for (Item current : items)
			GameRegistry.registerItem(current, current.getUnlocalizedName());
		
		/* Blocks WITH ItemBlocks */
		GameRegistry.registerBlock(ADBlocks.DrillFrame, DrillIBlock.class, Names.DRILLFrame);
		GameRegistry.registerBlock(ADBlocks.AleLiquid, AleIBlock.class, Names.AleLiquid);
		
		/* TileEntities */
		GameRegistry.registerTileEntity(SpikeTile.class, Names.SPIKE);
		GameRegistry.registerTileEntity(DrillTile.class, Names.DRILLFrame);
		GameRegistry.registerTileEntity(CoiningTile.class, Names.MechCoin);
		GameRegistry.registerTileEntity(DTableTile.class, Names.DTable);
		GameRegistry.registerTileEntity(WMMastTile.class, "WMMast");
	}
	
	public static void Recipes() {
		// Vine Mats
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 0), "QQQ", "VXV", "XVX", 'Q', Blocks.dirt, 'V', Blocks.vine, 'X', Items.stick);
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 1), "QQQ", "VXV", "XVX", 'Q', Blocks.sand, 'V', Blocks.vine, 'X', Items.stick);
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 2), "QQQ", "VXV", "XVX", 'Q', Blocks.stone, 'V', Blocks.vine, 'X', Items.stick);
		
		for (int i = 3; i < 9; i++) {
			GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, i), "QQQ", "VXV", "XVX", 'Q', new ItemStack(ADItems.VineMat, 1, i - 3), 'X', Items.stick, 'V', Blocks.vine);
		}
	}
	
	// Mob Stuffz
	static int baseEntityID = 1;
	public static Class[] dwarfClass = { savageDwarf.class, warriorDwarf.class, traderDwarf.class };
	
	public static void mobs() {
		for (int i = 0; i < dwarfClass.length; i++) {
			EntityRegistry.registerModEntity(dwarfClass[i], Names.dwarf[i], i, Artificer.instance, 80, 3, true);
			EntityRegistry.addSpawn(dwarfClass[i], 3, 3, 8, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.river);
			registerNewEgg(dwarfClass[i], UniqueId(), 0xFF0000, 0xBBFF00);
		}
	}
	
	public static int UniqueId() {
		do {
			baseEntityID++;
		} while (EntityList.getStringFromID(baseEntityID) != null);
		return baseEntityID;
	}
	
	public static void registerNewEgg(Class<? extends Entity> entity, int id, int primaryColor, int secondaryColor) {
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
