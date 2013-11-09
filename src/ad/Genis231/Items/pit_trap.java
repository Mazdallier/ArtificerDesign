package ad.Genis231.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ad.Genis231.Blocks.PTBlock;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.lib.textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class pit_trap extends Item {
    
    public pit_trap(int id) {
        super(id);
        setHasSubtypes(true);
        setUnlocalizedName("pit_trap");
    }
    
    @SideOnly(Side.CLIENT)
    public static Icon[] IconArray = new Icon[9];
    public static final String[] UnlocalizedArray = { "Dirt Teir 1", "Sand Teir 1", "Stone Teir 1", "Dirt Teir 2", "Sand Teir 2", "Stone Teir 2", "Dirt Teir 3", "Sand Teir 3", "Stone Teir 3" };
    
    /** item ~~ player ~~ world ~~ x ~~ y ~~ z ~~ side ~~ south = 2 ~~ north = 3 ~~ east = 4 ~~ west = 5 */
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
        switch (side) {
            case 2:// z-1
                range(world, player, x, y, z - 1, item);
                return true;
            case 3:// z+1
                range(world, player, x, y, z + 1, item);
                return true;
            case 4:// x-1
                range(world, player, x - 1, y, z, item);
                return true;
            case 5:// x+1
                range(world, player, x + 1, y, z, item);
                return true;
        }
        return true;
    }
    
    public void getSubItems(int ID, CreativeTabs CreativeTabs, List ItemList) {
        for (int i = 0; i < 9; i++) {
            ItemList.add(new ItemStack(ID, 1, i));
        }
    }
    
    int getRange(ItemStack item) {
        if (item.getItemDamage() < 3) return 6;
        else if (item.getItemDamage() < 6) return 12;
        else return 18;
    }
    
    void range(World world, EntityPlayer player, int x, int y, int z, ItemStack item) {
        int mx = x, mX = x, mz = z, mZ = z, max = getRange(item);
        
        for (int i = 0; i <= max * 2; i++) {
            mx = world.getBlockId(mx - 1, y, z) == 0 ? x - i : mx;
            mX = world.getBlockId(mX + 1, y, z) == 0 ? x + i : mX;
            mz = world.getBlockId(x, y, mz - 1) == 0 ? z - i : mz;
            mZ = world.getBlockId(x, y, mZ + 1) == 0 ? z + i : mZ;
        }
        
        int dimX = mx - mX;
        int dimZ = mz - mZ;
        
        if (Math.abs(dimX) <= max && Math.abs(dimZ) <= max) {
            PTBlock.toggle = false;
            if (CheckArea(world, mx, y, mz, mX, mZ) && CheckBorder(world, mx, y, mz, mX, mZ)) blocks.fill(world, mx, y, mz, mX, y, mZ, blocks.FPTrap.blockID, getMeta(item), true);
            PTBlock.toggle = true;
        }
    }
    
    @Override
    public int getMetadata(int damageValue) {
        return damageValue;
    }
    
    private int getMeta(ItemStack item) {
        System.out.println(item.getItemDamage() % 3);
        return item.getItemDamage() % 3;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return "Pit Trap " + UnlocalizedArray[itemstack.getItemDamage()];
    }
    
    public static boolean CheckArea(World world, int mx, int y, int mz, int mX, int mZ) {
        int x, z, X, Z, i = 0;
        
        x = mx <= mX ? mx : mX;
        X = mx <= mX ? mX : mx;
        
        z = mz <= mZ ? mz : mZ;
        Z = mz <= mZ ? mZ : mz;
        
        for (int q = x; q <= X; q++) {
            for (int w = z; w <= Z; w++) {
                if (world.getBlockId(q, y - 1, w) != 0 || world.getBlockId(q, y + 1, w) != 0) i++;
                if (world.getBlockId(q, y, w) != 0 && world.getBlockId(q, y, w) != blocks.FPTrap.blockID) i++;
            }
        }
        if (i != 0) System.out.println("CheckArea: " + i);
        return i == 0;
    }
    
    public static boolean CheckBorder(World world, int mx, int y, int mz, int mX, int mZ) {
        int x, z, X, Z, i = 0;
        
        x = mx <= mX ? mx : mX;
        X = mx <= mX ? mX : mx;
        
        z = mz <= mZ ? mz : mZ;
        Z = mz <= mZ ? mZ : mz;
        
        for (int minx = x; minx <= X; minx++) {
            if (world.getBlockId(minx, y, z - 1) == 0) i++;
            if (world.getBlockId(minx, y, Z + 1) == 0) i++;
        }
        for (int minz = z; minz <= Z; minz++) {
            if (world.getBlockId(x - 1, y, minz) == 0) i++;
            if (world.getBlockId(X + 1, y, minz) == 0) i++;
        }
        if (i != 0) System.out.println("CheckBorder: " + i);
        return i == 0;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon) {
        for (int i = 0; i < IconArray.length; i++) {
            IconArray[i] = icon.registerIcon("artificer:Pit_Trap/" + textures.PitTrapArray[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {
        int index = MathHelper.clamp_int(meta, 0, 8);
        return IconArray[index];
    }
}
