package MoonHalo.Uranium;

import MoonHalo.Uranium.Client.ModuleManager;
import MoonHalo.Uranium.Concurrent.Task;
import MoonHalo.Uranium.Concurrent.TaskManager;
import MoonHalo.Uranium.Concurrent.TestTask;
import MoonHalo.Uranium.Event.Classes.PreLoadEvent;
import MoonHalo.Uranium.Event.Impl.AnnotationEventBus;
import MoonHalo.Uranium.Event.Impl.EventBusInterface;
import MoonHalo.Uranium.Event.Impl.Listener;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid="uranium",name = "Uranium",version = "B1")
public class Uranium {
    public static Logger logger = LogManager.getLogger("Uranium");
    public static String CommandPrefix = ".";
    public static String ClientName = "Uranium";
    public static String ClientVersion = "B1";
    public static EventBusInterface EventBus = new AnnotationEventBus();
    @Listener
    public static void OnPreinit(PreLoadEvent event) {
        ModuleManager.getInstance();
        Display.setTitle("Uranium "+ClientVersion);
        logger.info("Try to launch task");
        Task task = new TestTask();
        TaskManager.getInstance().ReleaseTask(task,null);
        Object RT = task.getReturnValue();
        logger.info(RT);
    }


}
