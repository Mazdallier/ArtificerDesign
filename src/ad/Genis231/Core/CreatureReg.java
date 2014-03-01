package ad.Genis231.Core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import ad.Genis231.Mobs.savageDwarf;
import ad.Genis231.Mobs.traderDwarf;
import ad.Genis231.Mobs.warriorDwarf;
import ad.Genis231.lib.Names;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CreatureReg {
	static int baseEntityID = 1;
	public static Class[] dwarfClass = { savageDwarf.class, warriorDwarf.class, traderDwarf.class };
	
	public static void mobs() {
		for (int i = 0; i < dwarfClass.length; i++) {
			EntityRegistry.registerModEntity(dwarfClass[i], Names.dwarf[i], i, Core.instance, 80, 3, true);
			
			// registers the mod, args: modName, maxHoard, min spawned, max spawned, MobType/SpawnArea
			EntityRegistry.addSpawn(dwarfClass[i], 3, 20, 50, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.river);
			
			// registers egg, args: MobClass.class, hex-Main, hex-Spots
			registerNewEgg(dwarfClass[i], UniqueId(), 0xFF0000, 0xBBFF00);
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
