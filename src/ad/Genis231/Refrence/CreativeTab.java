package ad.Genis231.Refrence;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab {}

class MainTAB extends CreativeTabs {
	
	public MainTAB(String label) {
		super(label);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "MainTab";
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.HumanBook;
	}
}

class ElfTAB extends CreativeTabs {
	
	public ElfTAB(String label) {
		super(label);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "ElfTab";
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.ElfBook;
	}
}

class OrcTAB extends CreativeTabs {
	
	public OrcTAB(String label) {
		super(label);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "OrcTab";
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.OrcBook;
	}
}

class DwarfTAB extends CreativeTabs {
	
	public DwarfTAB(String label) {
		super(label);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "DwarfTab";
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.DwarfBook;
	}
}
