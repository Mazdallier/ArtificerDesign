package ad.Genis231.lib;

import java.util.logging.Level;
import java.util.logging.Logger;
import cpw.mods.fml.common.FMLLog;

public class ADLog {
    
    public static final Logger logger = Logger.getLogger("Arificer's Design");
    
    public static void initLog() {
        logger.setParent(FMLLog.getLogger());
        
    }
}
