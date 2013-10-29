package ad.Genis231.TileEntitys;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class SpikeTile extends TileEntity implements IInventory {
	protected ForgeDirection orientation;
	protected byte state;
	protected String customName;
	
	public SpikeTile() {
		
		orientation = ForgeDirection.SOUTH;
		state = 0;
		customName = "";
	}
	
	public ForgeDirection getOrientation() {
		
		return orientation;
	}
	
	public void setOrientation(ForgeDirection orientation) {
		
		this.orientation = orientation;
	}
	
	public void setOrientation(int orientation) {
		
		this.orientation = ForgeDirection.getOrientation(orientation);
	}
	
	public short getState() {
		
		return state;
	}
	
	public void setState(byte state) {
		
		this.state = state;
	}
	
	public boolean hasCustomName() {
		
		return customName != null && customName.length() > 0;
	}
	
	public String getCustomName() {
		
		return customName;
	}
	
	public void setCustomName(String customName) {
		
		this.customName = customName;
	}
	
	public boolean isUseableByPlayer(EntityPlayer player) {
		
		return true;
	}
	
	@Override public void readFromNBT(NBTTagCompound nbtTagCompound) {
		
		super.readFromNBT(nbtTagCompound);
	}
	
	@Override public void writeToNBT(NBTTagCompound nbtTagCompound) {
		
		super.writeToNBT(nbtTagCompound);
	}
	
	@Override public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(String.format("TileEE Data - xCoord: %d, yCoord: %d, zCoord: %d, customName: '%s', orientation: %s, state: %d\n", xCoord, yCoord, zCoord, customName, orientation, state));
		
		return stringBuilder.toString();
	}
	
	@Override public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}
	
	@Override public String getInvName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override public void openChest() {
		// TODO Auto-generated method stub
		
	}
	
	@Override public void closeChest() {
		// TODO Auto-generated method stub
		
	}
	
	@Override public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
