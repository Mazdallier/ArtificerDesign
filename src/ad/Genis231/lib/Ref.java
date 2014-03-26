package ad.Genis231.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Ref {
	
	public static final String MOD_ID = "Artificer";
	public static final String MOD_NAME = "Artificer's Design";
	public static final String MOD_VERSION = "Beta-?.?.??";
	public static final String Resource_FOLDER = "artificer:";
	
	public static final CreativeTabs MainTab = new MainTAB("Artificer's Design");
	public static final CreativeTabs BookTab = new BookTAB("Artificer's Research");
	
	/* Render IDs */
	public static int SpikeRender;
	public static int TableRender;
	public static int BTrapRender;
	public static int DrillRender;
}

class MainTAB extends CreativeTabs {
	
	public MainTAB(String label) {
		super(label);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "MainTab";
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.PureGem;
	}
}

class BookTAB extends CreativeTabs {
	
	public BookTAB(String label) {
		super(label);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "BookTab";
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.Book4;
	}
}
