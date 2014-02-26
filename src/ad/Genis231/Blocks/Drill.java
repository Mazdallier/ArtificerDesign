package ad.Genis231.Blocks;

import ad.Genis231.BaseClasses.ADBlockModel;
import ad.Genis231.Core.Core;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.lib.BlockTexture;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class Drill extends ADBlockModel{

	@SideOnly(Side.CLIENT)
	public static IIcon oddSideIcon;
	@SideOnly(Side.CLIENT)
	public static IIcon evenSideIcon;
	@SideOnly(Side.CLIENT)
	public static IIcon topIcon;
	@SideOnly(Side.CLIENT)
	public static IIcon botIcon;
	Random r = new Random(10);

	public Drill(String name){
		super(Material.rock,name);
		this.setHardness(5.0F);
	}

	public boolean onBlockActivated(World world,int x,int y,int z,EntityPlayer player,int metadata,float what,float these,float are){
		if(player.isSneaking())player.openGui(Core.instance,2,world,x,y,z);
		return false;
	}

	@Override
	public boolean renderAsNormalBlock(){
		return true;
	}

	@Override
	public boolean isOpaqueCube(){
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		evenSideIcon = icon.registerIcon(BlockTexture.Drill[0]);
		oddSideIcon = icon.registerIcon(BlockTexture.Drill[1]);
		topIcon = icon.registerIcon(BlockTexture.Drill[2]);
		botIcon = icon.registerIcon(BlockTexture.Drill[3]);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side,int meta){
		switch(side){
			case 0:
				return botIcon;
			case 1:
				return topIcon;
			case 2:
				return evenSideIcon;
			case 3:
				return evenSideIcon;
			case 4:
				return oddSideIcon;
			default:
				return oddSideIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world,int unknown){
		int t = r.nextInt(20);
		while(t < 5){
			t = r.nextInt(20);
		}
		System.out.println("done");
		return new DrillTile(t*2,t/2);
	}
}
