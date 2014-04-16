package ad.Genis231.Blocks.Dwarf;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADLiquid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LiquidAle extends ADLiquid {
	
	@SideOnly(Side.CLIENT) protected IIcon stillIcon;
	@SideOnly(Side.CLIENT) protected IIcon flowingIcon;
	
	public LiquidAle(Fluid fluid, String name) {
		super(fluid, name);
		this.setBlockTextureName(textures.aleLiquid);
		this.setCreativeTab(Ref.DwarfTab);
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityWalking(world, x, y, z, entity);
		
		if (entity instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) entity;
			
			player.addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(), 400, 2));
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 400, 2));
			player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 200, 2));
			player.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 40, 2));
		}
	}
	
	@Override public IIcon getIcon(int side, int meta) {
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}
	
	@SideOnly(Side.CLIENT) @Override public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon(textures.aleLiquid);
		flowingIcon = register.registerIcon(textures.aleFlowing);
	}
	
	@Override public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}
	
	@Override public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}
}
