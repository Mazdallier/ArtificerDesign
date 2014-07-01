package ad.Genis231.Refrence;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ad.Genis231.Core.ADItems;

public class CreativeTab {}

class DwarfTAB extends CreativeTabs {
	
	public DwarfTAB(String label) {
		super(label);
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.dwarfBook;
	}
	
	@Override public String getTranslatedTabLabel() {
		return "DwarfTab";
	}
}

class ElfTAB extends CreativeTabs {
	
	public ElfTAB(String label) {
		super(label);
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.elfBook;
	}
	
	@Override public String getTranslatedTabLabel() {
		return "ElfTab";
	}
}

class MainTAB extends CreativeTabs {
	
	public MainTAB(String label) {
		super(label);
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.humanBook;
	}
	
	@Override public String getTranslatedTabLabel() {
		return "MainTab";
	}
}

class OrcTAB extends CreativeTabs {
	
	public OrcTAB(String label) {
		super(label);
	}
	
	@Override public Item getTabIconItem() {
		return ADItems.orcBook;
	}
	
	@Override public String getTranslatedTabLabel() {
		return "OrcTab";
	}
}
