package ad.Genis231.Items.Orc;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class OrcAxe extends ADItem{

	public OrcAxe(String name){
		super(name,textures.OrcAxe);
		this.setCreativeTab(Ref.OrcTab);
	}
}
