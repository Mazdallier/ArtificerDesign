package ad.Genis231.BaseClass;

import ad.Genis231.lib.Ref;
import ad.Genis231.lib.StringColor;

public class ADSkillBook extends ADItem {
	protected String mainColor = StringColor.Orange;
	protected String secondaryColor = StringColor.Purple;
	
	public ADSkillBook(String name, String Texture) {
		super(name, Texture);
		this.setCreativeTab(Ref.MainTab);
	}
}
