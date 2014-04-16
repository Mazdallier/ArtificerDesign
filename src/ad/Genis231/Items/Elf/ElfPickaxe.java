package ad.Genis231.Items.Elf;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class ElfPickaxe extends ADItem{

	public ElfPickaxe(String name){
		super(name,textures.ElfPickaxe);
		this.setCreativeTab(Ref.ElfTab);
	}
}
