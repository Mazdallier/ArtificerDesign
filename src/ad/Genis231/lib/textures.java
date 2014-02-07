package ad.Genis231.lib;

import net.minecraft.util.ResourceLocation;

public class textures {
	private static String main = "artificer";
	
	/* Model Textures */
	public static final ResourceLocation Spike = new ResourceLocation(main, "textures/blocks/Spikes.png");
	public static final ResourceLocation ITable = new ResourceLocation(main, "textures/blocks/ITable.png");
	public static final ResourceLocation BearTrap = new ResourceLocation(main, "textures/blocks/BearTrap.png");
	
	/* Mob Textures */
	public static final ResourceLocation[] dwarf = { new ResourceLocation(main, "textures/mobs/SavageDwarf.png"), new ResourceLocation(main, "textures/mobs/WarriorDwarf.png"), new ResourceLocation(main, "textures/mobs/TraderDwarf.png") };
	
	/* DamBlock Textures */
	private static final String dam = Ref.Resource_FOLDER + "dam/";
	public static final String[] DamArray = { dam + "side", dam + "open", dam + "close" };
	
	/* DrillBlock Textures */
	private static final String drill = Ref.Resource_FOLDER + "drill/";
	public static final String[] DrillArray = { drill + "evenSide", drill + "oddSide", drill + "top", drill + "bot" };
	
	/* GlowDirtBlock Textures */
	public static final String[] GDArray = { Ref.Resource_FOLDER + "GDirt_side", Ref.Resource_FOLDER + "GDirt_top", Ref.Resource_FOLDER + "GDirt_bot" };
	
	/* Pit Trap Textures */
	public static String[] PitTrapArray = { "Dirt1", "Sand1", "Stone1", "Dirt2", "Sand2", "Stone2", "Dirt3", "Sand3", "Stone3" };
	
	/* ITable Gui */
	public static final ResourceLocation t1 = new ResourceLocation("artificer", "textures/gui/ITable1.png");
	public static final ResourceLocation t2 = new ResourceLocation("artificer", "textures/gui/ITable2.png");
	
	/* Block Textures */
	public static final String BDO = Ref.Resource_FOLDER + "BDOre";
	public static final String DStone = Ref.Resource_FOLDER + "DStone";
	public static final String Fire = Ref.Resource_FOLDER + "GFire";
	
	/* Item Textures */
	public static final String DGem = Ref.Resource_FOLDER + "DGem";
	public static final String PGem = Ref.Resource_FOLDER + "PGem";
	public static final String GoldBowl = Ref.Resource_FOLDER + "Gold_Bowl";
	public static final String ODust = Ref.Resource_FOLDER + "Orange_Dust";
	public static final String ABlood = Ref.Resource_FOLDER + "AngelicBlood";
	public static final String DBlood = Ref.Resource_FOLDER + "DemonicBlood";
	public static final String RJournal = Ref.Resource_FOLDER + "Restored_Journal";
	public static final String DBreathe = Ref.Resource_FOLDER + "Dragon_Breathe";
}
