package ad.Genis231.Resources;

import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ADSkillBook extends ADItem{
	protected String mainColor = StringColor.Orange;
	protected String secondaryColor = StringColor.Purple;
	protected IIcon open, closed;

	public ADSkillBook(String name,String Texture){
		super(name,Texture);
		this.setCreativeTab(Ref.MainTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){
		open = icon.registerIcon(textures.BookOpen);
		this.itemIcon = icon.registerIcon(this.getIconString());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses(){
		return true;
	}
}
