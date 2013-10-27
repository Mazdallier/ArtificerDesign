package ad.Genis231.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class PTBlock extends Block {
    
    public static boolean toggle = true;
    
    public PTBlock(int id) {
        super(id, Material.rock);
        setTextureName("sand");
        setHardness(-1);
    }
    
    public void onEntityWalking(World world, int x, int y, int z, Entity player) {
        if (!player.isSneaking()) world.destroyBlock(x, y, z, false);
        super.onEntityWalking(world, x, y, z, player);
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, int neighbor) {
        if (toggle) {
            if (check(world, x, y, z)) {
                world.destroyBlock(x, y, z, false);
            }
        }
    }
    
    public int idDropped(int par1, Random par2Random, int par3) {
        return 0;
    }
    
    public static boolean check(World world, int x, int y, int z) {
        if (world.getBlockId(x - 1, y, z) == 0 || world.getBlockId(x + 1, y, z) == 0 || world.getBlockId(x, y, z - 1) == 0 || world.getBlockId(x, y, z + 1) == 0) return true;
        else return false;
    }
}
