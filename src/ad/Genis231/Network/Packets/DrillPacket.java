package ad.Genis231.Network.Packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.PacketBuffer;
import ad.Genis231.Core.PacketHandler;
import ad.Genis231.Network.ADPacket;

public class DrillPacket extends ADPacket {
	
	@Override public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {}
	
	@Override public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {}
	
	@Override public void handleClientSide(EntityPlayer player) {}
	
	@Override public void handleServerSide(EntityPlayer player) {}	
}
