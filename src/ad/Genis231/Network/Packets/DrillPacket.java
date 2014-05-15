package ad.Genis231.Network.Packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.Network.ADPacket;
import ad.Genis231.TileEntity.DrillTile;

public class DrillPacket extends ADPacket {
	int x, y, z;
	int width, height, speed;
	int type, damage;
	boolean isClientSide;
	
	public DrillPacket() {}
	
	public DrillPacket(int type, int damage, int x, int y, int z) {
		this.type = type;
		this.damage = damage;
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.isClientSide = true;
	}
	
	public DrillPacket(int width, int height, int speed, int x, int y, int z) {
		this.width = width;
		this.height = height;
		this.speed = speed;
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.isClientSide = false;
	}
	
	@Override public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeBoolean(this.isClientSide);
		
		if (this.isClientSide) {
			buffer.writeInt(type);
			buffer.writeInt(damage);
		} else {
			buffer.writeInt(width);
			buffer.writeInt(height);
			buffer.writeInt(speed);
		}
		
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}
	
	@Override public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		this.isClientSide = buffer.readBoolean();
		
		if (this.isClientSide) {
			this.type = buffer.readInt();
			this.damage = buffer.readInt();
		} else {
			this.width = buffer.readInt();
			this.height = buffer.readInt();
			this.speed = buffer.readInt();
		}
		
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}
	
	@Override public void handleClientSide(EntityPlayer player) {
		World world = player.worldObj;
		TileEntity te = world.getTileEntity(x, y, z);
		if (this.isClientSide && te instanceof DrillTile) {
			DrillTile tile = (DrillTile) te;
			
			tile.setDrill(type, damage);
		}
	}
	
	@Override public void handleServerSide(EntityPlayer player) {
		World world = player.worldObj;
		TileEntity te = world.getTileEntity(x, y, z);
		
		if (te instanceof DrillTile) {
			DrillTile tile = (DrillTile) te;
			
			if (this.isClientSide)
				tile.setDrill(type, damage);
			else
				tile.setStats(width, height, speed);
			
		}
	}
}
