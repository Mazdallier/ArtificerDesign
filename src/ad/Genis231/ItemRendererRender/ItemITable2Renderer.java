package ad.Genis231.ItemRendererRender;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Block.Renderer.ITableHelper;
import ad.Genis231.Block.Renderer.ITableRenderer2;
import ad.Genis231.Render.Models.Blocks.ITable2Model;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemITable2Renderer implements IItemRenderer {
    ITableRenderer2 Table;
    
    float rotation = (float) (360.0 * (System.currentTimeMillis() & Table.speed) / Table.speed);
    
    private ITable2Model Itable;
    
    public ItemITable2Renderer() {
        Itable = new ITable2Model();
    }
    
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }
    
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }
    
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        
        switch (type) {
            case ENTITY:
                renderTable(-1F, 0.0F, 1F, 2F);
                return;
                
            case EQUIPPED:
                renderTable(0.5F, 0.2F, 1F, 1.5F);
                return;
                
            case EQUIPPED_FIRST_PERSON:
                renderTable(0.5F, 0.7F, 1.5F, 1F);
                return;
                
            case INVENTORY:
                renderTable(0.5F, 0.1F, 1.5F, 1.1F);
                return;
        }
    }
    
    private void renderTable(float x, float y, float z, float scale) {
        for (int i = 0; i < 3; i++) {
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);
            
            // Render
            switch (i) {
                case 0:
                    ITableHelper.block(x, y, z, scale);
                case 1:
                    ITableHelper.Circle(x, y, z, scale, rotation);
                case 2:
                    ITableHelper.Circle(x, y, z, scale, rotation * -1);
            }
            
            Itable.renderPart(i);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }
    }
}
