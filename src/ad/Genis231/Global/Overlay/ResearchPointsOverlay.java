package ad.Genis231.Global.Overlay;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Research.Player.PlayerData;
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
		
		GL11.glPushMatrix();
		{
			this.mc.getTextureManager().bindTexture(textures.ResearchPoints);
			this.drawTexturedModalRect(20, 20, 0, 10, 200, 10);
			this.drawTexturedModalRect(20, 20, 0, 0, props.getPoints()%200, 10);
			font.drawStringWithShadow("Level: "+(int)props.getPoints()/200, 20, 10, Color.GREEN.getRGB());
		}
		GL11.glPopMatrix();
	}
}
