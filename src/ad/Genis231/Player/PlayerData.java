package ad.Genis231.Player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import ad.Genis231.Core.CommonProxy;
import ad.Genis231.Refrence.Ref;

public class PlayerData implements IExtendedEntityProperties {
	/** Returns ExtendedPlayer properties for player This method is for convenience only; it will make your code look nicer */
	public static final PlayerData get(EntityPlayer player) {
		return (PlayerData) player.getExtendedProperties(PlayerData_ID);
	}
	private static final String getSaveKey(EntityPlayer player) {
		return player.getCommandSenderName() + ":" + PlayerData_ID;
	}
	private int pointWatcher = 20;
	private int raceWatcher = 21;
	
	public static String PlayerData_ID = Ref.MOD_ID + "_PlayerData";
	
	public static final void loadProxyData(EntityPlayer player) {
		PlayerResearch playerData = PlayerResearch.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
		
		if (savedData != null)
			playerData.loadNBTData(savedData);
	}
	
	/** Used to register these extended properties for the player during EntityConstructing event This method is for convenience only; it will make your code look nicer */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(PlayerData.PlayerData_ID, new PlayerData(player));
	}
	
	public static void saveProxyData(EntityPlayer player) {
		PlayerData playerData = PlayerData.get(player);
		NBTTagCompound savedData = new NBTTagCompound();
		
		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}
	
	private EntityPlayer player;
	
	public PlayerData(EntityPlayer player) {
		this.player = player;
		this.player.getDataWatcher().addObject(this.pointWatcher, 0);
		this.player.getDataWatcher().addObject(this.raceWatcher, 0);
	}
	
	public void addPoints(int i) {
		int temp = this.player.getDataWatcher().getWatchableObjectInt(pointWatcher);
		this.player.getDataWatcher().updateObject(pointWatcher, temp + i);
	}
	
	public int getPoints() {
		return this.player.getDataWatcher().getWatchableObjectInt(pointWatcher);
	}
	
	public PlayerRace getRace() {
		int id = this.player.getDataWatcher().getWatchableObjectInt(this.raceWatcher);
		return PlayerRace.getRace(id);
	}
	
	@Override public void init(Entity entity, World world) {}
	
	@Override public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(PlayerData_ID);
		
		this.player.getDataWatcher().updateObject(this.pointWatcher, properties.getInteger("Points"));
		this.player.getDataWatcher().updateObject(this.raceWatcher, properties.getInteger("Class"));
	}
	
	@Override public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("Points", this.player.getDataWatcher().getWatchableObjectInt(this.pointWatcher));
		properties.setInteger("Class", this.player.getDataWatcher().getWatchableObjectInt(this.raceWatcher));
		
		compound.setTag(PlayerData_ID, properties);
	}
	
	public void setPoints(int i) {
		this.player.getDataWatcher().updateObject(pointWatcher, i);
	}
	
	public void setRace(PlayerRace race) {
		this.player.getDataWatcher().updateObject(this.raceWatcher, race.getID());
		
	}
	
	public void subPoints(int i) {
		int temp = this.player.getDataWatcher().getWatchableObjectInt(pointWatcher);
		
		if (temp - i <= 0)
			this.player.getDataWatcher().updateObject(pointWatcher, 0);
		else
			this.player.getDataWatcher().updateObject(pointWatcher, temp - i);
	}
}
