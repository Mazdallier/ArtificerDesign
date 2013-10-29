package ad.Genis231.lib;

import ad.Genis231.Items.items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Ref {
	
	public static final String MOD_ID = "Artificer";
	public static final String MOD_NAME = "Artificer's Design";
	public static final String MOD_VERSION = "~~CLOSED BETA~~";
	public static final String Resource_FOLDER = "artificer:";
	public static final String Finger = "roarz";
	public static final CreativeTabs TAB = new ADCreativeTAB("Artificer's Design");
	public static final int PortalNumber = 30;
	
	/* Render IDs */
	public static int SpikeRender;
	
	/* Blocks */
	public static final int BDOre = 200; // blood diamond ore
	public static final int FALSE_PIT_TRAP = 201; // fake blocks for pit trap
	public static final int False_Loot = 202; // false loot blocks
	public static final int DamBlock = 203; // dam blocks
	public static final int lamp = 204; // lamp of greatness
	public static final int ITableT1 = 205; //small chest with gui
	public static final int ITableT2 = 206; //small chest with gui
	public static final int BearTrap = 207; //BearTrap of boringness
	public static final int GDirt = 208; // dirt that lights up after touching it
	public static final int Spike = 210; //spike trap
	public static final int PortalBlock = 209;
	
	/* Items */
	public static final int OD = 5000; // orange dust
	public static final int BDD = 5001; // blood diamond dirty
	public static final int BDP = 5002; // blood diamond pure
	public static final int VBlood = 5003; // vampire blood
	public static final int GBowl = 5005; // gold bowl
	public static final int PIT_TRAP = 5006; // pit trap item
	
}

class ADCreativeTAB extends CreativeTabs {
	
	public ADCreativeTAB(String label) {
		super(label);
	}
	
	@Override public ItemStack getIconItemStack() {
		return new ItemStack(items.BDPure);
	}
	
	@Override public String getTranslatedTabLabel() {
		return "Artificer's Design";
	}
}
