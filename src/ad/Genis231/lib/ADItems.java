package ad.Genis231.lib;

import net.minecraft.item.Item;
import ad.Genis231.Items.Blood;
import ad.Genis231.Items.Journal;
import ad.Genis231.Items.RedGem;
import ad.Genis231.Items.Tome;
import ad.Genis231.Items.VineMat;
import ad.Genis231.Items.coin;

public class ADItems {
	public static final Item AngelicBlood = new Blood(Names.ABLOOD, ItemTexture.AngelicBlood);
	public static final Item DemonicBlood = new Blood(Names.DBLOOD, ItemTexture.DemonicBlood);
	public static final Item PureGem = new RedGem(Names.PGEM, ItemTexture.PureGem);
	public static final Item DirtyGem = new RedGem(Names.IGEM, ItemTexture.DirtyGem);
	public static final Item VineMat = new VineMat(Names.VINE_MAT);
	public static final Item RestoredJournal = new Journal(Names.RESTORED_JOURNAL, ItemTexture.RestoredJournal);
	// public static final Item DragonBreathe = new DragonBreathe(Names.DREATHE, ItemTexture.DragonBreathe);
	public static final Item Coin = new coin(Names.COIN, ItemTexture.Coin);
	public static final Item tome = new Tome("", "");
}
