package ad.Genis231.Network.Packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import ad.Genis231.Network.ADPacket;
import ad.Genis231.Player.PlayerResearch;
import cpw.mods.fml.common.network.ByteBufUtils;

public class researchPacket extends ADPacket {
	private NBTTagCompound data;
	
	public researchPacket(EntityPlayer player) {
		data = new NBTTagCompound();
		PlayerResearch.get(player).saveNBTData(data);
	}
	
	@Override public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		ByteBufUtils.writeTag(buffer, data);
	}
	
	@Override public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		data = ByteBufUtils.readTag(buffer);
	}
	
	@Override public void handleClientSide(EntityPlayer player) {
		PlayerResearch.get(player).loadNBTData(data);
	}
	
	@Override public void handleServerSide(EntityPlayer player) {}
}
