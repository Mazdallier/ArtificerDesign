package ad.Genis231.lib;

import java.io.IOException;
import java.io.InputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class Ref {
	
	public static final String MOD_ID = "Artificer";
	public static final String MOD_NAME = "Artificer's Design";
	public static final String MOD_VERSION = "Beta-?.?.??";
	public static final String Texture_FOLDER = "artificer:";
	public static final String Resource_FOLDER = "artificer";
	
	public static final CreativeTabs MainTab = new MainTAB("Artificer's Design");
	
	/* Render IDs */
	public static int SpikeRender;
	public static int DrillRender;
	public static int DTableRender;
	
	public static InputStream getResource(ResourceLocation resource) throws IOException {
		return Minecraft.getMinecraft().getResourceManager().getResource(resource).getInputStream();
	}
}

class MainTAB extends CreativeTabs {
	
	public MainTAB(String label) {
		super(label);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "Artificer's Design";
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.HumanBook;
	}
}
