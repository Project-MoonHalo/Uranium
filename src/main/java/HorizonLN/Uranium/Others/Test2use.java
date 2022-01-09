package HorizonLN.Uranium.Others;
import HorizonLN.Uranium.Modules.ModuleManager;
public class Test2use {
    public static void Use() throws InstantiationException, IllegalAccessException {
        try {
            ModuleManager.getModuleByName("TestAttack").OnEnable();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
