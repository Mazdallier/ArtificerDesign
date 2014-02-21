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
	 * @param name This is the UnlocalizedName */
	public ADItem(String name) {
		super();
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
	}
	
	/** Basic Constructor with texture mapping
	 * @param name This is the UnlocalizedName
	 * @param Texture This is the Texture for said item */
	public ADItem(String name, String Texture) {
		super();
		this.setCreativeTab(Ref.TAB);
		this.setUnlocalizedName(name);
		this.setTextureName(Texture);
	}
	
	public final static Item OrangeDust = new OrangeDust("ImPureGem");
	public final static Item AngelicBlood = new Blood("ABlood", textures.AngelicBlood);
	public final static Item DemonicBlood = new Blood("DBlood", textures.DemonicBlood);
	public final static Item PureGem = new RedGem("PureGem", textures.PureGem);
	public final static Item DirtyGem = new RedGem("ImPureGem", textures.DirtyGem);
	public final static Item GoldBowl = new GoldBowl( "GBowl");
	public final static Item PitTrap = new PitTrap("Vine Mat ");
	public final static Item RestoredJournal = new Journal("Rjournal", textures.RestoredJournal);
	public final static Item DragonBreathe = new DragonBreathe("DBreathe");
	
}
