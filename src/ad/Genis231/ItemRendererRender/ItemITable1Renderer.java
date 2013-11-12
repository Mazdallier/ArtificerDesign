package ad.Genis231.ItemRendererRender;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Block.Renderer.ITableHelper;
import ad.Genis231.Block.Renderer.ITableRenderer1;
import ad.Genis231.Render.Models.Blocks.ITable1Model;
import ad.Genis231.lib.textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemITable1Renderer implements IItemRenderer {
    private ITable1Model Itable;
    
    public ItemITable1Renderer() {
        Itable = new ITable1Model();
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
        
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        
        // Scale, Translate, Rotate
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(0F, 1F, 0, 0);
        
        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.ITable);
        
        // Render
        Itable.renderPart(0);
        Itable.renderPart(1);
        //Itable.renderAll();
        
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        
    }
}
