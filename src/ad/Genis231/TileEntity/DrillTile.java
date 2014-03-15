package ad.Genis231.TileEntity;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ad.Genis231.Core.Resources.InventoryHelper;

public class DrillTile extends ADTileEntity {
	
	private int minX, maxX, minZ, maxZ;
	private int cooldown = -1;
	private int drillWidth;
	private int drillHeight;
	private int delay;
	private Block[] blockArray = { Blocks.air, Blocks.bedrock, Blocks.redstone_block };
	private boolean drillDone;
	ArrayList<IInventory> inventories = new ArrayList<IInventory>();
	public boolean drilling;
	public int angle;
	
	boolean needsUpdate = false;
	
	private int speed = 360 / 20;
	
	public DrillTile() {
		drillDone = false;
		drilling = false;
	}
	
	@Override public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		
		drillWidth = tag.getInteger("width");
		drillHeight = tag.getInteger("height");
		delay = tag.getInteger("delay");
		cooldown = tag.getInteger("cd");
		drillDone = tag.getBoolean("status");
		angle = tag.getInteger("angle");
		
	}
	
	@Override public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("delay", delay);
		tag.setInteger("width", drillWidth);
		tag.setInteger("height", drillHeight);
		tag.setBoolean("status", drillDone);
		tag.setInteger("cd", cooldown);
		tag.setInteger("angle", angle);
	}
	
	public void updateEntity() {
		
		if (needsUpdate) {
			needsUpdate = false;
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		
		drilling = this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && !drillDone;
		
		if (drilling) {
			angle += speed * 2;
			if (angle >= 360) {
				getInventory();
				angle = 0;
			}
			
			if (!this.worldObj.isRemote) {
				
				if (canActivate()) {
					setSize();
					drill();
					this.cooldown = delay;
				} else {
					cooldown--;
				}
			}
		} else if (!drilling && !this.worldObj.isRemote) {
			this.cooldown = delay;
		}
	}
	
	private void setSize() {
		minX = xCoord - drillWidth;
		maxX = xCoord + drillWidth;
		
		minZ = zCoord - drillHeight;
		maxZ = zCoord + drillHeight;
		
		int temp;
		if (minX > maxX) {
			temp = minX;
			minX = maxX;
			maxX = temp;
		}
		
		if (minZ > maxZ) {
			temp = minZ;
			minZ = maxZ;
			maxZ = temp;
		}
	}
	
	private void drill() {
		int count = 0;
		
		if (!drillDone) {
			for (int y = yCoord - 1; y >= 0; y--) {
				for (int x = minX; x <= maxX; x++) {
					for (int z = minZ; z <= maxZ; z++) {
						if (isBreakable(x, y, z)) {
							addBlock(worldObj, x, y, z);
							worldObj.setBlockToAir(x, y, z);
							count++;
						}
						if (count >= 1)
							return;
					}
				}
			}
		}
		
		drillDone = count == 0;
		
		return;
	}
	
	private boolean addBlock(World world, int x, int y, int z) {
		getInventory();
		for (int i = 0; i < inventories.size(); i++) {
			if (InventoryHelper.addBlock(inventories.get(i), new ItemStack(world.getBlock(x, y, z), 1, world.getBlockMetadata(x, y, z)))) { return true; }
		}
		return false;
	}
	
	private void getInventory() {
		IInventory chest;
		
		if (inventories != null) {
			inventories.clear();
		}
		
		for (ForgeDirection dir : ForgeDirection.values()) {
			chest = InventoryHelper.getInventorySide(dir, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			if (chest != null)
				inventories.add(chest);
		}
	}
	
	private boolean canActivate() {
		return cooldown <= 0;
	}
	
	private boolean isBreakable(int x, int y, int z) {
		for (Block block : blockArray) {
			if (this.worldObj.getBlock(x, y, z).equals(block)) { return false; }
		}
		
		return this.worldObj.getTileEntity(x, y, z) == null && this.worldObj.getBlock(x, y, z).getMaterial() != Material.water && this.worldObj.getBlock(x, y, z).getMaterial() != Material.lava;
	}
	
	public void setStats(int width, int height, int rate) {
		System.out.println("Setting Stats! :P");
		
		drillWidth = width;
		drillHeight = height;
		delay = rate;
		
		needsUpdate = true;
	}
	
	public int getWidth() {
		return this.drillWidth;
	}
	
	public int getHeight() {
		return this.drillHeight;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	@Override public void markDirty() {
		updateEntity();
		super.markDirty();
		needsUpdate = true;
	}
	
	@Override public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}
	
	@Override public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
		markDirty();
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
		this.needsUpdate = true;
	}
}
