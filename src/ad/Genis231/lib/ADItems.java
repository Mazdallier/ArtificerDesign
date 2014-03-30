package ad.Genis231.lib;

import net.minecraft.item.Item;
import ad.Genis231.Items.DragonBreathe;
import ad.Genis231.Items.DwarfBook;
import ad.Genis231.Items.ElfBook;
import ad.Genis231.Items.HumanBook;
import ad.Genis231.Items.Journal;
import ad.Genis231.Items.OrcBook;
import ad.Genis231.Items.Tome;
import ad.Genis231.Items.VineMat;
import ad.Genis231.Items.coin;

public class ADItems {
	public static final Item VineMat = new VineMat(Names.VINE_MAT);
	public static final Item RestoredJournal = new Journal(Names.RESTORED_JOURNAL, ItemTexture.RestoredJournal);
	public static final Item Coin = new coin(Names.COIN, ItemTexture.Coin);
	public static final Item tome = new Tome(Names.Tome, "");
	public static final Item DragonBreathe = new DragonBreathe(Names.DREATHE, ItemTexture.DragonBreathe);
	public static final Item DwarfBook = new DwarfBook(Names.DwarfBook, ItemTexture.book[0]);
	public static final Item ElfBook = new ElfBook(Names.ElfBook, ItemTexture.book[1]);
	public static final Item HumanBook = new HumanBook(Names.HumanBook, ItemTexture.book[2]);
	public static final Item OrcBook = new OrcBook(Names.OrcBook, ItemTexture.book[3]);
}
