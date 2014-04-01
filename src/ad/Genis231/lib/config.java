package ad.Genis231.lib;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class config {
	Configuration config;
	String blah = "THIS IS A CONFIG FILE THAT JUST WASTES SPACE!!!! MYAHAHAHAHAHAAHAH";
	
	public config(FMLPreInitializationEvent event) {
		this.config = new Configuration(event.getSuggestedConfigurationFile(), false);
		this.config.load();
		
		Property prop = this.config.get(config.CATEGORY_GENERAL, "blag", blah);
		
		prop.comment = blah;
		
		this.config.save();
	}
}
