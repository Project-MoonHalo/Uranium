package MoonHalo.Uranium;
import MoonHalo.Uranium.Client.ModuleManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import static MoonHalo.Uranium.Others.Test2use.Use;

@Mod(modid="uranium",name = "Uranium",version = "B1")
public class Uranium {
    public static Logger logger = LogManager.getLogger("Uranium");
    public static String CommandPrefix = ".";
    public static String ClientName = "Uranium";
    public static String ClientVersion = "B1";
    @Mod.EventHandler
    public void Preinit(FMLPreInitializationEvent Event) {
        ModuleManager.getInstance();
        Display.setTitle("Uranium");
        logger.info("Uranium Loading...");
    }
    @Mod.EventHandler
    public void Postinit(FMLPostInitializationEvent Event){
        try {
            Use();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
