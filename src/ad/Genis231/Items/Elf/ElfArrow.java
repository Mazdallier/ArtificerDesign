package ad.Genis231.Items.Elf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class ElfArrow extends ADItem {
	
	public ElfArrow(String name) {
		super(name, textures.ElfArrow);
		this.setCreativeTab(Ref.ElfTab);
	}
}
