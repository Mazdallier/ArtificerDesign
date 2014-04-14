package ad.Genis231.lib;

import net.minecraft.util.ResourceLocation;

public class textures {
	private static final String main = Ref.Resource_FOLDER;
	private static final String icons = "textures/gui/Icons/";
	private static final String books = "textures/gui/Books/";
	
	// GUI
	public static final ResourceLocation coining = new ResourceLocation(main, "textures/gui/coining.png");
	
	// Overlay
	public static final ResourceLocation ResearchPoints = new ResourceLocation(main, "textures/gui/Research Points.png");
	
	// Mob Textures
	public static final ResourceLocation[] dwarf = { new ResourceLocation(main, "textures/mobs/SavageDwarf.png"), new ResourceLocation(main, "textures/mobs/WarriorDwarf.png"), new ResourceLocation(main, "textures/mobs/TraderDwarf.png") };
	
	// SkillBooks
	public static final ResourceLocation[] SkillBookIcons = { new ResourceLocation(main, icons + "Human_Icons.png"), new ResourceLocation(main, icons + "Orc_Icons.png"), new ResourceLocation(main, icons + "Elf_Icons.png"), new ResourceLocation(main, icons + "Dwarf_Icons.png") };
	public static final ResourceLocation[] SkillBooks = { new ResourceLocation(main, books + "Human_SkillBook.png"), new ResourceLocation(main, books + "Orc_SkillBook.png"), new ResourceLocation(main, books + "Elf_SkillBook.png"), new ResourceLocation(main, books + "Dwarf_SkillBook.png") };
}
