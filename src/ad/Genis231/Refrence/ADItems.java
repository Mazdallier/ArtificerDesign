package ad.Genis231.Refrence;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import ad.Genis231.Items.DragonBreathe;
import ad.Genis231.Items.DwarfBook;
import ad.Genis231.Items.ElfBook;
import ad.Genis231.Items.HumanBook;
import ad.Genis231.Items.OrcBook;
import ad.Genis231.Items.Swords;
import ad.Genis231.Items.Tome;
import ad.Genis231.Items.VineMat;
import ad.Genis231.Items.coin;
import ad.Genis231.Items.uni.Arrow;
import ad.Genis231.Items.uni.Axe;
import ad.Genis231.Items.uni.Bow;
import ad.Genis231.Items.uni.Hoe;
import ad.Genis231.Items.uni.Pickaxe;
import ad.Genis231.Items.uni.Shovel;
import ad.Genis231.Items.uni.Sword;

public class ADItems {
	public static final Item VineMat = new VineMat(Names.VINE_MAT);
	public static final Item Coin = new coin(Names.COIN, textures.Coin);
	public static final Item tome = new Tome(Names.Tome, textures.tome);
	public static final Item DragonBreathe = new DragonBreathe(Names.DREATHE, textures.DragonBreathe);
	public static final Item DwarfBook = new DwarfBook(Names.DwarfBook, textures.book[0]);
	public static final Item ElfBook = new ElfBook(Names.ElfBook, textures.book[1]);
	public static final Item HumanBook = new HumanBook(Names.HumanBook, textures.book[2]);
	public static final Item OrcBook = new OrcBook(Names.OrcBook, textures.book[3]);
	public static final Item Sword = new Swords();
	
	public static final Item ElfBow = new Bow(Names.ElfBow, textures.ElfBow, Ref.ElfTab);
	public static final Item ElfArrow = new Arrow(Names.ElfArrow, textures.ElfArrow, Ref.ElfTab);
	public static final Item ElfAxe = new Axe(Names.ElfAxe, textures.ElfAxe, Ref.ElfTab);
	public static final Item ElfHoe = new Hoe(Names.ElfHoe, textures.ElfHoe, Ref.ElfTab);
	public static final Item ElfPickaxe = new Pickaxe(Names.ElfPickaxe, textures.ElfPickaxe, Ref.ElfTab);
	public static final Item ElfShovel = new Shovel(Names.ElfShovel, textures.ElfShovel, Ref.ElfTab);
	public static final Item ElfSword = new Sword(Names.ElfSword, textures.ElfSword, Ref.ElfTab);
	
	public static final Item OrcBow = new Bow(Names.OrcBow, textures.OrcBow, Ref.OrcTab);
	public static final Item OrcArrow = new Arrow(Names.OrcArrow, textures.OrcArrow, Ref.OrcTab);
	public static final Item OrcAxe = new Axe(Names.OrcAxe, textures.OrcAxe, Ref.OrcTab);
	public static final Item OrcHoe = new Hoe(Names.OrcHoe, textures.OrcHoe, Ref.OrcTab);
	public static final Item OrcHammer = new Pickaxe(Names.OrcHammer, textures.OrcHammer, Ref.OrcTab);
	public static final Item OrcShovel = new Shovel(Names.OrcShovel, textures.OrcShovel, Ref.OrcTab);
	public static final Item OrcSword = new Sword(Names.OrcSword, textures.OrcSword, Ref.OrcTab);
	
	public static final Item DwarfBow = new Bow(Names.DwarfBow, textures.DwarfBow, Ref.DwarfTab);
	public static final Item DwarfArrow = new Arrow(Names.DwarfArrow, textures.DwarfArrow, Ref.DwarfTab);
	public static final Item DwarfAxe = new Axe(Names.DwarfAxe, textures.DwarfAxe, Ref.DwarfTab);
	public static final Item DwarfHoe = new Hoe(Names.DwarfHoe, textures.DwarfHoe, Ref.DwarfTab);
	public static final Item DwarfHammer = new Pickaxe(Names.DwarfHammer, textures.DwarfHammer, Ref.DwarfTab);
	public static final Item DwarfShovel = new Shovel(Names.DwarfShovel, textures.DwarfShovel, Ref.DwarfTab);
	public static final Item DwarfSword = new Sword(Names.DwarfSword, textures.DwarfSword, Ref.DwarfTab);
	
	public static List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		
		items.add(VineMat);
		items.add(Coin);
		items.add(tome);
		items.add(DragonBreathe);
		items.add(Sword);
		
		items.add(HumanBook);
		items.add(DwarfBook);
		items.add(ElfBook);
		items.add(OrcBook);
		
		items.add(DwarfSword);
		items.add(DwarfBow);
		items.add(DwarfArrow);
		items.add(DwarfHammer);
		items.add(DwarfAxe);
		items.add(DwarfShovel);
		items.add(DwarfHoe);
		
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
