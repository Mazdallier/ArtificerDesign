package ad.Genis231.Core;

import net.minecraftforge.common.Configuration;
import ad.Genis231.Gui.GuiHandler;
import ad.Genis231.lib.ADLog;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Core {
	public Configuration config = null;
	
	// The instance of your mod that Forge uses.
	@Instance(Ref.MOD_ID)
	public static Core instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "ad.Genis231.Core.ClientProxy", serverSide = "ad.Genis231.Core.CommonProxy")
	public static CommonProxy proxy;
	
	@Deprecated
	@EventHandler
	public void invalidFingerprint(FMLFingerprintViolationEvent event) {}
	
	@Deprecated
	@EventHandler
	public void fingerPrint(FMLFingerprintViolationEvent event) {
		if (event.expectedFingerprint != event.expectedFingerprint) {}
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ADLog.initLog();
		
		ModReg.basic();
		ModReg.recipeGReg();
		ModReg.Worlds();
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		
		ModReg.Modifiers();
		CreatureReg.mobs();
		
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
}
