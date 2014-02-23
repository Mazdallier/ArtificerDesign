package ad.Genis231.lib;

import net.minecraft.util.ResourceLocation;

public class BlockTexture {
	private static String main = "artificer";
	private static final String drill = Ref.Resource_FOLDER + "drill/";
	private static final String dam = Ref.Resource_FOLDER + "dam/";
	
	// Blocks
	public static final String RedGemOre = Ref.Resource_FOLDER + "Red_Gem_Ore";
	public static final String DwarvenStone = Ref.Resource_FOLDER + "Dwarven_Stone";
	public static final String Fire = Ref.Resource_FOLDER + "Green_Fire";
	public static final String DriedVine = Ref.Resource_FOLDER + "dried_vines";
	
	// Model Textures
	public static final ResourceLocation Spike = new ResourceLocation(main, "textures/blocks/Spikes.png");
	public static final ResourceLocation ITable = new ResourceLocation(main, "textures/blocks/ITable.png");
	public static final ResourceLocation BearTrap = new ResourceLocation(main, "textures/blocks/Bear_Trap.png");
	
	// Drill array
	public static final String[] Drill = { drill + "evenSide", drill + "oddSide", drill + "top", drill + "bot" };
	
	// Dam array
	public static final String[] Dam = { dam + "side", dam + "open", dam + "close" };
}
