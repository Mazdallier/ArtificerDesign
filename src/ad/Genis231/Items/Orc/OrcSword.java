package ad.Genis231.Items.Orc;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class OrcSword extends ADItem{

	public OrcSword(String name){
		super(name,textures.OrcSword);
		this.setCreativeTab(Ref.OrcTab);
	}
}
