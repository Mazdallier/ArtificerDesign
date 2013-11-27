package ad.Genis231.Items;

import net.minecraft.item.Item;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.itemIDs;
import ad.Genis231.lib.textures;

public class items {
	
	public final static Item ODust = new ODust(itemIDs.OD).setCreativeTab(Ref.TAB);
	public final static Item DBdirty = new BD_dirty(itemIDs.BDD).setCreativeTab(Ref.TAB);
	public final static Item ABlood = new Blood(itemIDs.Ablood).setCreativeTab(Ref.TAB).setTextureName(textures.ABlood).setUnlocalizedName("ABlood");
	public final static Item DBlood = new Blood(itemIDs.DBlood).setCreativeTab(Ref.TAB).setTextureName(textures.DBlood).setUnlocalizedName("DBlood");
	public final static Item GBowl = new Gold_Bowl(itemIDs.GBowl).setCreativeTab(Ref.TAB);
	public final static Item BDPure = new BD_Pure(itemIDs.BDP).setCreativeTab(Ref.TAB);
	public final static Item PTrap = new pit_trap(itemIDs.PIT_TRAP).setCreativeTab(Ref.TAB);
}
