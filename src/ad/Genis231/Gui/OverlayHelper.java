package ad.Genis231.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import ad.Genis231.lib.Ref;

public class OverlayHelper extends Gui {
	protected Minecraft mc;
	protected FontRenderer font;
	
	public OverlayHelper(Minecraft mc) {
		super();
		this.mc = mc;
		font = this.mc.fontRenderer;
	}
	
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE || mc.gameSettings.showDebugInfo) { return; }
		
		// TODO All the shit that needs to be rendered!!!!
		
		font.drawStringWithShadow("Mod Version: " + Ref.MOD_VERSION, 5, 5, 16777215);
		font.drawStringWithShadow("Hello Player: " + mc.thePlayer.username, 5, 15, 16777215);
		font.drawStringWithShadow(":D i got this overlay to work!!!", 5, 25, 16777215);
	}
}
