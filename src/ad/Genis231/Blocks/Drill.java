package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADBlockModel;
import ad.Genis231.Core.Artificer;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.lib.Ref;

public class Drill extends ADBlockModel {
	
	public Drill(String name) {
		super(Material.rock, name);
		this.setHardness(5.0F);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float posX, float posY, float posZ) {
		if (player.isSneaking())
			player.openGui(Artificer.instance, 1, world, x, y, z);
		return false;
	}
	
	@Override public int getRenderType() {
		return Ref.DrillRender;
	}
	
	@Override public TileEntity createNewTileEntity(World world, int unknown) {
		return new DrillTile();
	}
}
