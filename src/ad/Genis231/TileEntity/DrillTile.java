package ad.Genis231.TileEntity;

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
import ad.Genis231.BaseClass.ADTileEntity;
import ad.Genis231.lib.Resources.InventoryHelper;

public class DrillTile extends ADTileEntity {
	
	private int minX, maxX, minZ, maxZ;
	private int cooldown = -1;
	private int drillWidth = 20;
	private int drillHeight = 20;
	private int delay;
	private Block[] blockArray = { Blocks.air, Blocks.bedrock, Blocks.redstone_block, Blocks.stained_glass_pane, Blocks.glass_pane };
	private boolean drillDone;
	public boolean drilling;
	public int angle;
	World world;
	
	boolean needsUpdate = false;
	
	private int speed = 360 / 20;
	
	public DrillTile() {
		this.world = this.worldObj;
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
		world = this.worldObj;
		
		if (needsUpdate) {
			needsUpdate = false;
			world.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		
		drilling = world.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && !drillDone;
		
		if (drilling) {
			angle += speed * 1;
			if (angle >= 360) {
				angle = 0;
			}
			
			if (!world.isRemote) {
				if (canActivate()) {
					setSize();
					drill();
					this.cooldown = delay;
				} else {
					cooldown--;
				}
			}
		} else if (!drilling && !world.isRemote) {
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
							addBlock(x, y, z);
							world.setBlockToAir(x, y, z);
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
	
	private void addBlock(int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		ItemStack item = new ItemStack(block.getItemDropped(meta, world.rand, 0), block.quantityDropped(meta, 0, world.rand), block.damageDropped(meta));
		
		IInventory chest = InventoryHelper.getInventoryAround(world, this.xCoord, this.yCoord, this.zCoord, item);
		InventoryHelper.addBlock(chest, item);
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
		world.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
		this.needsUpdate = true;
	}
}
