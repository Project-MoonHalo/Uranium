package HorizonLN.Uranium.Others;
import HorizonLN.Uranium.Modules.ModuleManager;
public class Test2use {
    public void Use() throws InstantiationException, IllegalAccessException {
        ModuleManager.class.newInstance().getModuleByName("TestAttack").OnEnable();
    }
}
