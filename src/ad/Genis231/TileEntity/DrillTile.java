package ad.Genis231.TileEntity;

import ad.Genis231.BaseClasses.ADTileEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DrillTile extends ADTileEntity{

	int range, minX, maxX, minZ, maxZ, rate;
	Block[] blockArray = {Blocks.air,Blocks.water,Blocks.lava,Blocks.bedrock};
	boolean drillDone = false;

	public DrillTile(int size,int speed){
		System.out.println(size + " " + speed);
		range = size;
		rate = speed;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		if(tag.getInteger("rate") != 0 && tag.getInteger("range") != 0){
			rate = tag.getInteger("rate");
			range = tag.getInteger("range");
		}
		drillDone = tag.getBoolean("status");

	}

	@Override
	public void writeToNBT(NBTTagCompound tag){
		tag.setInteger("rate",rate);
		tag.setInteger("range",range);
		tag.setBoolean("status",drillDone);
		super.writeToNBT(tag);
	}

	public void updateEntity(){
		minX = xCoord > 0 ? xCoord - range : xCoord + range;
		maxX = xCoord > 0 ? xCoord + range : xCoord - range;
		minZ = zCoord > 0 ? zCoord - range : zCoord + range;
		maxZ = zCoord > 0 ? zCoord + range : zCoord - range;

		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord,yCoord,zCoord) && System.currentTimeMillis() % (2000 / rate) > 10 && !this.worldObj.isRemote){
			drill();
		}
	}

	boolean drill(){
		int count = 0;

		if(!drillDone){
			for(int y = yCoord - 1; y >= 0; y--){
				for(int x = minX; x <= maxX; x++){
					for(int z = minZ; z <= maxZ; z++){
						if(isBreakable(x,y,z)){
							worldObj.setBlockToAir(x,y,z);
							count++;
						}

						if(count >= 10) return true;
					}
				}
			}
		}

		drillDone = count == 0;

		return false;
	}

	boolean isBreakable(int x,int y,int z){
		for(Block block : blockArray){
			if(this.worldObj.getBlock(x,y,z).equals(block) || this.worldObj.getTileEntity(x,y,z) != null){
				return false;
			}
		}
		return true;
	}

}
