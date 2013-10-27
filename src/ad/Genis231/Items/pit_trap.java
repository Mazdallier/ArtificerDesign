package ad.Genis231.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ad.Genis231.Blocks.PTBlock;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.lib.Ref;

public class pit_trap extends Item {
    
    public pit_trap(int id) {
        super(id);
        setUnlocalizedName("pit_trap");
    }
    
    /** item ~~ player ~~ world ~~ x ~~ y ~~ z ~~ side ~~ south = 2 ~~ north = 3 ~~ east = 4 ~~ west = 5 **/
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float Bx, float By, float Bz) {
        switch (side) {
            case 2:// z-1
                range(world, player, x, y, z - 1);
                return true;
            case 3:// z+1
                range(world, player, x, y, z + 1);
                return true;
            case 4:// x-1
                range(world, player, x - 1, y, z);
                return true;
            case 5:// x+1
                range(world, player, x + 1, y, z);
                return true;
        }
        return true;
    }
    
    void range(World world, EntityPlayer player, int x, int y, int z) {
        int mx = x, mX = x, mz = z, mZ = z, max = 8;
        
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
            if (CheckArea(world, mx, y, mz, mX, mZ) && CheckBorder(world, mx, y, mz, mX, mZ)) blocks.fill(world, mx, y, mz, mX, y, mZ, blocks.FPTrap.blockID, true);
            PTBlock.toggle = true;
        }
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
}
