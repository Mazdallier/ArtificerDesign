package ad.Genis231.Global.Overlay;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import ad.Genis231.Player.PlayerData;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnterWorld {
	@SubscribeEvent public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			PlayerData data = PlayerData.get((EntityPlayer) event.entity);
		}
	}
}
