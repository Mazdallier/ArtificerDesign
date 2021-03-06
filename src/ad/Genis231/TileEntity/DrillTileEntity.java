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
import ad.Genis231.Core.Artificer;
import ad.Genis231.Network.Packets.DrillPacket;
import ad.Genis231.Resources.ADTileEntity;
import ad.Genis231.Resources.InventoryHelper;

public class DrillTileEntity extends ADTileEntity {
	
	private int minX, maxX, minZ, maxZ;
	private int cooldown = -1;
	private int drillWidth = 5;
	private int drillHeight = 5;
	private int delay;
	private Block[] blockArray = { Blocks.air, Blocks.bedrock };
	private boolean drillDone;
	private int type = -1;
	private int damage = 0;
	public int angle;
	World world;
	
	boolean needsUpdate = false;
	
	private int speed = 360 / 20;
	
	public DrillTileEntity() {
		this.world = this.worldObj;
		drillDone = false;
	}
	
	private void addBlock(int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		
		Item tempItem = block.getItemDropped(meta, world.rand, 0);
		int stacksize = block.quantityDropped(world.rand);
		int damage = block.damageDropped(meta);
		
		if (tempItem != null && stacksize != 0) {
			ItemStack item = new ItemStack(tempItem, stacksize, damage);
			IInventory chest = InventoryHelper.getInventoryAround(world, this.xCoord, this.yCoord, this.zCoord, item);
			InventoryHelper.addBlock(chest, item);
		}
	}
	
	private boolean canDrill() {
		return world.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord) && !drillDone && this.type != -1;
	}
	
	private void drill() {
		int count = 0;
		
		if (!drillDone && !this.worldObj.isRemote)
			for (int y = yCoord - 1; y >= 0; y--)
				for (int x = minX; x <= maxX - 1; x++)
					for (int z = minZ; z <= maxZ - 1; z++) {
						if (isBreakable(x, y, z)) {
							this.damage--;
							Artificer.packets.sendToAll(new DrillPacket(type, damage, this.xCoord, this.yCoord, this.zCoord));
							
							addBlock(x, y, z);
							world.setBlockToAir(x, y, z);
							count++;
						}
						
						if (count > 0)
							return;
					}
		
		drillDone = count == 0;
		
		return;
	}
	
	public int getAngle() {
		return this.angle;
	}
	
	public int getDelay() {
		return this.delay;
	}
	
	@Override public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}
	
	public int getDrillDamage() {
		return this.damage;
	}
	
	public int getDrillType() {
		return this.type;
	}
	
	public int getHeight() {
		return this.drillHeight;
	}
	
	public int getWidth() {
		return this.drillWidth;
	}
	
	private boolean isBreakable(int x, int y, int z) {
		for (Block block : blockArray) {
			if (this.worldObj.getBlock(x, y, z) == block) { return false; }
		}
		
		return this.worldObj.getTileEntity(x, y, z) == null && this.worldObj.getBlock(x, y, z).getMaterial() != Material.water && this.worldObj.getBlock(x, y, z).getMaterial() != Material.lava;
	}
	
	@Override public void markDirty() {
		updateEntity();
		super.markDirty();
		needsUpdate = true;
	}
	
	@Override public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
		markDirty();
		world.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
		this.needsUpdate = true;
	}
	
	@Override public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		
		drillWidth = tag.getInteger("width");
		drillHeight = tag.getInteger("height");
		delay = tag.getInteger("delay");
		cooldown = tag.getInteger("cd");
		drillDone = tag.getBoolean("status");
		angle = tag.getInteger("angle");
		type = tag.getInteger("type");
		damage = tag.getInteger("damage");
	}
	
	public void setDrill(int type, int damage) {
		this.type = type;
		this.damage = damage;
		
		needsUpdate = true;
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
	
	public void setStats(int width, int height, int rate) {
		this.drillWidth = width;
		this.drillHeight = height;
		this.delay = rate;
		
		needsUpdate = true;
	}
	
	public void updateEntity() {
		world = this.worldObj;
		
		if (needsUpdate) {
			needsUpdate = false;
			world.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		
		if (this.damage <= 0 && type != -1) {
			double x = this.xCoord;
			double y = this.yCoord;
			double z = this.zCoord;
			
			// soundName, x, y, z, volume, pitch
			this.worldObj.playSoundEffect(x, y, z, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
			
			// particalName minX,minY,minZ,maxX,maxY,maxZ
			world.spawnParticle("hugeexplosion", x, y, z, 0.5, 0.5, 0.5);
			this.type = -1;
		}
		
		if (canDrill()) {
			angle = angle >= 360 ? 0 : angle + speed * 2;
			
			if (cooldown == 0 && !this.worldObj.isRemote) {
				setSize();
				drill();
				this.cooldown = delay;
			} else
				cooldown--;
		} else
			this.cooldown = delay;
		
	}
	
	@Override public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("delay", delay);
		tag.setInteger("width", drillWidth);
		tag.setInteger("height", drillHeight);
		tag.setBoolean("status", drillDone);
		tag.setInteger("cd", cooldown);
		tag.setInteger("angle", angle);
		tag.setInteger("type", type);
		tag.setInteger("damage", damage);
	}
	
}
