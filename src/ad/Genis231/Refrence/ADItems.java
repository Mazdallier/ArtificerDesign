package ad.Genis231.Refrence;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import ad.Genis231.Items.Arrow;
import ad.Genis231.Items.Axe;
import ad.Genis231.Items.Bow;
import ad.Genis231.Items.DragonBreathe;
import ad.Genis231.Items.DrillPart;
import ad.Genis231.Items.DwarfBook;
import ad.Genis231.Items.ElfBook;
import ad.Genis231.Items.Hoe;
import ad.Genis231.Items.HumanBook;
import ad.Genis231.Items.OrcBook;
import ad.Genis231.Items.Pickaxe;
import ad.Genis231.Items.Shovel;
import ad.Genis231.Items.Sword;
import ad.Genis231.Items.Swords;
import ad.Genis231.Items.Tome;
import ad.Genis231.Items.VineMat;
import ad.Genis231.Items.coin;

public class ADItems {
	public static final Item vineMat = new VineMat(Names.VINE_MAT);
	public static final Item coin = new coin(Names.COIN, textures.Coin);
	public static final Item tome = new Tome(Names.Tome, textures.tome);
	public static final Item dragonBreathe = new DragonBreathe(Names.DREATHE, textures.DragonBreathe);
	public static final Item dwarfBook = new DwarfBook(Names.DwarfBook, textures.book[0]);
	public static final Item elfBook = new ElfBook(Names.ElfBook, textures.book[1]);
	public static final Item humanBook = new HumanBook(Names.HumanBook, textures.book[2]);
	public static final Item orcBook = new OrcBook(Names.OrcBook, textures.book[3]);
	public static final Item aword = new Swords();
	public static final Item drill = new DrillPart();
	
	// public static final Item DwarfBow = new Bow(Names.DwarfBow, textures.DwarfBow, Ref.DwarfTab);
	// public static final Item DwarfArrow = new Arrow(Names.DwarfArrow, textures.DwarfArrow, Ref.DwarfTab);
	// public static final Item DwarfAxe = new Axe(Names.DwarfAxe, textures.DwarfAxe, Ref.DwarfTab);
	// public static final Item DwarfHoe = new Hoe(Names.DwarfHoe, textures.DwarfHoe, Ref.DwarfTab);
	// public static final Item DwarfHammer = new Pickaxe(Names.DwarfHammer, textures.DwarfHammer, Ref.DwarfTab);
	// public static final Item DwarfShovel = new Shovel(Names.DwarfShovel, textures.DwarfShovel, Ref.DwarfTab);
	// public static final Item DwarfSword = new Sword(Names.DwarfSword, textures.DwarfSword, Ref.DwarfTab);
	
	public static final Item elfBow = new Bow(Names.ElfBow, textures.ElfBow, Ref.ElfTab);
	public static final Item elfArrow = new Arrow(Names.ElfArrow, textures.ElfArrow, Ref.ElfTab);
	public static final Item elfAxe = new Axe(Names.ElfAxe, textures.ElfAxe, Ref.ElfTab);
	public static final Item elfHoe = new Hoe(Names.ElfHoe, textures.ElfHoe, Ref.ElfTab);
	public static final Item elfPickaxe = new Pickaxe(Names.ElfPickaxe, textures.ElfPickaxe, Ref.ElfTab);
	public static final Item elfShovel = new Shovel(Names.ElfShovel, textures.ElfShovel, Ref.ElfTab);
	public static final Item elfSword = new Sword(Names.ElfSword, textures.ElfSword, Ref.ElfTab);
	
	public static final Item orcBow = new Bow(Names.OrcBow, textures.OrcBow, Ref.OrcTab);
	public static final Item orcArrow = new Arrow(Names.OrcArrow, textures.OrcArrow, Ref.OrcTab);
	public static final Item orcAxe = new Axe(Names.OrcAxe, textures.OrcAxe, Ref.OrcTab);
	public static final Item orcHoe = new Hoe(Names.OrcHoe, textures.OrcHoe, Ref.OrcTab);
	public static final Item orcHammer = new Pickaxe(Names.OrcHammer, textures.OrcHammer, Ref.OrcTab);
	public static final Item orcShovel = new Shovel(Names.OrcShovel, textures.OrcShovel, Ref.OrcTab);
	public static final Item orcSword = new Sword(Names.OrcSword, textures.OrcSword, Ref.OrcTab);
	
	public static List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		
		items.add(vineMat);
		items.add(coin);
		items.add(tome);
		items.add(dragonBreathe);
		items.add(drill);
		items.add(aword);
		
		items.add(humanBook);
		items.add(dwarfBook);
		items.add(elfBook);
		items.add(orcBook);
		
		// items.add(DwarfSword);
		// items.add(DwarfBow);
		// items.add(DwarfArrow);
		// items.add(DwarfHammer);
		// items.add(DwarfAxe);
		// items.add(DwarfShovel);
		// items.add(DwarfHoe);
		
		items.add(elfSword);
		items.add(elfBow);
		items.add(elfArrow);
		items.add(elfPickaxe);
		items.add(elfAxe);
		items.add(elfShovel);
		items.add(elfHoe);
		
		items.add(orcSword);
		items.add(orcBow);
		items.add(orcArrow);
		items.add(orcHammer);
		items.add(orcAxe);
		items.add(orcShovel);
		items.add(orcHoe);
		
		return items;
	}
}
