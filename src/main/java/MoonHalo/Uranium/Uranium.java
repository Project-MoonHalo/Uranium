package MoonHalo.Uranium;

import MoonHalo.Uranium.Client.ModuleManager;
import MoonHalo.Uranium.Event.Classes.TestEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;
import MoonHalo.Uranium.Client.EventManager;

@Mod(modid="uranium",name = "Uranium",version = "B1")
public class Uranium {
    public static Logger logger = LogManager.getLogger("Uranium");
    public static String CommandPrefix = ".";
    public static String ClientName = "Uranium";
    public static String ClientVersion = "B1";
    @Mod.EventHandler
    public void Preinit(FMLPreInitializationEvent Event) {
        ModuleManager.getInstance();
        EventManager.getInstance();
        Display.setTitle("Uranium");
        logger.info("Uranium Loading...");
        EventManager.PostEvent(new TestEvent());
    }
    @Mod.EventHandler
    public void Postinit(FMLPostInitializationEvent Event){
        //We no longer use that because we dont want use FML's shit event system xd
    }

}
