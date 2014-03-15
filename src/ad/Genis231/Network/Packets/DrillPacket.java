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
	
	public DrillPacket() {}
	
	public DrillPacket(int width, int height, int speed, int x, int y, int z) {
		this.width = width;
		this.height = height;
		this.speed = speed;
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(width);
		buffer.writeInt(height);
		buffer.writeInt(speed);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}
	
	@Override public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		this.width = buffer.readInt();
		this.height = buffer.readInt();
		this.speed = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		
	}
	
	@Override public void handleClientSide(EntityPlayer player) {}
	
	@Override public void handleServerSide(EntityPlayer player) {
		World world = player.worldObj;
		TileEntity te = world.getTileEntity(x, y, z);
		
		if (te instanceof DrillTile) {
			DrillTile tile = (DrillTile) te;
			
			tile.setStats(width, height, speed);
		}
	}
}
