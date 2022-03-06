package MoonHalo.Uranium;

import MoonHalo.Uranium.Client.ModuleManager;
import MoonHalo.Uranium.Event.Classes.LoadEvent;
import MoonHalo.Uranium.Others.Listener;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid="uranium",name = "Uranium",version = "B1")
public class Uranium {
    public static Logger logger = LogManager.getLogger("Uranium");
    public static String CommandPrefix = ".";
    public static String ClientName = "Uranium";
    public static String ClientVersion = "B1";
    @Listener
    public static void Oninit(LoadEvent event) {
        ModuleManager.getInstance();
        Display.setTitle("Uranium");
    }

}
