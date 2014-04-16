package ad.Genis231.Items.Elf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class ElfShovel extends ADItem {
	
	public ElfShovel(String name) {
		super(name, textures.ElfShovel);
		this.setCreativeTab(Ref.ElfTab);
	}
}
