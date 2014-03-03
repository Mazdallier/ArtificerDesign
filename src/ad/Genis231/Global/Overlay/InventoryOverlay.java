package ad.Genis231.Global.Overlay;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class InventoryOverlay extends Gui {
	protected Minecraft mc;
	protected FontRenderer font;
	int width, height;
	String name;
	int q = 2;
	ScaledResolution scale;
	
	public InventoryOverlay(Minecraft mc) {
		super();
		this.mc = mc;
		font = this.mc.fontRenderer;
	}
	
	@SubscribeEvent public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.type != ElementType.EXPERIENCE || mc.gameSettings.showDebugInfo) { return; }
		
		scale = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		width = 20;
		height = 10;
		
		if (getBlock() != null) {
			displayItems(getBlock());
		}
	}
	
	void displayItems(TileEntity temp) {
		IInventory block = (IInventory) temp;
		
		block = getInventory() != null ? getInventory() : block;
		
		font.drawString("Displaying le Inventory for a(n) " + StatCollector.translateToLocal(block.getInventoryName()) + ": ", width, height - 10, Color.WHITE.getRGB());
		ItemStack item = null;
		int h = height;
		
		block.openInventory();
		for (int i = 0; i < block.getSizeInventory(); i++) {
			item = block.getStackInSlot(i);
			if (item != null) {
				font.drawStringWithShadow(item.getDisplayName() + "x" + item.stackSize, width, h, Color.WHITE.getRGB());
				System.out.println(item.getDisplayName() + ": " + i);
			} else {
				font.drawStringWithShadow(":( this slot is empty!!!!!", width, h, Color.PINK.getRGB());
			}
			
			if (i >= block.getSizeInventory() / 2 && i > 10) {
				width = scale.getScaledWidth() / 2;
				h = height * (i - (block.getSizeInventory() / 2 - 1));
			} else {
				h = height * (i + 1);
			}
		}
		block.closeInventory();
	}
	
	IInventory getInventory() {
		MovingObjectPosition objectMouseOver = mc.objectMouseOver;
		if (objectMouseOver != null) { return TileEntityHopper.func_145893_b(this.mc.theWorld, objectMouseOver.blockX, objectMouseOver.blockY, objectMouseOver.blockZ); }
		System.out.println("IInventory NULL");
		return null;
	}
	
	TileEntity getBlock() {
		MovingObjectPosition objectMouseOver = mc.objectMouseOver;
		if (objectMouseOver != null) {
			TileEntity block = this.mc.theWorld.getTileEntity(objectMouseOver.blockX, objectMouseOver.blockY, objectMouseOver.blockZ);
			if (block instanceof IInventory) { return block; }
		}
		return null;
	}
}
