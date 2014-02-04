package ad.Genis231.Blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class false_loot extends ADBlock {
    
    public static Icon Coal, Gold, Lapis, Diamond, Emerald, Iron, Redstone;
    public static Icon[] blockIcons = { Coal, Gold, Lapis, Diamond, Emerald, Iron, Redstone };
    public static String[] BlockTextures = { "coal_block", "gold_block", "lapis_block", "diamond_block", "emerald_block", "iron_block", "redstone_block" };
    
    public false_loot(int id,String name) {
        super(id, Material.rock,name);
        setHardness(-1.0F);
    }
    
    public int idDropped() {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs CreativeTab, List ItemList) {
        for (int i = 0; i <= 6; i++) {
            ItemList.add(new ItemStack(par1, 1, i));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon) {
        for (int i = 0; i < blockIcons.length; i++)
            blockIcons[i] = icon.registerIcon(BlockTextures[i]);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return blockIcons[meta];
    }
}
