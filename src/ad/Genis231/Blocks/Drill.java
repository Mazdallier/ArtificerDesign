package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import ad.Genis231.BaseClasses.ADBlockModel;
import ad.Genis231.Core.Core;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.lib.BlockTexture;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Drill extends ADBlockModel {
	
	public Drill(String name) {
		super(Material.rock, name);
		this.setHardness(5.0F);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		if (player.isSneaking())
			player.openGui(Core.instance, 1, world, x, y, z);
		return false;
	}
	
	@Override public int getRenderType() {
		return Ref.DrillRender;
	}
	
	@Override public TileEntity createNewTileEntity(World world, int unknown) {
		return new DrillTile();
	}
}
