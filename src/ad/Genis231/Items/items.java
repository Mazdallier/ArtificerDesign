package ad.Genis231.Items;

import net.minecraft.item.Item;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.itemIDs;

public class items {
	
	public final static Item ODust = new ODust(itemIDs.OD).setCreativeTab(Ref.TAB);
	public final static Item DBdirty = new BD_dirty(itemIDs.BDD).setCreativeTab(Ref.TAB);
	public final static Item VBlood = new Vamp_Blood(itemIDs.VBlood).setCreativeTab(Ref.TAB);
	public final static Item GBowl = new Gold_Bowl(itemIDs.GBowl).setCreativeTab(Ref.TAB);
	public final static Item BDPure = new BD_Pure(itemIDs.BDP).setCreativeTab(Ref.TAB);
	public final static Item PTrap = new pit_trap(itemIDs.PIT_TRAP).setCreativeTab(Ref.TAB);
}
