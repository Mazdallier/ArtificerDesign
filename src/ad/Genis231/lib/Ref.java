package ad.Genis231.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import ad.Genis231.Items.items;

public class Ref {
    
    public static final String MOD_ID = "Artificer";
    public static final String MOD_NAME = "Artificer's Design";
    public static final String MOD_VERSION = "Pre-Release";
    public static final String Resource_FOLDER = "artificer:";
    public static final CreativeTabs TAB = new ADCreativeTAB("Artificer's Design");
    
    /* Render IDs */
    public static int SpikeRender;
    public static int Table1Render;
    public static int Table2Render;
    public static int BTrapRender;
}

class ADCreativeTAB extends CreativeTabs {
    
    public ADCreativeTAB(String label) {
        super(label);
    }
    
    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(items.BDPure);
    }
    
    @Override
    public String getTranslatedTabLabel() {
        return "Artificer's Design";
    }
}
