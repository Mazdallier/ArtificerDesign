package ad.Genis231.Player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RegisterPlayerData {
	@SubscribeEvent public void onEntityConstructing(EntityConstructing event) {
		
		Entity player = event.entity;
		
		if (player instanceof EntityPlayer && PlayerData.get((EntityPlayer) player) == null)
			PlayerData.register((EntityPlayer) player);
		
		if (player instanceof EntityPlayer && player.getExtendedProperties(PlayerData.PlayerData_ID) == null)
			player.registerExtendedProperties(PlayerData.PlayerData_ID, new PlayerData((EntityPlayer) player));
		
		if (player instanceof EntityPlayer && PlayerResearch.get((EntityPlayer) player) == null)
			PlayerResearch.register((EntityPlayer) player);
		
		if (player instanceof EntityPlayer && player.getExtendedProperties(PlayerResearch.PlayerData_ID) == null)
			player.registerExtendedProperties(PlayerResearch.PlayerData_ID, new PlayerResearch((EntityPlayer) player));
	}
}
