package ad.Genis231.Items.Orc;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADItem;

public class OrcHammer extends ADItem{

	public OrcHammer(String name){
		super(name,textures.OrcHammer);
		this.setCreativeTab(Ref.OrcTab);
	}
}
