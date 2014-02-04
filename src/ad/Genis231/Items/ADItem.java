package ad.Genis231.Items;

import net.minecraft.item.Item;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.itemIDs;
import ad.Genis231.lib.textures;

public class ADItem extends Item {
	
	/**Basic Constructor
	 * 
	 * @param id This is the itemID
	 * @param name This is the UnlocalizedName
	 * */
	public ADItem(int id, String name) {
		super(id);
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
	}
	/**Basic Constructor with texture mapping
	 * 
	 * @param id This is the itemID
	 * @param name This is the UnlocalizedName
	 * @param Texture This is the Texture for said item
	 * */
	public ADItem(int id, String name,String Texture) {
		super(id);
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
		this.setTextureName(textures.BDDirty);
	}
	
	public final static Item ODust = new ODust(itemIDs.OD, "ImPureGem");
	public final static Item ABlood = new Blood(itemIDs.Ablood, "ABlood",textures.ABlood);
	public final static Item DBlood = new Blood(itemIDs.DBlood, "DBlood",textures.DBlood);
	public final static Item GBowl = new Gold_Bowl(itemIDs.GBowl, "GBowl");
	public final static Item PTrap = new pit_trap(itemIDs.PIT_TRAP, "PitTrap");
}
