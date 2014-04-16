package ad.Genis231.Items.Orc;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class OrcHoe extends ADItem{

	public OrcHoe(String name){
		super(name,textures.OrcHoe);
		this.setCreativeTab(Ref.OrcTab);
	}
}
