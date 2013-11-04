package ad.Genis231.ItemRendererRender;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import ad.Genis231.Render.Models.Blocks.ITable1Model;
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
                renderSpikes(-0.5F, 0.0F, 0.5F, 2F);
                return;
                
            case EQUIPPED:
                renderSpikes(0.0F, 0.2F, 0.5F, 1.5F);
                return;
                
            case EQUIPPED_FIRST_PERSON:
                renderSpikes(0.0F, 0.7F, 1.0F, 1F);
                return;
                
            case INVENTORY:
                renderSpikes(0.0F, 0.1F, 1.0F, 1.1F);
                return;
        }
    }
    
    private void renderSpikes(float x, float y, float z, float size) {
        
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        
        // Scale, Translate, Rotate
        GL11.glScalef(size, size, size);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(0F, 1F, 0, 0);
        
        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("artificer", ""));
        
        // Render
        Itable.render();
        
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
