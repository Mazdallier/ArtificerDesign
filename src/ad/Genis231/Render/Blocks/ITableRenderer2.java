package ad.Genis231.Render.Blocks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Render.Models.Blocks.ITable2Model;
import ad.Genis231.Render.TileEntity.ITable2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ITableRenderer2 extends TileEntitySpecialRenderer {
    
    private static ITable2Model ITableModel = new ITable2Model();
    public static long speed = ITableRenderer1.speed;
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        
        if (tileEntity instanceof ITable2) {
            float rotation = (float) (360.0 * (System.currentTimeMillis() & speed) / speed);
            
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_CULL_FACE);
                        
            block(x, y, z, 1.0F);
            circle(x, y, z, 1.0F, rotation, 1);
            circle(x, y, z, 1.0F, -rotation, 2);
                        
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_LIGHTING);
        }
    }
    
    public static void block(double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        
        ITableHelper.block(x, y, z, scale);
        
        // Render
        ITableModel.renderPart(0);
        GL11.glPopMatrix();
    }
    
    public static void circle(double x, double y, double z, float scale, float rotate, int part) {
        GL11.glPushMatrix();
        
        ITableHelper.Circle(x, y, z, scale, rotate);
        
        // Render
        ITableModel.renderPart(part);
        GL11.glPopMatrix();
    }
}
