package ad.Genis231.Core;

import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.Map;

public class CommonProxy {
	private static final Map<String, NBTTagCompound> playerInfo = new HashMap<String, NBTTagCompound>();
	
	public void registerRenderers() {}
	
	public static void storeEntityData(String name, NBTTagCompound compound) {
		playerInfo.put(name, compound);
	}
	
	/** Removes the compound from the map and returns the NBT tag stored for name or null if none exists */
	public static NBTTagCompound getEntityData(String name) {
		return playerInfo.remove(name);
	}
}
