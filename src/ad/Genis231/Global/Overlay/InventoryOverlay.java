package ad.Genis231.Global.Overlay;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import ad.Genis231.Core.Resources.InventoryHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

//@SideOnly(Side.CLIENT) 
public class InventoryOverlay extends Gui {
	protected Minecraft mc;
	protected FontRenderer font;
	int width, height;
	ScaledResolution scale;
	
	public InventoryOverlay(Minecraft mc) {
		super();
		this.mc = mc;
		this.font = this.mc.fontRenderer;
	}
	
	@SubscribeEvent public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE || mc.gameSettings.showDebugInfo) { return; }
		
		scale = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		width = 20;
		height = 10;
		
		RenderItems(InventoryHelper.getInventory());
	}
	
	private void RenderItems(IInventory inv) {
		if (inv == null)
			return;
		
		inv.openInventory();
		font.drawStringWithShadow("BLAH!!!!", width, height - 10, Color.CYAN.getRGB());
		
		for (int i = 0; i < inv.getSizeInventory() && i<font.FONT_HEIGHT; i++) {
			if (InventoryHelper.getItem(inv, i) != null) {
				font.drawStringWithShadow("Item in Slot: " + InventoryHelper.getItem(inv, i), width, height * (i+1), Color.BLUE.getRGB());
			} else {
				font.drawStringWithShadow("ERROR!!! " + i, width, height * (i+1), Color.GREEN.getRGB());
			}
		}
	}
}
