package ad.Genis231.TileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.world.World;
import ad.Genis231.Core.Resources.InventoryHelper;

public class DrillTile extends ADTileEntity {
	
	private int minX, maxX, minZ, maxZ;
	private int cooldown = -1;
	private int drillWidth;
	private int drillHeight;
	private int delay;
	private Block[] blockArray = { Blocks.air, Blocks.bedrock, Blocks.redstone_block };
	private boolean drillStatus;
	public boolean canDrill;
	public int angle;
	public World world;
	public int maxBreak = 5;
	
	boolean needsUpdate = false;
	
	private int speed = 360 / 20;
	
	public DrillTile() {
		drillStatus = false;
		canDrill = false;
	}
	
	@Override public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		
		drillWidth = tag.getInteger("width");
		drillHeight = tag.getInteger("height");
		delay = tag.getInteger("delay");
		
	}
	
	@Override public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("delay", delay);
		tag.setInteger("width", drillWidth);
		tag.setInteger("height", drillHeight);
	}
	
	public void updateEntity() {
		world = this.worldObj;
		
		if (needsUpdate) {
			needsUpdate = false;
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		
		canDrill = world.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && !drillStatus;
		
		if (canDrill) {
			angle += speed * 2;
			if (angle >= 360)
				angle = 0;
			
			if (!world.isRemote) {
				if (cooldown <= 0) {
					drill();
					this.cooldown = delay;
				} else
					cooldown--;
			}
		} else
			this.cooldown = delay;
		
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
		
		if (!drillStatus) {
			setSize();
			for (int y = yCoord - 1; y > 0; y--) {
				for (int z = minZ; z <= maxZ; z++) {
					for (int x = minX; x <= maxX; x++) {
						if (isBreakable(x, y, z)) {
							addBlock(worldObj, x, y, z);
							worldObj.setBlockToAir(x, y, z);
							count++;
						}
						
						if (count >= maxBreak)
							return;
					}
				}
			}
		}
		
		drillStatus = count == 0;
		
		return;
	}
	
	private void addBlock(World world, int x, int y, int z) {
		ItemStack item = getItem(x, y, z);
		IInventory temp = getInventory(item);
		InventoryHelper.addBlock(temp, item);
	}
	
	private ItemStack getItem(int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		Item item = block.getItemDropped(meta, world.rand, 0);
		int amount = block.quantityDropped(meta, 0, world.rand);
		
		return new ItemStack(item, amount, 0);
	}
	
	private IInventory getInventory(ItemStack item) {
		return InventoryHelper.getInventoryAround(world, xCoord, yCoord, zCoord, item);
	}
	
	private boolean isBreakable(int x, int y, int z) {
		for (Block block : blockArray) {
			if (world.getBlock(x, y, z) == block) {
				System.out.printf(block.getLocalizedName() + "X:%d Y:%d Z:%d\n", x, y, z);
				return false;
			}
		}
		
		return world.getTileEntity(x, y, z) == null && world.getBlock(x, y, z).getMaterial() == Material.water && world.getBlock(x, y, z).getMaterial() == Material.lava;
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
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
		this.needsUpdate = true;
	}
}
