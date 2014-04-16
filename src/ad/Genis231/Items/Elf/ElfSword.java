package ad.Genis231.Items.Elf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class ElfSword extends ADItem {
	
	public ElfSword(String name) {
		super(name, textures.ElfSword);
		this.setCreativeTab(Ref.ElfTab);
	}
}
