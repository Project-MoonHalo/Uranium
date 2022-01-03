package HorizonLN.Uranium.Modules;

import java.util.ArrayList;
import java.util.List;

import HorizonLN.Uranium.Modules.Modules.Combat.TestAttack;
import HorizonLN.Uranium.Uranium;

public class ModuleManager {
    public List<Module> ModuleList = new ArrayList<>();
    public void RegModule(Module ModuleClass){
        ModuleList.add(ModuleClass);
    }
    public Module getModuleByName(String targetName) {
        if (ModuleList.lastIndexOf(targetName) == -1) {
            Uranium.logger.error("Module Not Found!");
            return ModuleList.get(0);
        }
            else{
            Module Clazz = ModuleList.get(ModuleList.lastIndexOf(targetName));
            return Clazz;
        }
    }
    public ModuleManager(){
        RegModule(new TestAttack());
    }
}