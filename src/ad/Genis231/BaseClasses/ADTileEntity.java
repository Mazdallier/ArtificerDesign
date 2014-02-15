package ad.Genis231.BaseClasses;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class ADTileEntity extends TileEntity {
	@Override public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
	}
	
	@Override public void writeToNBT(NBTTagCompound tagCompound) {}
}
