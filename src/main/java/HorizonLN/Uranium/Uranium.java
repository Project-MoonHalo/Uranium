package HorizonLN.Uranium;
import HorizonLN.Uranium.Modules.ModuleManager;
import HorizonLN.Uranium.Others.Test2use;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;
import HorizonLN.Uranium.Modules.ModuleManager.*;

import java.lang.reflect.Method;

@Mod(modid="uranium",name = "Uranium",version = "B1")
public class Uranium {
    public static Logger logger = LogManager.getLogger("Uranium");
    @Mod.EventHandler
    public void Preinit(FMLPreInitializationEvent Event) {
        new ModuleManager();
        Display.setTitle("Uranium");
        logger.info("Uranium Loading...");
        try {
            Test2use.class.newInstance().Use();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
