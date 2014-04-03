package ad.Genis231.Core;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import ad.Genis231.Global.Overlay.EnterWorld;
import ad.Genis231.Global.Overlay.ResearchPointsOverlay;
import ad.Genis231.Gui.Resources.GuiHandler;
import ad.Genis231.Network.PacketPipeline;
import ad.Genis231.Player.RegisterPlayerData;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.MOD_VERSION) public class Artificer {
	public static PacketPipeline packets = new PacketPipeline();
	
	@Instance(Ref.MOD_ID) public static Artificer instance;
	
	@SidedProxy(clientSide = "ad.Genis231.Core.ClientProxy", serverSide = "ad.Genis231.Core.CommonProxy") public static CommonProxy proxy;
	
	@EventHandler public void preInit(FMLPreInitializationEvent event) {
		MainReg.Core();
		MainReg.Recipes();
		
	}
	
	@EventHandler public void load(FMLInitializationEvent event) {
		packets.initalise();
		proxy.registerRenderers();
		MainReg.mobs();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	
	@EventHandler public void postInit(FMLPostInitializationEvent event) {
		packets.postInitialise();
		
		MinecraftForge.EVENT_BUS.register(new RegisterPlayerData());
		MinecraftForge.EVENT_BUS.register(new EnterWorld());
		
		// MinecraftForge.EVENT_BUS.register(new ClassStats(Minecraft.getMinecraft()));
		
		if (event.getSide() == Side.CLIENT) {
			MinecraftForge.EVENT_BUS.register(new ResearchPointsOverlay(Minecraft.getMinecraft()));
		}
	}
}
