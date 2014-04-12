package ad.Genis231.lib;

import net.minecraft.util.ResourceLocation;

public class BlockTexture {
	private static String main = "artificer";
	private static final String dam = Ref.Resource_FOLDER + "dam/";
	
	// Blocks
	public static final String DwarvenStone = Ref.Resource_FOLDER + "Dwarven_Stone";
	public static final String Fire = Ref.Resource_FOLDER + "Green_Fire";
	public static final String Coining = Ref.Resource_FOLDER + "Temp";
	
	// Liquid Textures
	public static final String aleLiquid = Ref.Resource_FOLDER + "AleLiquid";
	public static final String aleFlowing = Ref.Resource_FOLDER + "AleFlowing";
	
	// Model Textures
	public static final ResourceLocation Spike = new ResourceLocation(main, "textures/blocks/Spikes.png");
	public static final ResourceLocation Generator = new ResourceLocation(main, "textures/blocks/Generator.png");
	public static final ResourceLocation Drill = new ResourceLocation(main, "textures/blocks/Drill.png");
	
	// Dam array
	public static final String[] Dam = { dam + "side", dam + "open", dam + "close" };
}
