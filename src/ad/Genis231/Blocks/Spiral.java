package ad.Genis231.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import ad.Genis231.TileEntitys.SpikeTile;
import ad.Genis231.TileEntitys.SpiralTile;
import ad.Genis231.lib.Ref;

public class Spiral extends BlockContainer {
	
	public Spiral(int id) {
		super(id, Material.iron);
	}
	
	@Override public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override public boolean isOpaqueCube() {
		return false;
	}
	
	@Override public int getRenderType() {
		return Ref.SpiralRender;
	}
	
	@Override public TileEntity createNewTileEntity(World world) {
		return new SpiralTile();
	}
}
