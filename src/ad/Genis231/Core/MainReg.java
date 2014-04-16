package ad.Genis231.Core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MainReg {
	public static final Fluid ale = new Fluid("AD_DwarvenAle");
	
	public static void Core() {
		/* Fluids */
		FluidRegistry.registerFluid(ale);
		
		/* Blocks WITH ItemBlocks */
		GameRegistry.registerBlock(ADBlocks.Drill, DrillIBlock.class, Names.DRILL);
		GameRegistry.registerBlock(ADBlocks.AleLiquid, AleIBlock.class, Names.AleLiquid);
		
		/* Blocks */
		GameRegistry.registerBlock(ADBlocks.FalsePitTrap, "null");
		GameRegistry.registerBlock(ADBlocks.Dam, Names.DAM_BLOCK);
		GameRegistry.registerBlock(ADBlocks.Spike, Names.SPIKE);
		GameRegistry.registerBlock(ADBlocks.DwarvenStone, Names.DSTONE);
		GameRegistry.registerBlock(ADBlocks.coiningMech, Names.MechCoin);
		GameRegistry.registerBlock(ADBlocks.FakeFire, Names.GFIRE);
		GameRegistry.registerBlock(ADBlocks.DTable, Names.DTable);
		
		/* Items */
		GameRegistry.registerItem(ADItems.VineMat, Names.VINE_MAT);
		GameRegistry.registerItem(ADItems.Coin, Names.COIN);
		GameRegistry.registerItem(ADItems.tome, Names.Tome);
		GameRegistry.registerItem(ADItems.DragonBreathe, Names.DREATHE);
		
		/* Skill Books */
		GameRegistry.registerItem(ADItems.HumanBook, Names.HumanBook);
		GameRegistry.registerItem(ADItems.DwarfBook, Names.DwarfBook);
		GameRegistry.registerItem(ADItems.ElfBook, Names.ElfBook);
		GameRegistry.registerItem(ADItems.OrcBook, Names.OrcBook);
		
		/* TileEntities */
		GameRegistry.registerTileEntity(SpikeTile.class, Names.SPIKE);
		GameRegistry.registerTileEntity(DrillTile.class, Names.DRILL);
		GameRegistry.registerTileEntity(CoiningTile.class, Names.MechCoin);
		GameRegistry.registerTileEntity(DTableTile.class, Names.DTable);
	}
	
	public static void Recipes() {
		// Vine Mats
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 0), "QQQ", "VXV", "XVX", 'Q', Blocks.dirt, 'V', Blocks.vine, 'X', Items.stick);
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 1), "QQQ", "VXV", "XVX", 'Q', Blocks.sand, 'V', Blocks.vine, 'X', Items.stick);
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 2), "QQQ", "VXV", "XVX", 'Q', Blocks.stone, 'V', Blocks.vine, 'X', Items.stick);
		
		for (int i = 3; i < 10; i++) {
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
