package ad.Genis231.Blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import ad.Genis231.Generation.TeleportHandler;
import ad.Genis231.lib.Ref;

public class PortalBlock extends BlockPortal {
	public PortalBlock(int id) {
		super(id);
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity.ridingEntity == null && entity.riddenByEntity == null) {
			if (entity instanceof EntityPlayerMP) {
				EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
				if (entity.dimension != Ref.PortalNumber) {
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Ref.PortalNumber, new TeleportHandler(thePlayer.mcServer.worldServerForDimension(Ref.PortalNumber)));
				} else {
					//thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleportHandler(thePlayer.mcServer.worldServerForDimension(0)));
				}
			}
		}
	}
	
	public boolean tryToCreatePortal(World world, int x, int y, int z)
	{
		byte var5 = 0;
		byte var6 = 0;
		
		if (world.getBlockId(x - 1, y, z) == Block.sandStone.blockID || world.getBlockId(x + 1, y, z) == Block.sandStone.blockID) {
			var5 = 1;
		}
		
		if (world.getBlockId(x, y, z - 1) == Block.sandStone.blockID || world.getBlockId(x, y, z + 1) == Block.sandStone.blockID) {
			var6 = 1;
		}
		
		if (var5 == var6) {
			return false;
		} else {
			if (world.getBlockId(x - var5, y, z - var6) == 0) {
				x -= var5;
				z -= var6;
			}
			
			int var7;
			int var8;
			
			for (var7 = -1; var7 <= 2; ++var7) {
				for (var8 = -1; var8 <= 3; ++var8) {
					boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;
					
					if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
						int var10 = world.getBlockId(x + var5 * var7, y + var8, z + var6 * var7);
						
						if (var9) {
							if (var10 != Block.sandStone.blockID) { return false; }
						}
						else if (var10 != 0 && var10 != Block.fire.blockID) { return false; }
					}
				}
			}
			
			for (var7 = 0; var7 < 2; ++var7) {
				for (var8 = 0; var8 < 3; ++var8) {
					world.setBlockMetadataWithNotify(x + var5 * var7, y + var8, z + var6 * var7, this.blockID, 2);
				}
			}
			return true;
		}
	}
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){
		byte var6 = 0;
		byte var7 = 1;
		
		if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID){
			var6 = 1;
			var7 = 0;
		}
		
		int var8;
		
		for (var8 = par3; par1World.getBlockId(par2, var8 - 1, par4) == this.blockID; --var8){
			;
		}
		
		if (par1World.getBlockId(par2, var8 - 1, par4) != Block.sandStone.blockID){
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
		}else{
			int var9;
			
			for (var9 = 1; var9 < 4 && par1World.getBlockId(par2, var8 + var9, par4) == this.blockID; ++var9){
				;
			}
			
			if (var9 == 3 && par1World.getBlockId(par2, var8 + var9, par4) == Block.sandStone.blockID){
				boolean var10 = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
				boolean var11 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;
				
				if (var10 && var11){
					par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
				}else{
					if ((par1World.getBlockId(par2 + var6, par3, par4 + var7) != Block.sandStone.blockID || par1World.getBlockId(par2 - var6, par3, par4 - var7) != this.blockID) && (par1World.getBlockId(par2 - var6, par3, par4 - var7) != Block.sandStone.blockID || par1World.getBlockId(par2 + var6, par3, par4 + var7) != this.blockID)){
						par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
					}
				}
			}else{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
			}
		}
	}
}