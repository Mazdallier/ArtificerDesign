package ad.Genis231.Global.Overlay;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
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
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		this.mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 999, 5, true));
		this.mc.thePlayer.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 999, 2, true));
	}
}
