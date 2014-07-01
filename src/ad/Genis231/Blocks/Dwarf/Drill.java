package ad.Genis231.Blocks.Dwarf;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Core.Artificer;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Resources.ADBlockModel;
import ad.Genis231.TileEntity.DrillTileEntity;

public class Drill extends ADBlockModel {
	
	public Drill(String name) {
		super(Material.rock, name);
		this.setHardness(5.0F);
		this.setCreativeTab(Ref.DwarfTab);
	}
	
	@Override public TileEntity createNewTileEntity(World world, int unknown) {
		return new DrillTileEntity();
	}
	
	@Override public int getRenderType() {
		return Ref.DrillRender;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float posX, float posY, float posZ) {
		if (player.isSneaking())
			player.openGui(Artificer.instance, 1, world, x, y, z);
		return false;
	}
}
