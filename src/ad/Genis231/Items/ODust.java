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
import ad.Genis231.lib.ADLog;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.textures;

public class ODust extends ADItem {
    ODust(int id,String name) {
        super(id,name);
        setMaxStackSize(64);
        setUnlocalizedName("OrangeDust");
        setTextureName(textures.ODust);
    }
    
    /* bottom = 0 ~~ top=1 ~~ south = 2 ~~ north = 3 ~~ east = 4 ~~ west = 5 */
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
        if (world.isRemote) {
            ADLog.logger.info("~~~~~~~~~~ORANGEDUST~~~~~~~~~~");
            ADLog.logger.info("item stack: " + itemStack);
            ADLog.logger.info("player: " + player);
            ADLog.logger.info("world: " + world.getWorldChunkManager());
            ADLog.logger.info("x: " + x);
            ADLog.logger.info("y: " + y);
            ADLog.logger.info("z: " + z);
            ADLog.logger.info("side: " + side);
            ADLog.logger.info("Block-x: " + Bx);
            ADLog.logger.info("Block-y: " + By);
            ADLog.logger.info("Block-z: " + Bz);
            ADLog.logger.info("\n");
        }
        return false;
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase mob, EntityLivingBase player) {
        ADLog.logger.info("~~~~~~~~~~ORANGEDUST~~~~~~~~~~");
        ADLog.logger.info("Item Stack: " + par1ItemStack);
        ADLog.logger.info("mob: " + mob);
        ADLog.logger.info("Player: " + player);
        ADLog.logger.info("\n");
        return false;
    }
    
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        return item;
    }
  }
