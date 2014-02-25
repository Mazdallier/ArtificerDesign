package ad.Genis231.Global.Overlay;

import ad.Genis231.lib.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;

public class OverlayHelper extends Gui {
	protected Minecraft mc;
	protected FontRenderer font;
	int size = 14;
	int image;
	int text;
	String name;
	
	public OverlayHelper(Minecraft mc) {
		super();
		this.mc = mc;
		font = this.mc.fontRenderer;
		
	}
	
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE || mc.gameSettings.showDebugInfo) { return; }
		
		int q = 1;
		
		ScaledResolution scale = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		text = scale.getScaledWidth() - 150;
		
		GL11.glPushMatrix();
		{
			for (int i = 0; i < 9; i++) {
				if (mc.thePlayer.inventory.getStackInSlot(i) != null) {
					name = " " + mc.thePlayer.inventory.getStackInSlot(i).getDisplayName();
					
					if (mc.thePlayer.inventory.currentItem == i)
						font.drawString("Current Item: " + name, 5, (q * 10) - 5, 16711680);
					else
						font.drawString("Item in Slot " + (i + 1) + ": " + name, 5, (q * 10) - 5, 852223);
					
					q++;
				}
			}
			
			if (q <= 1)
				font.drawStringWithShadow("Add Items to your Inventory!! :D", 5, 5, 16777215);
			
			font.drawStringWithShadow("Mod Version: " + Ref.MOD_VERSION, text + 30, 5, 16777215);
			font.drawStringWithShadow("Hello Player: " + mc.thePlayer.getDisplayName(), text + 23, 15, 16777215);
		}
		GL11.glPopMatrix();
	}
}
