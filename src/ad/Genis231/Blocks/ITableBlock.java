package ad.Genis231.Blocks;

import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.BaseClasses.ADBlockModel;
import ad.Genis231.Core.Core;
import ad.Genis231.TileEntity.model.ITable1;
import ad.Genis231.TileEntity.model.ITable2;
import ad.Genis231.lib.Ref;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ITableBlock extends ADBlockModel {
	
	public ITableBlock(String name) {
		super(Material.rock, name);
		this.setHardness(5.0F);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		if (!world.isRemote)
			player.openGui(Core.instance, 0, world, x, y, z);
		return true;
	}
	
	@Override public int getRenderType() {
		return Ref.TableRender;
	}
	
	@Override public TileEntity createNewTileEntity(World var1, int var2) {
		return this == ADBlock.Itable1 ? new ITable1(3) : new ITable2(4);
	}
}
