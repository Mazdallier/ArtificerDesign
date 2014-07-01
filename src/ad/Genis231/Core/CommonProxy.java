package ad.Genis231.Core;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;

public class CommonProxy {
	private static final Map<String, NBTTagCompound> playerInfo = new HashMap<String, NBTTagCompound>();
	
	/** Removes the compound from the map and returns the NBT tag stored for name or null if none exists */
	public static NBTTagCompound getEntityData(String name) {
		return playerInfo.remove(name);
	}
	
	public static void storeEntityData(String name, NBTTagCompound compound) {
		playerInfo.put(name, compound);
	}
	
	public void registerRenderers() {}
}
