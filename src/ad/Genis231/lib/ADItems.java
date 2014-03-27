package ad.Genis231.lib;

import net.minecraft.item.Item;
import ad.Genis231.Items.Journal;
import ad.Genis231.Items.Tome;
import ad.Genis231.Items.VineMat;
import ad.Genis231.Items.coin;
import ad.Genis231.Items.skillBooks.BookTeir1;
import ad.Genis231.Items.skillBooks.BookTeir2;
import ad.Genis231.Items.skillBooks.BookTeir3;
import ad.Genis231.Items.skillBooks.BookTeir4;

public class ADItems {
	public static final Item VineMat = new VineMat(Names.VINE_MAT);
	public static final Item RestoredJournal = new Journal(Names.RESTORED_JOURNAL, ItemTexture.RestoredJournal);
	public static final Item Coin = new coin(Names.COIN, ItemTexture.Coin);
	public static final Item tome = new Tome(Names.Tome, "");
	
	public static final Item Book1 = new BookTeir1(Names.Book1, ItemTexture.book[0]);
	public static final Item Book2 = new BookTeir2(Names.Book2, ItemTexture.book[1]);
	public static final Item Book3 = new BookTeir3(Names.Book3, ItemTexture.book[2]);
	public static final Item Book4 = new BookTeir4(Names.Book4, ItemTexture.book[3]);
}
