package ad.Genis231.Global.Overlay;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
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
		font = this.mc.fontRenderer;
	}
	
	// Draws the gui every frame or so
	@SubscribeEvent public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE || mc.gameSettings.showDebugInfo) { return; }
		
		scale = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		width = 20;
		height = 10;
		
		if (getInventory() != null) {
			displayItems(getInventory());
		}
	}
	
	// displays all the items in the Inventory
	void displayItems(IInventory block) {
		
		font.drawString("Displaying Inventory for block " + StatCollector.translateToLocal(block.getInventoryName()) + ": ", width + 10, height - 10, Color.WHITE.getRGB());
		int h = height;
		
		block.openInventory();
		// cycles through all the slots for the inventory
		for (int i = 0; i < block.getSizeInventory(); i++) {
			ItemStack item = block.getStackInSlot(i);
			
			// just for drawing!!
			if (i >= (block.getSizeInventory() / 2) + 1 && i > 12) {
				width = (scale.getScaledWidth() / 4) + 40;
				h = height * (i - (block.getSizeInventory() / 2));
			} else {
				h = height * (i + 1);
			}
			
			// displaying items
			if (item != null) {
				font.drawStringWithShadow(item.getDisplayName() + "x" + item.stackSize, width, h, Color.WHITE.getRGB());
			} else {
				font.drawStringWithShadow(":( this slot is empty! " + i, width, h, Color.PINK.getRGB());
			}
		}
		block.closeInventory();
	}
	
	// gets the inventory from TileEntityHopper's getInventory method
	IInventory getInventory() {
		MovingObjectPosition objectMouseOver = this.mc.objectMouseOver;
		if (objectMouseOver != null) { return TileEntityHopper.func_145893_b(this.mc.theWorld, objectMouseOver.blockX, objectMouseOver.blockY, objectMouseOver.blockZ); }
		return null;
	}
}
