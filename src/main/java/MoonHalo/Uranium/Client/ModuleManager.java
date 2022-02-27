package MoonHalo.Uranium.Client;

import java.util.ArrayList;
import java.util.List;

import MoonHalo.Uranium.Event.Classes.SendMessageEvent;
import MoonHalo.Uranium.Modules.Commands.help;
import MoonHalo.Uranium.Modules.Commands.toggle;
import MoonHalo.Uranium.Modules.Modules.Combat.TestAttack;
import MoonHalo.Uranium.Modules.Module;
import MoonHalo.Uranium.Others.Listener;
import MoonHalo.Uranium.Others.NotifyType;
import MoonHalo.Uranium.Uranium;

public class ModuleManager {
    public static List<Module> ModuleList = new ArrayList<>();
    public static List<String> ModuleNameList = new ArrayList<>();
    private static ModuleManager instance;
    public void RegModule(Module ModuleClass){
        ModuleNameList.add(ModuleClass.GetName());
        ModuleList.add(ModuleClass);
    }

    public static Module getModuleByName(String targetName) throws ClassNotFoundException {
        if (ModuleNameList.lastIndexOf(targetName) == -1) {
            Uranium.logger.error("Module Not Found!");
            throw new ClassNotFoundException("Module Not Found!");

        }
            else{
            Module Clazz = ModuleList.get(ModuleNameList.lastIndexOf(targetName));
            return Clazz;
        }
    }
    public static ModuleManager getInstance() {
        if (instance == null) instance = new ModuleManager();
        return instance;
    }
    //if a message send,this method will be call.
    public static boolean MessageSendHook(String message) {
        if (message.startsWith(Uranium.CommandPrefix)) {
            Uranium.logger.info("Execute command " + message);
            try {
                ModuleManager.getModuleByName(message.replaceFirst(".", "").split(" ")[0]).OnExecute(message.replaceFirst(".", "").split(" "));
                //getModuleByName("Help").OnExecute("hithere,hithere".split(","));
            } catch (ClassNotFoundException e) {
                Uranium.logger.info(message.replaceFirst(".", ""));
                NotifyManager.getInstance().SendNotify("Cannot found command:" + message.replaceFirst(".", "").split(" ")[0], NotifyType.Warn);
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public ModuleManager(){
        RegModule(new TestAttack()); //RegModule at here.
        RegModule(new help());
        RegModule(new toggle());
    }
    //@Mod.EventHandler
    //public void MessageProcess(FMLevent)
}