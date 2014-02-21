package ad.Genis231.Core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import ad.Genis231.Mobs.savageDwarf;
import ad.Genis231.Mobs.traderDwarf;
import ad.Genis231.Mobs.warriorDwarf;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CreatureReg {
	static int baseEntityID = 1;
	public static Class[] dwarfClass = { savageDwarf.class, warriorDwarf.class, traderDwarf.class };
	public static String[] dwarfNames = { "Savage", "Warrior", "Trader" };
	
	public static void mobs() {
		// registers the mod, args: MobClass.class, max hoard, min spawned, max spawned, MobType/SpawnArea.......
		for (int i = 0; i < dwarfClass.length; i++) {
			EntityRegistry.registerModEntity(dwarfClass[i], dwarfNames[i], i, Core.instance, 80, 3, true);
			EntityRegistry.addSpawn(dwarfClass[i], 20, 20, 20, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.river);
			
			// registers egg, args: MobClass.class, hex-Main, hex-Spots
			registerNewEgg(dwarfClass[i], UniqueId(), 0xFF0000, 0xBBFF00);
			// registers name on kill screan
			LanguageRegistry.instance().addStringLocalization("entity.Artificer." + dwarfNames[i] + ".name", dwarfNames[i] + " Dwarf");
		}
	}
	
	public static int UniqueId() {
		do {
			baseEntityID++;
		} while (EntityList.getStringFromID(baseEntityID) != null);
		return baseEntityID;
	}
	
	public static void registerNewEgg(Class<? extends Entity> entity, int id, int primaryColor, int secondaryColor) {
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
