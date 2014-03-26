package ad.Genis231.BaseClass;

import ad.Genis231.lib.Ref;

public class ADSkillBook extends ADItem{

	public ADSkillBook(String name, String Texture) {
		super(name, Texture);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(Ref.BookTab);
	}
	
}
