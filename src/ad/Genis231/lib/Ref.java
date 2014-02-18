package ad.Genis231.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import ad.Genis231.BaseClasses.ADItem;

public class Ref {
	
	public static final String MOD_ID = "Artificer";
	public static final String MOD_NAME = "Artificer's Design";
	public static final String MOD_VERSION = "Beta-1.0.2";
	public static final String Resource_FOLDER = "artificer:";
	public static final CreativeTabs TAB = new ADCreativeTAB("Artificer's Design");
	
	/* Render IDs */
	public static int SpikeRender;
	public static int TableRender;
	public static int BTrapRender;
}

class ADCreativeTAB extends CreativeTabs {
	
	public ADCreativeTAB(String label) {
		super(label);
	}
	
	@Override public ItemStack getIconItemStack() {
		return new ItemStack(ADItem.PureGem);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "Artificer's Design";
	}
}
