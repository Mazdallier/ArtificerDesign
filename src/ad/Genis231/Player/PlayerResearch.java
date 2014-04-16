package ad.Genis231.Player;

import ad.Genis231.Core.Artificer;
import ad.Genis231.Core.CommonProxy;
import ad.Genis231.Network.Packets.researchPacket;
import ad.Genis231.Refrence.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import java.util.HashMap;

public class PlayerResearch implements IExtendedEntityProperties{
	public static String PlayerData_ID = Ref.MOD_ID + "_PlayerResearch";
	private EntityPlayer player;
	private HashMap<String,Integer> research = new HashMap<String,Integer>();

	public PlayerResearch(EntityPlayer player){
		this.player = player;
	}

	/**
	 * Used to register these extended properties for the player during EntityConstructing event This method is for convenience only; it will make your code look nicer
	 */
	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(PlayerResearch.PlayerData_ID,new PlayerResearch(player));
	}

	/**
	 * Returns ExtendedPlayer properties for player This method is for convenience only; it will make your code look nicer
	 */
	public static final PlayerResearch get(EntityPlayer player){
		return (PlayerResearch) player.getExtendedProperties(PlayerData_ID);
	}

	public void setValue(String key,int value){
		research.put(key,value);
	}

	public int getValue(String key){
		return research.get(key);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound){
		NBTTagCompound data = new NBTTagCompound();

		NBTTagList tagList = new NBTTagList();

		for(String key : research.keySet()){
			NBTTagCompound customCompound = new NBTTagCompound();
			customCompound.setInteger("Values",research.get(key));
			customCompound.setString("Keys",key);
			research.remove(key);
			tagList.appendTag(customCompound);
		}

		data.setTag("ResearchData",tagList);
		compound.setTag(PlayerData_ID,data);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound){
		NBTTagCompound data = (NBTTagCompound) compound.getTag(PlayerData_ID);

		NBTTagList tagList = data.getTagList("ResearchData",10);

		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound comp = tagList.getCompoundTagAt(i);
			research.put(comp.getString("Keys"),comp.getInteger("Values"));
		}

	}

	@Override
	public void init(Entity entity,World world){
	}

	public static void saveProxyData(EntityPlayer player){
		PlayerResearch playerData = PlayerResearch.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
	}

	private static final String getSaveKey(EntityPlayer player){
		return player.getCommandSenderName() + ":" + PlayerData_ID;
	}

	public static final void loadProxyData(EntityPlayer player){
		PlayerResearch playerData = PlayerResearch.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if(savedData != null) playerData.loadNBTData(savedData);

		Artificer.packets.sendTo(new researchPacket(player),(EntityPlayerMP) player);
	}
}
