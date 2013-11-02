package ad.Genis231.Gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.Containers.ITableContainer;
import ad.Genis231.TileEntitys.ITableTile;

public class ITableGui extends GuiContainer {
    int blockid;
    
    public ITableGui(InventoryPlayer inventoryPlayer, ITableTile tileEntity, World world, int x, int y, int z, int block) {
        // the container is instantiated and passed to the superclass for handling
        super(new ITableContainer(inventoryPlayer, tileEntity, world, x, y, z, block));
        blockid = block;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        // the parameters for drawString are: string, x, y, color
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        ResourceLocation t1 = new ResourceLocation("artificer", "textures/gui/ITable1.png");
        ResourceLocation t2 = new ResourceLocation("artificer", "textures/gui/ITable2.png");
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(blockid == blocks.ItableT1.blockID ? t1 : t2);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
    
}
