package ad.Genis231.Core;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import ad.Genis231.Generation.NewWorldProvider;
import ad.Genis231.Gui.GuiHandler;
import ad.Genis231.Mobs.StatueMob;
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
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Core {
	public Configuration config = null;
	
	// The instance of your mod that Forge uses.
	@Instance(Ref.MOD_ID) public static Core instance;
	
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "ad.Genis231.Core.ClientProxy", serverSide = "ad.Genis231.Core.CommonProxy") public static CommonProxy proxy;
	
	@EventHandler public void invalidFingerprint(FMLFingerprintViolationEvent event) {}
	
	@EventHandler public void fingerPrint(FMLFingerprintViolationEvent event) {
		if (event.expectedFingerprint != event.expectedFingerprint) {
			
		}
	}
	
	@EventHandler public void preInit(FMLPreInitializationEvent event) {
		new modReg(1);
		DimensionManager.registerProviderType(Ref.PortalNumber, NewWorldProvider.class, false);
	}
	
    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
        
		new modReg(2);
		DimensionManager.registerDimension(Ref.PortalNumber, Ref.PortalNumber);
		
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		EntityRegistry.registerModEntity(StatueMob.class, "StatueThing", 1, this, 80, 3, true);
		
	}
	
	@EventHandler public void postInit(FMLPostInitializationEvent event) {
		new modReg(3);
	}
	
}
