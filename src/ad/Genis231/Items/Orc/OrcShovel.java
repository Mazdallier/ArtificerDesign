package ad.Genis231.Items.Orc;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class OrcShovel extends ADItem{

	public OrcShovel(String name){
		super(name,textures.OrcShovel);
		this.setCreativeTab(Ref.OrcTab);
	}
}
