package ad.Genis231.Items.Orc;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class OrcArrow extends ADItem{

	public OrcArrow(String name){
		super(name,textures.OrcArrow);
		this.setCreativeTab(Ref.OrcTab);
	}
}
