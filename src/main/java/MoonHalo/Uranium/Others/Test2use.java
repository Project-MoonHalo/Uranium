package MoonHalo.Uranium.Others;
import MoonHalo.Uranium.Client.ModuleManager;

public class Test2use {
    public static void Use() throws InstantiationException, IllegalAccessException {
        try {
            ModuleManager.getModuleByName("TestAttack").OnEnable();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
