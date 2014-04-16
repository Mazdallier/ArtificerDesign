package ad.Genis231.Items.Elf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class ElfHoe extends ADItem {
	
	public ElfHoe(String name) {
		super(name, textures.ElfHoe);
		this.setCreativeTab(Ref.ElfTab);
	}
}
