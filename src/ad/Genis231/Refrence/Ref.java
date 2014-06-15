package ad.Genis231.Refrence;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.io.InputStream;

public class Ref {
	
	public static final String MOD_ID = "Artificer";
	public static final String MOD_NAME = "Artificer's Design";
	public static final String MOD_VERSION = "Beta-?.?.??";
	public static final String ClientProxy = "ad.Genis231.Core.ClientProxy";
	public static final String CommonProxy = "ad.Genis231.Core.CommonProxy";
	
	public static final String Texture_FOLDER = "artificer:";
	public static final String Resource_FOLDER = "artificer";
	
	public static final CreativeTabs MainTab = new MainTAB("Artificer's Design");
	public static final CreativeTabs DwarfTab = new DwarfTAB("DwarfTab");
	public static final CreativeTabs ElfTab = new ElfTAB("ElfTab");
	public static final CreativeTabs OrcTab = new OrcTAB("OrcTab");
	
	/* Render IDs */
	public static int SpikeRender;
	public static int WMillRender;
	public static int DrillRender;
	public static int DTableRender;
	public static int PipeRender;
	
	public static InputStream getResource(ResourceLocation resource) throws IOException {
		return Minecraft.getMinecraft().getResourceManager().getResource(resource).getInputStream();
	}
}
