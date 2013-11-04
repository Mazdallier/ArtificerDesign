package ad.Genis231.TileEntitys;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ad.Genis231.Render.Models.Blocks.ITable2Model;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ITableRanderer2 extends TileEntitySpecialRenderer {
    
    private ITable2Model ITableModel = new ITable2Model();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        
        if (tileEntity instanceof ITable2) {
            
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_CULL_FACE);
            
            GL11.glPushMatrix();
            
            // Scale, Translate, Rotate
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);
            
            // Bind texture
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("artificer", ""));
            
            // Render
            ITableModel.render();
            GL11.glPopMatrix();
            
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_LIGHTING);
        }
    }
}
