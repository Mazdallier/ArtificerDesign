package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlockModel;
import ad.Genis231.TileEntity.WMMastTile;

public class WMTemp extends ADBlockModel {
	public WMTemp(String name) {
		super(Material.rock, name);
		this.setBlockBounds(-1F, -1.0F, -1.0F, 2F, 2F, 2F);
		this.setBlockUnbreakable();
	}
	
	@Override public int getRenderType() {
		return Ref.WMillRender;
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return new WMMastTile();
	}
}
