package ad.Genis231.Global.Overlay;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import ad.Genis231.Research.Player.PlayerData;
import ad.Genis231.lib.ADItems;
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
		
		this.mc.getTextureManager().bindTexture(textures.ResearchPoints);
		this.drawTexturedModalRect(20, 20, 0, 10, 200-20, 10);
		this.drawTexturedModalRect(20, 20, 0, 0, props.getPoints() % 200, 10);
		font.drawStringWithShadow("Level: " + props.getPoints() / 200 + "      Total Points: " + props.getPoints(), 20, 10, Color.GREEN.getRGB());
		
		ItemStack item = mc.thePlayer.inventory.getStackInSlot(mc.thePlayer.inventory.currentItem);
		
		if (item == null)
			return;
		
		if (item.getItem() == ADItems.tome) {
			font.drawStringWithShadow("Right click give you 20 points", 20, 30, Color.GREEN.getRGB());
			font.drawStringWithShadow("shift-Right click takes away 200 points", 20, 40, Color.GREEN.getRGB());
		}
	}
}
