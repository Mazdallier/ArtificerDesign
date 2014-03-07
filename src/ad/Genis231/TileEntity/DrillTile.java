package ad.Genis231.TileEntity;

import ad.Genis231.Core.Resources.InventoryHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import ad.Genis231.BaseClasses.ADTileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public class DrillTile extends ADTileEntity{

	int range, minX, maxX, minZ, maxZ, rate;
	Block[] blockArray = {Blocks.air,Blocks.water,Blocks.lava,Blocks.bedrock};
	boolean drillDone = false;
	ArrayList<IInventory> inventories = new ArrayList<IInventory>();

	public DrillTile(int size,int speed){
		System.out.println(size + " " + speed);
		range = size;
		rate = speed;
		drillDone = false;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		if(tag.getInteger("rate") != 0 && tag.getInteger("range") != 0){
			rate = tag.getInteger("rate");
			range = tag.getInteger("range");
			drillDone = tag.getBoolean("status");
		}
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

		check();

		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord,yCoord,zCoord) && System.currentTimeMillis() % (100* rate) > 50 && !this.worldObj.isRemote){
			drill();
		}
	}

	void drill(){
		int count = 0;

		if(!drillDone){
			for(int y = yCoord - 1; y >= 0; y--){
				for(int x = minX; x <= maxX; x++){
					for(int z = minZ; z <= maxZ; z++){
						if(isBreakable(x,y,z)){
							addBlock(worldObj.getBlock(x,y,z));
							worldObj.setBlockToAir(x,y,z);
							count++;
						}
						if(count >= 1) return;
					}
				}
			}
		}

		drillDone = count == 0;

		return;
	}

	void check(){
		int temp;
		if(minX > maxX){
			temp = minX;
			minX = maxX;
			maxX = temp;
		}

		if(minZ > maxZ){
			temp = minZ;
			minZ = maxZ;
			maxZ = temp;
		}
	}

	boolean addBlock(Block block){
		getInventory();
		for(int i = 0; i < inventories.size(); i++){
			if(InventoryHelper.addBlock(inventories.get(i),new ItemStack(block,1))){
				return true;
			}
		}
		return false;
	}

	void getInventory(){
		IInventory chest;
		for(ForgeDirection dir : ForgeDirection.values()){
			chest = InventoryHelper.getInventorySide(dir,this.worldObj,this.xCoord,this.yCoord,this.zCoord);
			if(chest != null) inventories.add(chest);
		}
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