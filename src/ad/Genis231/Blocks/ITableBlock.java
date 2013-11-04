package ad.Genis231.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ad.Genis231.Core.Core;
import ad.Genis231.TileEntitys.ITable1;
import ad.Genis231.TileEntitys.ITable2;
import ad.Genis231.TileEntitys.ITableTile;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ITableBlock extends BlockContainer {
    
    protected ITableBlock(int id) {
        super(id, Material.rock);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
        if (!world.isRemote) player.openGui(Core.instance, 0, world, x, y, z);
        return true;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public int getRenderType() {
        return this == blocks.ItableT1 ? Ref.Table1Render : Ref.Table2Render;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return this == blocks.ItableT1 ? new ITable1(2) : new ITable2(3);
    }
    
}
