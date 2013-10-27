package ad.Genis231.Items;

import net.minecraft.item.Item;
import ad.Genis231.lib.Ref;

public class items extends Item {
    
    public final static Item ODust = new ODust(Ref.OD).setTextureName(Ref.Resource_FOLDER + "Orange_Dust").setCreativeTab(Ref.TAB);
    public final static Item DBdirty = new BD_dirty(Ref.BDD).setTextureName(Ref.Resource_FOLDER + "Dirty_BDiamond").setCreativeTab(Ref.TAB);
    public final static Item VBlood = new Vamp_Blood(Ref.VBlood).setTextureName(Ref.Resource_FOLDER + "Vamp_Blood").setUnlocalizedName("VampireBlood").setCreativeTab(Ref.TAB);
    public final static Item GBowl = new Gold_Bowl(Ref.GBowl).setTextureName(Ref.Resource_FOLDER + "Gold_Bowl").setCreativeTab(Ref.TAB);
    public final static Item BDPure = new BD_Pure(Ref.BDP).setTextureName(Ref.Resource_FOLDER + "Pure_BDiamond").setCreativeTab(Ref.TAB);
    public final static Item PTrap = new pit_trap(Ref.PIT_TRAP).setCreativeTab(Ref.TAB);
    
    public items(int par1) {
        super(par1);
    }
}
