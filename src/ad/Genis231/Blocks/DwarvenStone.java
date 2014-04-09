package ad.Genis231.Blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADBlock;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(String name, String texture) {
		super(Material.rock, name, texture);
		setHardness(10.0f);
	}
	
	@Override public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float posX, float posY, float posZ) {
		return false;
	}
	
	public void setBlockBoundsForItemRender() {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	// public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
	// if (!world.isRemote)
	// System.out.println(entity);
	//
	// super.onEntityCollidedWithBlock(world, x, y, z, entity);
	// }
	
	@SideOnly(Side.CLIENT) public void registerBlockIcons(IIconRegister iconReg) {
		this.blockIcon = iconReg.registerIcon(this.getTextureName());
	}
	
	public int getRenderType() {
		return Ref.DwarvenRender;
	}
	
	@SuppressWarnings("rawtypes") @Override public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity collingEntity) {
		float size = 0.0125f / 2;
		
		this.setBlockBounds(0, 0, 0, 0, size, 1);
		super.addCollisionBoxesToList(world, x, y, z, mask, list, collingEntity);
		
		if (world.getBlock(x + 1, y, z) != this) {
			this.setBlockBounds(0, 0, 0, size, 1, 1);
			super.addCollisionBoxesToList(world, x, y, z, mask, list, collingEntity);
		}
		
		if (world.getBlock(x - 1, y, z) != this) {
			this.setBlockBounds(1 - size, 0, 0, 1, 1, 1);
			super.addCollisionBoxesToList(world, x, y, z, mask, list, collingEntity);
		}
		
		if (world.getBlock(x, y, z + 1) != this) {
			this.setBlockBounds(0, 0, 0, 1, 1, size);
			super.addCollisionBoxesToList(world, x, y, z, mask, list, collingEntity);
		}
		
		if (world.getBlock(x, y, z - 1) != this) {
			this.setBlockBounds(1 - size, 0, 0, 1, 1, 1);
			super.addCollisionBoxesToList(world, x, y, z, mask, list, collingEntity);
		}
		
		this.setBlockBoundsForItemRender();
	}
}
