package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.TileEntity.DrillTile;

public class CoiningMechine extends ADTile {
	
	
	public CoiningMechine(String name,String texture) {
		super(Material.rock, name,texture);
		// TODO Auto-generated constructor stub
	}

	@Override public TileEntity createNewTileEntity(World world, int unknown) {
		return new DrillTile();
	}
	
}
