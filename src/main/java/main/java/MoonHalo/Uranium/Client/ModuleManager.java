package MoonHalo.Uranium.Client;

import java.util.ArrayList;
import java.util.List;

import MoonHalo.Uranium.Modules.Commands.help;
import MoonHalo.Uranium.Modules.Modules.Combat.TestAttack;
import MoonHalo.Uranium.Modules.Module;
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
            Uranium.logger.info(ModuleNameList.get(0));
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

    public ModuleManager(){
        RegModule(new TestAttack()); //RegModule at here.
        RegModule(new help());
    }
    //@Mod.EventHandler
    //public void MessageProcess(FMLevent)
}