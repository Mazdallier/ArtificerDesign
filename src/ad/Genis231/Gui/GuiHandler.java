package ad.Genis231.Gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Containers.ITableContainer;
import ad.Genis231.TileEntity.ITableTile;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    // returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        return tileEntity instanceof ITableTile ? new ITableContainer(player.inventory, (ITableTile) tileEntity, world, x, y, z, world.getBlockId(x, y, z)) : null;
        
    }
    
    // returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        return tileEntity instanceof ITableTile ? new ITableGui(player.inventory, (ITableTile) tileEntity, world, x, y, z, world.getBlockId(x, y, z)) : null;
        
    }
}
