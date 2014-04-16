package ad.Genis231.Items.Elf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class ElfBow extends ADItem {
	
	public ElfBow(String name) {
		super(name, textures.ElfBow);
		this.setCreativeTab(Ref.ElfTab);
	}
}
