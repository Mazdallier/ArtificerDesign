package ad.Genis231.Gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Iterator;

/**
 * Created by Genis on 2/25/14.
 */
public class DrillGui extends GuiScreen{

	public DrillGui(EntityPlayer player,World world,int x,int y,int z){
	}

	@Override
	public void initGui(){

		this.buttonList.clear();

		this.buttonList.add(new GuiButton(0,this.width / 2,this.height / 2,"ROAR"));
		GuiButton guibutton;
		for(Iterator iterator = this.buttonList.iterator(); iterator.hasNext(); guibutton.enabled = false){
			guibutton = (GuiButton) iterator.next();
		}
	}

	@Override
	public void drawScreen(int x,int y,float par3){


		this.mc.fontRenderer.drawStringWithShadow("BLAH!!!!!",this.width / 2-20,this.height / 2-20,0xFFFFF);

	}
}
