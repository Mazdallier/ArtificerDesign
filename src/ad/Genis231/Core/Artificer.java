package ad.Genis231.Core;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import ad.Genis231.Global.Overlay.ClassStats;
import ad.Genis231.Gui.GuiHandler;
import ad.Genis231.Network.PacketPipeline;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.MOD_VERSION) public class Artificer {
	
	public static final PacketPipeline packets = new PacketPipeline();
	
	// The instance of your mod that Forge uses.
	@Instance(Ref.MOD_ID) public static Artificer instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "ad.Genis231.Core.ClientProxy", serverSide = "ad.Genis231.Core.ServerProxy") public static ServerProxy proxy;
	
	@EventHandler public void preInit(FMLPreInitializationEvent event) {
		MainReg.basic();
		MainReg.recipeGReg();
		MainReg.Worlds();
		
	}
	
	@EventHandler public void load(FMLInitializationEvent event) {
		packets.initalise();
		proxy.registerRenderers();
		CreatureReg.mobs();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	
	@EventHandler public void postInit(FMLPostInitializationEvent event) {
		packets.postInitialise();
		
		if (event.getSide().isClient()) {
			MinecraftForge.EVENT_BUS.register(new ClassStats(Minecraft.getMinecraft()));
			// MinecraftForge.EVENT_BUS.register(new InventoryOverlay(Minecraft.getMinecraft()));
		}
	}
}
