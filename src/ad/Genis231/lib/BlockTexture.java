package ad.Genis231.lib;

import net.minecraft.util.ResourceLocation;

public class BlockTexture {
	private static final String dam = Ref.Texture_FOLDER + "dam/";
	
	// Blocks
	public static final String DwarvenStone = Ref.Texture_FOLDER + "Dwarven_Stone";
	public static final String Fire = Ref.Texture_FOLDER + "Green_Fire";
	public static final String Coining = Ref.Texture_FOLDER + "Temp";
	
	// Liquid Textures
	public static final String aleLiquid = Ref.Texture_FOLDER + "AleLiquid";
	public static final String aleFlowing = Ref.Texture_FOLDER + "AleFlowing";
	
	// Model Textures
	public static final ResourceLocation Spike = new ResourceLocation(Ref.Resource_FOLDER, "textures/blocks/Spikes.png");
	public static final ResourceLocation Drill = new ResourceLocation(Ref.Resource_FOLDER, "textures/blocks/Drill.png");
	
	// Dam array
	public static final String[] Dam = { dam + "side", dam + "open", dam + "close" };
}
