package ad.Genis231.Items;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;

public class ODust extends Item {
    ODust(int id) {
        super(id);
        setMaxStackSize(64);
        setUnlocalizedName("OrangeDust");
        setTextureName(textures.ODust);
    }
    
    public float Layer = 1000;
    
    private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    
    /* bottom = 0 ~~ top=1 ~~ south = 2 ~~ north = 3 ~~ east = 4 ~~ west = 5 */
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
        System.out.println("~~~~~~~~~~ORANGEDUST~~~~~~~~~~");
        System.out.println("item stack: " + itemStack);
        System.out.println("player: " + player);
        System.out.println("world: " + world.getWorldChunkManager());
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("side: " + side);
        System.out.println("Block-x: " + Bx);
        System.out.println("Block-y: " + By);
        System.out.println("Block-z: " + Bz);
        System.out.println();
        return false;
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase mob, EntityLivingBase player) {
        System.out.println("~~~~~~~~~~ORANGEDUST~~~~~~~~~~");
        System.out.println("Item Stack: " + par1ItemStack);
        System.out.println("mob: " + mob);
        System.out.println("Player: " + player);
        System.out.println();
        return false;
    }
    
    public boolean canItemEditBlocks() {
        return true;
    }
    
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        return item;
    }
    
    private void renderEffect(TextureManager manager, int x, int y) {
        GL11.glDepthFunc(GL11.GL_GREATER);
        GL11.glDisable(GL11.GL_LIGHTING);
        
        GL11.glDepthMask(false);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(RES_ITEM_GLINT);
        
        Layer -= 50.0F;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_DST_COLOR);
        GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
        
        renderGlint(x * 431278612 + y * 32178161, x - 2, y - 2, 20, 20);
        
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        
        Layer += 50.0F;
        
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
    }
    
    private void renderGlint(int x, int y, int z, int u, int v) {
        
        for (int i = 0; i < 2; i++) {
            if (i == 0) GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
            
            if (i == 1) GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
            
            float f = 0.00390625F;
            float f1 = 0.00390625F;
            float f2 = (float) (Minecraft.getSystemTime() % (long) (3000 + i * 1873)) / (3000.0F + (float) (i * 1873)) * 256.0F;
            float f3 = 0.0F;
            Tessellator tessellator = Tessellator.instance;
            float f4 = 4.0F;
            
            if (i == 1) f4 = -1.0F;
            
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV((double) (y + 0), (double) (z + v), (double) Layer, (double) ((f2 + (float) v * f4) * f), (double) ((f3 + (float) v) * f1));
            tessellator.addVertexWithUV((double) (y + u), (double) (z + v), (double) Layer, (double) ((f2 + (float) u + (float) v * f4) * f), (double) ((f3 + (float) v) * f1));
            tessellator.addVertexWithUV((double) (y + u), (double) (z + 0), (double) Layer, (double) ((f2 + (float) u) * f), (double) ((f3 + 0.0F) * f1));
            tessellator.addVertexWithUV((double) (y + 0), (double) (z + 0), (double) Layer, (double) ((f2 + 0.0F) * f), (double) ((f3 + 0.0F) * f1));
            tessellator.draw();
        }
    }
}
