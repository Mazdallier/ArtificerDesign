package ad.Genis231.Gui.Resources;

import ad.Genis231.Containers.CoiningContainer;
import ad.Genis231.Containers.DrillContainer;
import ad.Genis231.Gui.CoiningGui;
import ad.Genis231.Gui.DrillGui;
import ad.Genis231.Gui.SkillBookGui;
import ad.Genis231.TileEntity.CoiningTile;
import ad.Genis231.TileEntity.DrillTile;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
	// returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id,EntityPlayer player,World world,int x,int y,int z){
		TileEntity tile = world.getTileEntity(x,y,z);

		switch(id){
			case 1:// Drill
				return new DrillContainer();
			case 2:// Coining Mechine
				return new CoiningContainer(player.inventory,(CoiningTile) tile,world,x,y,z);
			default:
				return null;
		}

	}

	// returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id,EntityPlayer player,World world,int x,int y,int z){
		TileEntity tile = world.getTileEntity(x,y,z);

		switch(id){
			case 1: // Drill
				return new DrillGui((DrillTile) tile);
			case 2:// Coining Mechine
				return new CoiningGui(player.inventory,(CoiningTile) tile,world,x,y,z);
			case 3:
				return new SkillBookGui(player);
			default:
				return null;
		}

	}
}
