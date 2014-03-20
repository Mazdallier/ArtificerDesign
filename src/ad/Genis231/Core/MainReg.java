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
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.Mobs.savageDwarf;
import ad.Genis231.Mobs.traderDwarf;
import ad.Genis231.Mobs.warriorDwarf;
import ad.Genis231.Network.PacketPipeline;
import ad.Genis231.Network.Packets.DrillPacket;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.TileEntity.model.BearTrapTile;
import ad.Genis231.TileEntity.model.ITable1;
import ad.Genis231.TileEntity.model.ITable2;
import ad.Genis231.TileEntity.model.SpikeTile;
import ad.Genis231.lib.ADBlocks;
import ad.Genis231.lib.ADItems;
import ad.Genis231.lib.Names;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class MainReg {
	public static final Fluid ale = new Fluid("AD_DwarvenAle");
	
	public static void Core() {
		/* Fluids */
		FluidRegistry.registerFluid(ale);
		
		/* Blocks */
		GameRegistry.registerBlock(ADBlocks.RedGemOre, Names.RED_GEM);
		GameRegistry.registerBlock(ADBlocks.FalsePitTrap, "null");
		GameRegistry.registerBlock(ADBlocks.Dam, Names.DAM_BLOCK);
		GameRegistry.registerBlock(ADBlocks.Itable1, Names.IT1);
		GameRegistry.registerBlock(ADBlocks.Itable2, Names.IT2);
		GameRegistry.registerBlock(ADBlocks.Spike, Names.SPIKE);
		GameRegistry.registerBlock(ADBlocks.BearTrap, Names.BTRAP);
		GameRegistry.registerBlock(ADBlocks.Drill, Names.DRILL);
		GameRegistry.registerBlock(ADBlocks.DwarvenStone, Names.DSTONE);
//		GameRegistry.registerBlock(ADBlocks.GreenFire, Names.GFIRE);
		GameRegistry.registerBlock(ADBlocks.FalseLoot, Names.FALSE_LOOT);
		GameRegistry.registerBlock(ADBlocks.DVine, Names.DVINE);
		GameRegistry.registerBlock(ADBlocks.coingMech, Names.MechCoin);
		GameRegistry.registerBlock(ADBlocks.DrillPart, Names.DrillPart);
		GameRegistry.registerBlock(ADBlocks.AleLiquid, Names.AleLiquid);
		
		/* Items */
		GameRegistry.registerItem(ADItems.PureGem, Names.PGEM);
		GameRegistry.registerItem(ADItems.DirtyGem, Names.IGEM);
		GameRegistry.registerItem(ADItems.GoldBowl, Names.GBOWL);
		GameRegistry.registerItem(ADItems.AngelicBlood, Names.ABLOOD);
		GameRegistry.registerItem(ADItems.DemonicBlood, Names.DBLOOD);
		GameRegistry.registerItem(ADItems.RestoredJournal, Names.RESTORED_JOURNAL);
//		GameRegistry.registerItem(ADItems.DragonBreathe, Names.DREATHE);
		GameRegistry.registerItem(ADItems.VineMat, Names.VINE_MAT);
		GameRegistry.registerItem(ADItems.Coin, Names.COIN);
		GameRegistry.registerItem(ADItems.Rope, Names.ROPE);
		
		/* TileEntities */
		GameRegistry.registerTileEntity(BearTrapTile.class, "BearTrap");
		GameRegistry.registerTileEntity(ITable1.class, "IT1");
		GameRegistry.registerTileEntity(ITable2.class, "IT2");
		GameRegistry.registerTileEntity(SpikeTile.class, "SpikeTrap");
		GameRegistry.registerTileEntity(DrillTile.class, "Drill");
	}
	
	public static void Recipes() {
		// Blocks
		GameRegistry.addShapedRecipe(new ItemStack(ADBlocks.Dam), "QWQ", "ASA", "QDQ", 'Q', Blocks.stone, 'W', Blocks.trapdoor, 'A', ADItems.PureGem, 'S', Items.water_bucket, 'D', Items.redstone);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlocks.Drill), "XXX", "BDB", "IBI", 'X', Blocks.stone, 'B', ADItems.PureGem, 'D', Items.diamond, 'I', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlocks.BearTrap), "TIT", "SSS", 'T', ADBlocks.Spike, 'I', ADItems.PureGem, 'S', Items.iron_ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ADBlocks.Itable1), "QWE", "RTR", "UIU", 'Q', ADItems.AngelicBlood, 'W', Items.bowl, 'E', ADItems.DemonicBlood, 'R', Blocks.enchanting_table, 'T', Blocks.diamond_block, 'U', ADItems.PureGem, 'I', ADItems.DirtyGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlocks.Itable2), "QWE", "RTR", "UIU", 'Q', ADItems.AngelicBlood, 'W', ADItems.GoldBowl, 'E', ADItems.DemonicBlood, 'R', ADBlocks.Itable1, 'T', Blocks.diamond_block, 'U', ADItems.PureGem, 'I', ADItems.DirtyGem);
		
		// Items
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.GoldBowl), "X X", " X ", 'X', Items.gold_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ADBlocks.Spike), " X ", "XGX", 'X', Blocks.cobblestone, 'G', ADItems.PureGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.PureGem), "XXX", "XQX", "XXX", 'X', ADItems.AngelicBlood, 'Q', ADItems.DirtyGem);
		GameRegistry.addShapedRecipe(new ItemStack(ADItems.RestoredJournal), "SGP", "BLP", "SGP", 'S', Items.string, 'B', Items.book, 'G', Items.gold_ingot, 'L', Items.leather, 'P', Items.paper);
//		GameRegistry.addShapedRecipe(new ItemStack(ADItems.DragonBreathe), "PPP", "BLB", "PPP", 'B', Items.glass_bottle, 'L', Items.lava_bucket, 'P', Items.paper);
		
		// Vine Mats
		{
			GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 0), "QQQ", "VXV", "XVX", 'Q', Blocks.dirt, 'V', Blocks.vine, 'X', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 1), "QQQ", "VXV", "XVX", 'Q', Blocks.sand, 'V', Blocks.vine, 'X', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, 2), "QQQ", "VXV", "XVX", 'Q', Blocks.stone, 'V', Blocks.vine, 'X', Items.stick);
			
			for (int i = 3; i < 10; i++) {
				GameRegistry.addShapedRecipe(new ItemStack(ADItems.VineMat, 1, i), "QQQ", "VXV", "XVX", 'Q', new ItemStack(ADItems.VineMat, 1, i - 3), 'X', Items.stick, 'V', Blocks.vine);
			}
		}
	}
	
	public static void World() {
		GameRegistry.registerWorldGenerator(new BDiaGen(), 0);
	}
	
	public static void Packets(PacketPipeline packets) {
		packets.registerPacket(DrillPacket.class);
	}
	
	// Mob Stuffz
	
	static int baseEntityID = 1;
	public static Class[] dwarfClass = { savageDwarf.class, warriorDwarf.class, traderDwarf.class };
	
	public static void mobs() {
		for (int i = 0; i < dwarfClass.length; i++) {
			EntityRegistry.registerModEntity(dwarfClass[i], Names.dwarf[i], i, Artificer.instance, 80, 3, true);
			EntityRegistry.addSpawn(dwarfClass[i], 3, 20, 50, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.river);
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
