package ad.Genis231.Resources;

import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import ad.Genis231.Refrence.Ref;

public class ADTool extends ItemTool {
	/** Basic Constructor
	 * @param name This is the UnlocalizedName */
	public ADTool(String name, float damage, Item.ToolMaterial tool, Set EffBlocks) {
		super(damage, tool, EffBlocks);
		this.setUnlocalizedName(name);
	}
	
	/** Basic Constructor with texture mapping
	 * @param name This is the UnlocalizedName
	 * @param Texture This is the Texture for said item */
	public ADTool(String name, String Texture, float damage, Item.ToolMaterial tool, Set EffBlocks) {
		super(damage, tool, EffBlocks);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Ref.MainTab);
		this.setTextureName(Texture);
	}
	
}
