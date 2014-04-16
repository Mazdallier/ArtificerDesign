package ad.Genis231.Refrence;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import ad.Genis231.Items.DragonBreathe;
import ad.Genis231.Items.DwarfBook;
import ad.Genis231.Items.ElfBook;
import ad.Genis231.Items.HumanBook;
import ad.Genis231.Items.OrcBook;
import ad.Genis231.Items.Tome;
import ad.Genis231.Items.VineMat;
import ad.Genis231.Items.coin;
import ad.Genis231.Items.Elf.ElfArrow;
import ad.Genis231.Items.Elf.ElfAxe;
import ad.Genis231.Items.Elf.ElfBow;
import ad.Genis231.Items.Elf.ElfHoe;
import ad.Genis231.Items.Elf.ElfPickaxe;
import ad.Genis231.Items.Elf.ElfShovel;
import ad.Genis231.Items.Elf.ElfSword;
import ad.Genis231.Items.Orc.OrcArrow;
import ad.Genis231.Items.Orc.OrcAxe;
import ad.Genis231.Items.Orc.OrcBow;
import ad.Genis231.Items.Orc.OrcHammer;
import ad.Genis231.Items.Orc.OrcHoe;
import ad.Genis231.Items.Orc.OrcShovel;
import ad.Genis231.Items.Orc.OrcSword;

public class ADItems {
	public static final Item VineMat = new VineMat(Names.VINE_MAT);
	public static final Item Coin = new coin(Names.COIN, textures.Coin);
	public static final Item tome = new Tome(Names.Tome, textures.tome);
	public static final Item DragonBreathe = new DragonBreathe(Names.DREATHE, textures.DragonBreathe);
	public static final Item DwarfBook = new DwarfBook(Names.DwarfBook, textures.book[0]);
	public static final Item ElfBook = new ElfBook(Names.ElfBook, textures.book[1]);
	public static final Item HumanBook = new HumanBook(Names.HumanBook, textures.book[2]);
	public static final Item OrcBook = new OrcBook(Names.OrcBook, textures.book[3]);
	
	public static final Item ElfBow = new ElfBow(Names.ElfBow);
	public static final Item ElfArrow = new ElfArrow(Names.ElfArrow);
	public static final Item ElfAxe = new ElfAxe(Names.ElfAxe);
	public static final Item ElfHoe = new ElfHoe(Names.ElfHoe);
	public static final Item ElfPickaxe = new ElfPickaxe(Names.ElfPickaxe);
	public static final Item ElfShovel = new ElfShovel(Names.ElfShovel);
	public static final Item ElfSword = new ElfSword(Names.ElfSword);
	
	public static final Item OrcBow = new OrcBow(Names.OrcBow);
	public static final Item OrcArrow = new OrcArrow(Names.OrcArrow);
	public static final Item OrcAxe = new OrcAxe(Names.OrcAxe);
	public static final Item OrcHoe = new OrcHoe(Names.OrcHoe);
	public static final Item OrcHammer = new OrcHammer(Names.OrcHammer);
	public static final Item OrcShovel = new OrcShovel(Names.OrcShovel);
	public static final Item OrcSword = new OrcSword(Names.OrcSword);
	
	public static List<Item> getItems() {
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
		
		items.add(OrcSword);
		items.add(OrcBow);
		items.add(OrcArrow);
		items.add(OrcHammer);
		items.add(OrcAxe);
		items.add(OrcShovel);
		items.add(OrcHoe);
		
		return items;
	}
}
