package ad.Genis231.Global.Overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class ClassStats extends Gui {
	protected Minecraft mc;
	
	public ClassStats(Minecraft mc) {
		super();
		this.mc = mc;
		
	}
	
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		this.mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 99999, 5, true));
		this.mc.thePlayer.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 99999, 2, true));
	}
}
