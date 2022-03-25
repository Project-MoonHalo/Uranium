package MoonHalo.Uranium.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import MoonHalo.Uranium.Event.Classes.SendMessageEvent;
import MoonHalo.Uranium.Modules.Module;
import MoonHalo.Uranium.Event.Impl.Listener;
import MoonHalo.Uranium.Others.NotifyType;
import MoonHalo.Uranium.Uranium;
import org.jetbrains.annotations.NotNull;

import static MoonHalo.Uranium.Utils.ClassUtil.GetClassObject;
import static MoonHalo.Uranium.Utils.ClassUtil.getClasses;

public class ModuleManager {
    public static @NotNull List<Module> ModuleList = new ArrayList<>();
    public static @NotNull List<String> ModuleNameList = new ArrayList<>();
    private static ModuleManager instance;

    public void RegModule(Module ModuleClass){
        ModuleList.add(ModuleClass);
    }

    public static @NotNull Module getModuleByName(String targetName) throws ClassNotFoundException {
        for (Module module:ModuleList){
            Uranium.logger.info(module.GetName());
            if(module.GetName().equals(targetName)) {return module;}
        }
        throw new ClassNotFoundException();
    }
    public static ModuleManager getInstance() {
        if (instance == null) instance = new ModuleManager();
        return instance;
    }
    //if a message send,this method will be call.
    @Listener
    public static void ListenMessageSend(@NotNull SendMessageEvent event){
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
        Set<Class<?>> classesset = getClasses("MoonHalo.Uranium");
        for (Class clz:classesset){
            if(clz.getSuperclass()==Module.class){
                try {
                    RegModule((Module) clz.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}