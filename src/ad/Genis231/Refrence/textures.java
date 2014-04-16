package ad.Genis231.Refrence;

import net.minecraft.util.ResourceLocation;

public class textures {
	private static final String main = Ref.Resource_FOLDER;
	private static final String icons = "textures/gui/Icons/";
	private static final String books = "textures/gui/Books/";
	private static final String dam = Ref.Texture_FOLDER + "dam/";
	
	// GUI
	public static final ResourceLocation coining = new ResourceLocation(main, "textures/gui/coining.png");
	
	// Overlay
	public static final ResourceLocation ResearchPoints = new ResourceLocation(main, "textures/gui/Research Points.png");
	
	// Mob Textures
	public static final ResourceLocation[] dwarf = { new ResourceLocation(main, "textures/mobs/SavageDwarf.png"), new ResourceLocation(main, "textures/mobs/WarriorDwarf.png"), new ResourceLocation(main, "textures/mobs/TraderDwarf.png") };
	
	// SkillBooks
	public static final ResourceLocation[] SkillBookIcons = { new ResourceLocation(main, icons + "Human_Icons.png"), new ResourceLocation(main, icons + "Orc_Icons.png"), new ResourceLocation(main, icons + "Elf_Icons.png"), new ResourceLocation(main, icons + "Dwarf_Icons.png") };
	public static final ResourceLocation[] SkillBooks = { new ResourceLocation(main, books + "Human_SkillBook.png"), new ResourceLocation(main, books + "Orc_SkillBook.png"), new ResourceLocation(main, books + "Elf_SkillBook.png"), new ResourceLocation(main, books + "Dwarf_SkillBook.png") };
	
	/** Block Textures */
	
	public static final String DwarvenStone = Ref.Texture_FOLDER + "Dwarven_Stone";
	public static final String Fire = Ref.Texture_FOLDER + "Green_Fire";
	public static final String Coining = Ref.Texture_FOLDER + "Temp";
	
	// Liquid Textures
	public static final String aleLiquid = Ref.Texture_FOLDER + "AleLiquid";
	public static final String aleFlowing = Ref.Texture_FOLDER + "AleFlowing";
	
	// Model Textures
	public static final ResourceLocation Spike = new ResourceLocation(Ref.Resource_FOLDER, "textures/blocks/Spikes.png");
	public static final ResourceLocation Drill = new ResourceLocation(Ref.Resource_FOLDER, "textures/blocks/Drill.png");
	public static final ResourceLocation DTable = new ResourceLocation(Ref.Resource_FOLDER, "textures/blocks/DTable.png");
	
	// Dam array
	public static final String[] Dam = { dam + "side", dam + "open", dam + "close" };
	
	private static final String items = Ref.Texture_FOLDER;
	
	/** Item Textures */
	
	public static final String DragonBreathe = items + "Dragon_Breathe";
	public static final String Coin = items + "coin";
	public static final String tome = items + "tome";
	
	private static String Book = items + "Book/";
	public static final String[] book = { Book + "Dwarf", Book + "Elf", Book + "Human", Book + "Orc" };
	public static final String BookOpen = Book + "open";
	public static final String BookClosed = Book + "closed";
	
	// PTrap array
	public static String[] PitTrap = { "Teir1", "Teir2", "Teir3", "dirt", "sand", "stone" };
}
