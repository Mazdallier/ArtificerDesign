package ad.Genis231.lib;

import net.minecraft.item.Item;
import ad.Genis231.Items.Blood;
import ad.Genis231.Items.Journal;
import ad.Genis231.Items.RedGem;
import ad.Genis231.Items.Tome;
import ad.Genis231.Items.VineMat;
import ad.Genis231.Items.coin;
import ad.Genis231.Items.skillBooks.BookTeir1;
import ad.Genis231.Items.skillBooks.BookTeir2;
import ad.Genis231.Items.skillBooks.BookTeir3;
import ad.Genis231.Items.skillBooks.BookTeir4;

public class ADItems {
	public static final Item AngelicBlood = new Blood(Names.ABLOOD, ItemTexture.AngelicBlood);
	public static final Item DemonicBlood = new Blood(Names.DBLOOD, ItemTexture.DemonicBlood);
	public static final Item PureGem = new RedGem(Names.PGEM, ItemTexture.PureGem);
	public static final Item DirtyGem = new RedGem(Names.IGEM, ItemTexture.DirtyGem);
	public static final Item VineMat = new VineMat(Names.VINE_MAT);
	public static final Item RestoredJournal = new Journal(Names.RESTORED_JOURNAL, ItemTexture.RestoredJournal);
	// public static final Item DragonBreathe = new DragonBreathe(Names.DREATHE, ItemTexture.DragonBreathe);
	public static final Item Coin = new coin(Names.COIN, ItemTexture.Coin);
	public static final Item tome = new Tome(Names.Tome, "");
	
	public static final Item Book1 = new BookTeir1(Names.Book1, ItemTexture.book[0]);
	public static final Item Book2 = new BookTeir2(Names.Book2, ItemTexture.book[1]);
	public static final Item Book3 = new BookTeir3(Names.Book3, ItemTexture.book[2]);
	public static final Item Book4 = new BookTeir4(Names.Book4, ItemTexture.book[3]);
}
