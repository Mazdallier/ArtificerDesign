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
import ad.Genis231.Resources.ADTileEntity;
import ad.Genis231.Resources.InventoryHelper;

public class DrillTile extends ADTileEntity {
	
	private int minX, maxX, minZ, maxZ;
	private int cooldown = -1;
	private int drillWidth = 20;
	private int drillHeight = 20;
	private int delay;
	private Block[] blockArray = { Blocks.air, Blocks.bedrock };
	private boolean drillDone;
	private ItemStack currentDrill;
	public int angle;
	World world;
	
	boolean needsUpdate = false;
	
	private int speed = 360 / 20;
	
	public DrillTile() {
		this.world = this.worldObj;
		drillDone = false;
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
		
		if (canDrill()) {
			angle = angle >= 360 ? 0 : angle + speed * 2;
			
			if (this.currentDrill.getItemDamage() <= 0) {
				this.currentDrill = null;
				
				double x = this.xCoord - 1;
				double y = this.yCoord - 1;
				double z = this.zCoord - 1;
				
				System.out.println(world.isRemote);
				
				world.spawnParticle("hugeexplosion", x, y, z, 2, 2, 2);
				return;
			}
			
			if (cooldown == 0) {
				this.currentDrill.setItemDamage(this.currentDrill.getItemDamage() - 1);
				setSize();
				drill();
				this.cooldown = delay;
			} else
				cooldown--;
		} else
			this.cooldown = delay;
		
	}
	
	private boolean canDrill() {
		return world.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && !drillDone && this.currentDrill != null;
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
						if (!world.isRemote && isBreakable(x, y, z)) {
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
		
		Item temp = block.getItemDropped(meta, world.rand, 0);
		int quantity = block.quantityDropped(world.rand);
		int damage = block.damageDropped(meta);
		
		if (temp != null && quantity != 0) {
			ItemStack item = new ItemStack(temp, quantity, damage);
			
			IInventory chest = InventoryHelper.getInventoryAround(world, this.xCoord, this.yCoord, this.zCoord, item);
			InventoryHelper.addBlock(chest, item);
		}
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
	
	public ItemStack getDrill() {
		return this.currentDrill;
	}
	
	public void setDrill(ItemStack item) {
		if (item != null)
			this.currentDrill = item;
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
