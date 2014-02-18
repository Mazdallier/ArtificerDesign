package ad.Genis231.BaseClasses;

import net.minecraft.item.Item;
import ad.Genis231.Items.Blood;
import ad.Genis231.Items.DragonBreathe;
import ad.Genis231.Items.GoldBowl;
import ad.Genis231.Items.Journal;
import ad.Genis231.Items.OrangeDust;
import ad.Genis231.Items.PitTrap;
import ad.Genis231.Items.RedGem;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.itemIDs;
import ad.Genis231.lib.textures;

public class ADItem extends Item {
	
	/** Basic Constructor
	 * @param id This is the itemID
	 * @param name This is the UnlocalizedName */
	public ADItem(int id, String name) {
		super(id);
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
	}
	
	/** Basic Constructor with texture mapping
	 * @param id This is the itemID
	 * @param name This is the UnlocalizedName
	 * @param Texture This is the Texture for said item */
	public ADItem(int id, String name, String Texture) {
		super(id);
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
		this.setTextureName(Texture);
	}
	
	public final static Item OrangeDust = new OrangeDust(itemIDs.OrangeDust, "ImPureGem");
	public final static Item AngelicBlood = new Blood(itemIDs.Angelicblood, "ABlood", textures.AngelicBlood);
	public final static Item DemonicBlood = new Blood(itemIDs.DemonicBlood, "DBlood", textures.DemonicBlood);
	public final static Item PureGem = new RedGem(itemIDs.PureGem, "PureGem", textures.PureGem);
	public final static Item DirtyGem = new RedGem(itemIDs.DirtyGem, "ImPureGem", textures.DirtyGem);
	public final static Item GoldBowl = new GoldBowl(itemIDs.GoldBowl, "GBowl");
	public final static Item PitTrap = new PitTrap(itemIDs.PitTrap, "Vine Mat ");
	public final static Item RestoredJournal = new Journal(itemIDs.RestoredJournal, "Rjournal", textures.RestoredJournal);
	public final static Item DragonBreathe = new DragonBreathe(itemIDs.DragonBreathe, "DBreathe");
	
}
