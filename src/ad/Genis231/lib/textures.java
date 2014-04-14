package ad.Genis231.lib;

import net.minecraft.util.ResourceLocation;

public class textures {
	private static String main = Ref.Resource_FOLDER;
	
	// GUI
	public static final ResourceLocation coining = new ResourceLocation(main, "textures/gui/coining.png");
	public static final ResourceLocation SkillBook = new ResourceLocation(main, "textures/gui/Book.png");
	
	// Overlay
	public static final ResourceLocation ResearchPoints = new ResourceLocation(main, "textures/gui/Research Points.png");
	
	// Mob Textures
	public static final ResourceLocation[] dwarf = { new ResourceLocation(main, "textures/mobs/SavageDwarf.png"), new ResourceLocation(main, "textures/mobs/WarriorDwarf.png"), new ResourceLocation(main, "textures/mobs/TraderDwarf.png") };
	
	public static final ResourceLocation[] SkillBookIcons = { new ResourceLocation(main, "textures/gui/Human_Icons.png"), new ResourceLocation(main, "textures/gui/Orc_Icons.png"), new ResourceLocation(main, "textures/gui/Elf_Icons.png"), new ResourceLocation(main, "textures/gui/Dwarf_Icons.png") };
	
}
