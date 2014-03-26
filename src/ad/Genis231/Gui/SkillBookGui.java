package ad.Genis231.Gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import ad.Genis231.lib.textures;

public class SkillBookGui extends GuiScreen {
	int textWidth=180;
	int textHeight=180;
	
	public SkillBookGui(EntityPlayer player, World world) {}
	
	@Override public void drawScreen(int mouseX, int mouseY, float par3) {
		
		this.mc.getTextureManager().bindTexture(textures.SkillBook);
		
		int x = (width - textWidth) / 2;
		int y = (height - textHeight) / 2;
		
		this.drawTexturedModalRect(x, y, 0, 0, 176, 165);
		
		super.drawScreen(mouseX, mouseY, par3);
	}
}
