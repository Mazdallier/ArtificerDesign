package ad.Genis231.Global.Overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ClassStats extends Gui {
	protected Minecraft mc;
	
	public ClassStats(Minecraft mc) {
		super();
		this.mc = mc;
		
	}
	
	@SubscribeEvent public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		this.mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 999, 5, true));
		this.mc.thePlayer.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 999, 2, true));
		
		for (int i = 0; i < 2 && this.mc.thePlayer.getDisplayName().toLowerCase() == "xgenis231x"; i++) {
			MinecraftServer.getServer().worldServers[i].setWorldTime(0);
			
			MinecraftServer.getServer().worldServers[i].getWorldInfo().setRainTime(0);
			MinecraftServer.getServer().worldServers[i].getWorldInfo().setThunderTime(0);
			MinecraftServer.getServer().worldServers[i].getWorldInfo().setRaining(false);
			MinecraftServer.getServer().worldServers[i].getWorldInfo().setThundering(false);
		}
	}
}
