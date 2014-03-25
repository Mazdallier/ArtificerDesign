package ad.Genis231.Research.Player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnterWorld {
	@SubscribeEvent public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			// PlayerData.get((EntityPlayer) event.entity).sync();
		}
	}
}
