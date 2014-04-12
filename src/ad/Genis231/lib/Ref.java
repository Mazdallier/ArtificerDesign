package ad.Genis231.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Ref {
	
	public static final String MOD_ID = "Artificer";
	public static final String MOD_NAME = "Artificer's Design";
	public static final String MOD_VERSION = "Beta-?.?.??";
	public static final String Resource_FOLDER = "artificer:";
	
	public static final CreativeTabs MainTab = new MainTAB("Artificer's Design");
	
	/* Render IDs */
	public static int SpikeRender;
	public static int DrillRender;
	public static int GeneratorRender;
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
