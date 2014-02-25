package ad.Genis231.Gui;

import ad.Genis231.Containers.ITableContainer;
import ad.Genis231.TileEntity.ITableTile;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
	// returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id,EntityPlayer player,World world,int x,int y,int z){
		TileEntity tileEntity = world.getTileEntity(x,y,z);

		switch(id){
			case 0:
				return new ITableContainer(player.inventory,(ITableTile) tileEntity,world,x,y,z,world.getBlock(x,y,z));
			default:
				return null;
		}

	}

	// returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id,EntityPlayer player,World world,int x,int y,int z){
		TileEntity tileEntity = world.getTileEntity(x,y,z);

		switch(id){
			case 0:
				return new ITableGui(player.inventory,(ITableTile) tileEntity,world,x,y,z,world.getBlock(x,y,z));
			case 1:
				return new VineMatGUI(player,world,x,y,z);
			case 2:
				return new DrillGui(player,world,x,y,z);
			default:
				return null;
		}

	}
}
