package ad.Genis231.Research.Player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import ad.Genis231.lib.Ref;

public class PlayerData implements IExtendedEntityProperties {
	private int dataWatcher = 20;
	public static String PlayerData_ID = Ref.MOD_ID + "_PlayerData";
	private EntityPlayer player;
	
	public PlayerData(EntityPlayer player) {
		this.player = player;
		this.player.getDataWatcher().addObject(this.dataWatcher, 0);
	}
	
	/** Used to register these extended properties for the player during EntityConstructing event This method is for convenience only; it will make your code look nicer */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(PlayerData.PlayerData_ID, new PlayerData(player));
	}
	
	/** Returns ExtendedPlayer properties for player This method is for convenience only; it will make your code look nicer */
	public static final PlayerData get(EntityPlayer player) {
		return (PlayerData) player.getExtendedProperties(PlayerData_ID);
	}
	
	@Override public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("Points", this.player.getDataWatcher().getWatchableObjectInt(dataWatcher));
		
		compound.setTag(PlayerData_ID, properties);
	}
	
	@Override public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(PlayerData_ID);
		
		this.player.getDataWatcher().updateObject(dataWatcher, properties.getInteger("Points"));
	}
	
	@Override public void init(Entity entity, World world) {}
	
	public int getPoints() {
		return this.player.getDataWatcher().getWatchableObjectInt(dataWatcher);
	}
	
	public void setPoints(int i) {
		this.player.getDataWatcher().updateObject(dataWatcher, i);
		
	}
	
	public void addPoints(int i) {
		int temp = this.player.getDataWatcher().getWatchableObjectInt(dataWatcher);
		this.player.getDataWatcher().updateObject(dataWatcher, temp + i);
	}
	
	public void subPoints(int i) {
		int temp = this.player.getDataWatcher().getWatchableObjectInt(dataWatcher);
		
		if (temp - i <= 0)
			this.player.getDataWatcher().updateObject(dataWatcher, 0);
		else
			this.player.getDataWatcher().updateObject(dataWatcher, temp - i);
	}
	
	/** Does everything I did in onLivingDeathEvent and it's static, so you now only need to use the following in the above event: ExtendedPlayer.saveProxyData((EntityPlayer) event.entity)); */
	public static void saveProxyData(EntityPlayer player) {
		PlayerData playerData = PlayerData.get(player);
		NBTTagCompound savedData = new NBTTagCompound();
		
		playerData.saveNBTData(savedData);
	}
	
	/** This cleans up the onEntityJoinWorld event by replacing most of the code with a single line: ExtendedPlayer.loadProxyData((EntityPlayer) event.entity)); */
	public static void loadProxyData(EntityPlayer player) {}
}
