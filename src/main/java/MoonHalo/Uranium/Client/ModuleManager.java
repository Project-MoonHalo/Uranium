package MoonHalo.Uranium.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import MoonHalo.Uranium.Event.Classes.SendMessageEvent;
import MoonHalo.Uranium.Modules.Module;
import MoonHalo.Uranium.Others.Listener;
import MoonHalo.Uranium.Others.NotifyType;
import MoonHalo.Uranium.Uranium;
import MoonHalo.Uranium.Utils.ClassUtil;

import static MoonHalo.Uranium.Utils.ClassUtil.GetClassObject;

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
    @Listener
    public static void ListenMessageSend(SendMessageEvent event){
        String message = null;
        message = String.valueOf(GetClassObject(event,"Message"));
        Uranium.logger.info(message);
        if (message.startsWith(Uranium.CommandPrefix)) {
            Uranium.logger.info("Execute command " + message);
            try {
                ModuleManager.getModuleByName(message.replaceFirst(".", "").split(" ")[0]).OnExecute(message.replaceFirst(".", "").split(" "));
            } catch (ClassNotFoundException e) {
                Uranium.logger.info(message.replaceFirst(".", ""));
                NotifyManager.getInstance().SendNotify("Cannot found command:" + message.replaceFirst(".", "").split(" ")[0], NotifyType.Warn);
                e.printStackTrace();
            }
            event.Cancel();
        }
    }

    public ModuleManager(){
        Set<Class<?>> clzset = ClassUtil.getClasses("MoonHalo.Uranium");
        try {


            for (Class clz : clzset) {
                if (clz.getSuperclass().getName().equals("MoonHalo.Uranium.Modules.Module")) {
                    try {
                        Module module = (Module) clz.newInstance();
                        RegModule(module);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}