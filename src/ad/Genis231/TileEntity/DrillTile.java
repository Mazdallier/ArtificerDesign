package ad.Genis231.TileEntity;

import ad.Genis231.BaseClasses.ADTileEntity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;

public class DrillTile extends ADTileEntity {
	
	int range, minX, maxX, minZ, maxZ, rate;
	
	public DrillTile(int size, int speed) {
		NBTTagCompound tag = new NBTTagCompound();

        tag.setInteger("range", size);
		tag.setInteger("rate", speed);

		writeToNBT(tag);

        System.out.println("NBT: Speed: "+tag.getInteger("rate")+" Size: "+tag.getInteger("range"));

		System.out.println(size + " " + speed);
		range = size;
		rate = speed;
	}
	
	@Override public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		if (tag.getInteger("rate") != 0 && tag.getInteger("range") != 0) {
			rate = tag.getInteger("rate");
			range = tag.getInteger("range");
		}
	}
	
	@Override public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("rate", rate);
		tag.setInteger("range", range);
		
		super.writeToNBT(tag);
	}
	
	public void updateEntity() {
		minX = xCoord > 0 ? xCoord - range : xCoord + range;
		maxX = xCoord > 0 ? xCoord + range : xCoord - range;
		minZ = zCoord > 0 ? zCoord - range : zCoord + range;
		maxZ = zCoord > 0 ? zCoord + range : zCoord - range;
		
		if (this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && System.currentTimeMillis() % (2000 / rate) > 10) {
			drill();
		}
	}
	
	boolean drill() {
		int count = 0;
		
		for (int y = yCoord - 1; y >= 0; y--) {
			for (int x = minX; x <= maxX; x++) {
				for (int z = minZ; z <= maxZ; z++) {
					if (this.worldObj.getBlock(x, y, z) != Blocks.air) {
						worldObj.setBlock(x, y, z, Blocks.air);
						count++;
					}
					
					if (count >= 10)
						return true;
				}
			}
		}
		return false;
	}
}
