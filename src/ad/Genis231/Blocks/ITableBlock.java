package ad.Genis231.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Core.Core;
import ad.Genis231.TileEntity.Models.ITable1;
import ad.Genis231.TileEntity.Models.ITable2;
import ad.Genis231.lib.Ref;

public class ITableBlock extends ADBlockModel {
    
    protected ITableBlock(int id,String name) {
        super(id, Material.rock,name);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
        if (!world.isRemote) player.openGui(Core.instance, 0, world, x, y, z);
        return true;
    }
    
    @Override
	public int getRenderType() {
		return Ref.TableRender;
	}
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return this == ADBlock.ItableT1 ? new ITable1(3) : new ITable2(4);
    }
    
}
