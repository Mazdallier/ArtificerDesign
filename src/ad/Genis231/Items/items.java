package ad.Genis231.Items;

import net.minecraft.item.Item;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.itemIDs;

public class items {
	
	public final static Item ODust = new ODust(itemIDs.OD).setTextureName(Ref.Resource_FOLDER + "Orange_Dust").setCreativeTab(Ref.TAB);
	public final static Item DBdirty = new BD_dirty(itemIDs.BDD).setTextureName(Ref.Resource_FOLDER + "Dirty_BDiamond").setCreativeTab(Ref.TAB);
	public final static Item VBlood = new Vamp_Blood(itemIDs.VBlood).setTextureName(Ref.Resource_FOLDER + "Vamp_Blood").setUnlocalizedName("VampireBlood").setCreativeTab(Ref.TAB);
	public final static Item GBowl = new Gold_Bowl(itemIDs.GBowl).setTextureName(Ref.Resource_FOLDER + "Gold_Bowl").setCreativeTab(Ref.TAB);
	public final static Item BDPure = new BD_Pure(itemIDs.BDP).setTextureName(Ref.Resource_FOLDER + "Pure_BDiamond").setCreativeTab(Ref.TAB);
	public final static Item PTrap = new pit_trap(itemIDs.PIT_TRAP).setCreativeTab(Ref.TAB);
}
