package ad.Genis231.Refrence;

import ad.Genis231.Items.*;
import ad.Genis231.Items.Elf.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ADItems{
	public static final Item VineMat = new VineMat(Names.VINE_MAT);
	public static final Item Coin = new coin(Names.COIN,textures.Coin);
	public static final Item tome = new Tome(Names.Tome,textures.tome);
	public static final Item DragonBreathe = new DragonBreathe(Names.DREATHE,textures.DragonBreathe);
	public static final Item DwarfBook = new DwarfBook(Names.DwarfBook,textures.book[0]);
	public static final Item ElfBook = new ElfBook(Names.ElfBook,textures.book[1]);
	public static final Item HumanBook = new HumanBook(Names.HumanBook,textures.book[2]);
	public static final Item OrcBook = new OrcBook(Names.OrcBook,textures.book[3]);

	public static final Item ElfBow = new ElfBow(Names.ElfBow);
	public static final Item ElfArrow = new ElfArrow(Names.ElfArrow);
	public static final Item ElfAxe = new ElfAxe(Names.ElfAxe);
	public static final Item ElfHoe = new ElfHoe(Names.ElfHoe);
	public static final Item ElfPickaxe = new ElfPickaxe(Names.ElfPickaxe);
	public static final Item ElfShovel = new ElfShovel(Names.ElfShovel);
	public static final Item ElfSword = new ElfSword(Names.ElfSword);

	public static List<Item> getItems(){
		List<Item> items = new ArrayList<Item>();

		items.add(VineMat);
		items.add(Coin);
		items.add(tome);
		items.add(DragonBreathe);

		items.add(HumanBook);
		items.add(DwarfBook);
		items.add(ElfBook);
		items.add(OrcBook);

		items.add(ElfSword);
		items.add(ElfBow);
		items.add(ElfArrow);
		items.add(ElfPickaxe);
		items.add(ElfAxe);
		items.add(ElfShovel);
		items.add(ElfHoe);

		return items;
	}
}
