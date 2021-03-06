package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Core.Artificer;
import ad.Genis231.Resources.ADBlockTile;
import ad.Genis231.TileEntity.CoiningTileEntity;

public class CoiningMechine extends ADBlockTile {
	
	public CoiningMechine(String name, String texture) {
		super(Material.rock, name, texture);
	}
	
	@Override public TileEntity createNewTileEntity(World world, int unknown) {
		return new CoiningTileEntity();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		player.openGui(Artificer.instance, 2, world, x, y, z);
		return true;
	}
	
}
