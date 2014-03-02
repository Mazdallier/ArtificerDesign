package ad.Genis231.Gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/** Created by Genis on 2/25/14. */
public class DrillGui extends GuiScreen {
	
	public DrillGui(EntityPlayer player, World world, int x, int y, int z) {}
	
	@Override public void drawScreen(int x, int y, float par3) {
		this.mc.fontRenderer.drawStringWithShadow("BLAH!!!!!", this.width / 2 - 20, this.height / 2 - 20, 0xFFFFF);
		
	}
}
