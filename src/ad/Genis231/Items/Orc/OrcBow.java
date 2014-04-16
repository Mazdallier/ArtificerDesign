package ad.Genis231.Items.Orc;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class OrcBow extends ADItem{

	public OrcBow(String name){
		super(name,textures.OrcBow);
		this.setCreativeTab(Ref.OrcTab);
	}
}
