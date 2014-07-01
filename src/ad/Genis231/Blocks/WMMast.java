package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlockModel;
import ad.Genis231.TileEntity.WMMastTileEntity;

public class WMMast extends ADBlockModel {
	public WMMast(String name) {
		super(Material.rock, name);
		this.setBlockUnbreakable();
		this.setCreativeTab(null);
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return new WMMastTileEntity();
	}
	
	@Override public int getRenderType() {
		return Ref.WMillRender;
	}
}
