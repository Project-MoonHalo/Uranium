package HorizonLN.Uranium.Modules;

import java.util.ArrayList;
import java.util.List;

import HorizonLN.Uranium.Modules.Modules.Combat.TestAttack;
import HorizonLN.Uranium.Uranium;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.network.internal.FMLMessage;

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
        RegModule(new TestAttack());
    }
    //@Mod.EventHandler
    //public void MessageProcess(FMLevent)
}