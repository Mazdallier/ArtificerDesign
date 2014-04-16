package ad.Genis231.Items.Elf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class ElfAxe extends ADItem {
	
	public ElfAxe(String name) {
		super(name, textures.ElfAxe);
		this.setCreativeTab(Ref.ElfTab);
	}
}
