package ad.Genis231.BaseClasses;

import ad.Genis231.Items.*;
import ad.Genis231.lib.ItemTexture;
import ad.Genis231.lib.Names;
import ad.Genis231.lib.Ref;
import net.minecraft.item.Item;

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
	
	public static final Item OrangeDust = new OrangeDust(Names.ODUST);
	public static final Item AngelicBlood = new Blood(Names.ABLOOD, ItemTexture.AngelicBlood);
	public static final Item DemonicBlood = new Blood(Names.DBLOOD, ItemTexture.DemonicBlood);
	public static final Item PureGem = new RedGem(Names.PGEM, ItemTexture.PureGem);
	public static final Item DirtyGem = new RedGem(Names.IGEM, ItemTexture.DirtyGem);
	public static final Item GoldBowl = new GoldBowl(Names.GBOWL);
	public static final Item VineMat = new PitTrap(Names.VINE_MAT);
	public static final Item RestoredJournal = new Journal(Names.RESTORED_JOURNAL, ItemTexture.RestoredJournal);
	public static final Item DragonBreathe = new DragonBreathe(Names.DREATHE);
	public static final Item Coin = new coin(Names.COIN, ItemTexture.Coin);
	public static final Item Rope = new rope(Names.ROPE, ItemTexture.Rope);
	
}
