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
	public static final String[] DamArray = { Ref.Resource_FOLDER + "dam_side", Ref.Resource_FOLDER + "dam_open", Ref.Resource_FOLDER + "dam_close" };
	
	/* GlowDirtBlock Textures */
	public static final String[] GDArray = { Ref.Resource_FOLDER + "GDirt_side", Ref.Resource_FOLDER + "GDirt_top", Ref.Resource_FOLDER + "GDirt_bot" };
	
	/* Pit Trap Textures */
	public static String[] PitTrapArray = { "Dirt1", "Sand1", "Stone1", "Dirt2", "Sand2", "Stone2", "Dirt3", "Sand3", "Stone3" };
	
	/* ITable Gui */
	public static final ResourceLocation t1 = new ResourceLocation("artificer", "textures/gui/ITable1.png");
	public static final ResourceLocation t2 = new ResourceLocation("artificer", "textures/gui/ITable2.png");
	
	/* Block Textures */
	public static final String BDO = Ref.Resource_FOLDER + "BDOre";
	public static final String CPP = Ref.Resource_FOLDER + "Plate";
	public static final String DStone = Ref.Resource_FOLDER + "DStone";
	
	/* Item Textures */
	public static final String BDDirty = Ref.Resource_FOLDER + "Dirty_BDiamond";
	public static final String BDPure = Ref.Resource_FOLDER + "Pure_BDiamond";
	public static final String GoldBowl = Ref.Resource_FOLDER + "Gold_Bowl";
	public static final String ODust = Ref.Resource_FOLDER + "Orange_Dust";
	public static final String ABlood = Ref.Resource_FOLDER + "AngelicBlood";
	public static final String DBlood = Ref.Resource_FOLDER + "DemonicBlood";
}
