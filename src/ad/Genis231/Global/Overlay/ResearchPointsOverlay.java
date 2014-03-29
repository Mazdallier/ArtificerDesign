package ad.Genis231.Global.Overlay;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import ad.Genis231.Player.PlayerData;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.lib.textures;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ResearchPointsOverlay extends Gui {
	protected Minecraft mc;
	FontRenderer font;
	
	public ResearchPointsOverlay(Minecraft mc) {
		super();
		this.mc = mc;
		this.font = mc.fontRenderer;
	}
	
	@SubscribeEvent public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE || mc.gameSettings.showDebugInfo) { return; }
		
		PlayerData props = PlayerData.get(mc.thePlayer);
		
		if (props == null) { return; }
		
		drawStatus(props, props.getRace());
		//applyAtribbute(props.getRace());
	}
	
	public void drawStatus(PlayerData data, PlayerRace race) {
		this.mc.getTextureManager().bindTexture(textures.ResearchPoints);
		this.drawTexturedModalRect(20, 20, 0, 10, 200 - 20, 10);
		this.drawTexturedModalRect(20, 20, 0, 0, data.getPoints() % 200, 10);
		font.drawStringWithShadow("Level: " + data.getPoints() / 200 + "      Total Points: " + data.getPoints(), 20, 10, Color.GREEN.getRGB());
		
		font.drawString("Current Class: " + race.getName(), 20, 30, Color.RED.getRGB());
	}
	
	void applyAtribbute(PlayerRace race) {
		for (int size = 0; size < 65; size++) {
			for (int meta = 0; meta < 16; meta++) {
				this.mc.thePlayer.curePotionEffects(new ItemStack(Items.milk_bucket, size, meta));
			}
		}
		
		if (race != PlayerRace.HUMAN) {
			this.mc.thePlayer.addPotionEffect(new PotionEffect(race.getPot1(), 200, race.getLevel()));
			this.mc.thePlayer.addPotionEffect(new PotionEffect(race.getPot2(), 200, race.getLevel()));
		}
		
	}
}
