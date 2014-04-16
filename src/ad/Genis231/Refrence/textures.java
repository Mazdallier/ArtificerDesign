package ad.Genis231.Refrence;

import net.minecraft.util.ResourceLocation;

public class textures{
	private static final String main = Ref.Resource_FOLDER;
	private static final String items = Ref.Texture_FOLDER;
	private static final String icons = "textures/gui/Icons/";
	private static final String books = "textures/gui/Books/";
	private static final String dam = items + "dam/";
	private static final String Book = items + "Book/";
	private static final String Elf = items + "Elf/";
	private static final String Orc = items + "Orc/";
	private static final String Dwarf = items + "Dwarf/";

	// GUI
	public static final ResourceLocation[] dwarf = {new ResourceLocation(main,"textures/mobs/SavageDwarf.png"),new ResourceLocation(main,"textures/mobs/WarriorDwarf.png"),new ResourceLocation(main,"textures/mobs/TraderDwarf.png")};
	public static final ResourceLocation[] SkillBooks = {new ResourceLocation(main,books + "Human_SkillBook.png"),new ResourceLocation(main,books + "Dwarf_SkillBook.png"),new ResourceLocation(main,books + "Elf_SkillBook.png"),new ResourceLocation(main,books + "Orc_SkillBook.png")};
	public static final ResourceLocation[] SkillBookIcons = {new ResourceLocation(main,icons + "Human_Icons.png"),new ResourceLocation(main,icons + "Dwarf_Icons.png"),new ResourceLocation(main,icons + "Elf_Icons.png"),new ResourceLocation(main,icons + "Orc_Icons.png")};
	public static final ResourceLocation coining = new ResourceLocation(main,"textures/gui/coining.png");
	public static final ResourceLocation ResearchPoints = new ResourceLocation(main,"textures/gui/Research Points.png");
	public static final ResourceLocation Spike = new ResourceLocation(main,"textures/blocks/Spikes.png");
	public static final ResourceLocation Drill = new ResourceLocation(main,"textures/blocks/Drill.png");
	public static final ResourceLocation DTable = new ResourceLocation(main,"textures/blocks/DTable.png");

	/**
	 * Block Textures
	 */
	public static final String[] Dam = {dam + "side",dam + "open",dam + "close"};
	public static final String DwarvenStone = items + "Dwarven_Stone";
	public static final String Fire = items + "Green_Fire";

	/**
	 * Liquid Textures
	 */
	public static final String aleLiquid = items + "AleLiquid";
	public static final String aleFlowing = items + "AleFlowing";
	/**
	 * Item Textures
	 */
	public static String[] PitTrap = {"Teir1","Teir2","Teir3","dirt","sand","stone"};
	public static final String[] book = {Book + "Dwarf",Book + "Elf",Book + "Human",Book + "Orc"};
	public static final String BookOpen = Book + "open";
	public static final String DragonBreathe = items + "Dragon_Breathe";
	public static final String Coin = items + "coin";
	public static final String tome = items + "tome";

	public static final String ElfBow = Elf + "bow_idle";
	public static final String ElfArrow = Elf + "Arrow";
	public static final String ElfAxe = Elf + "Axe";
	public static final String ElfHoe = Elf + "Hoe";
	public static final String ElfPickaxe = Elf + "Pickaxe";
	public static final String ElfShovel = Elf + "Shovel";
	public static final String ElfSword = Elf + "Sword";
	
	public static final String OrcBow = Orc + "Bow";
	public static final String OrcArrow = Orc + "Arrow";
	public static final String OrcAxe = Orc + "Axe";
	public static final String OrcHoe = Orc + "Hoe";
	public static final String OrcHammer = Orc + "Hammer";
	public static final String OrcShovel = Orc + "Shovel";
	public static final String OrcSword = Orc + "Sword";
}
