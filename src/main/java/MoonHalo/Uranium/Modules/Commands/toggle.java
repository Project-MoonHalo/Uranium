package MoonHalo.Uranium.Modules.Commands;

import MoonHalo.Uranium.Client.ModuleManager;
import MoonHalo.Uranium.Client.NotifyManager;
import MoonHalo.Uranium.Modules.Module;
import MoonHalo.Uranium.Others.ModuleInfo;
import MoonHalo.Uranium.Others.ModuleType;
import MoonHalo.Uranium.Others.NotifyType;
@ModuleInfo(ModName = "toggle",type = ModuleType.Command,info = "Enable/Disable Module.")
public class toggle extends Module {
    @Override
    public void OnExecute(String[] args){
        try {
            ModuleManager.getModuleByName(args[1]).Toggle();
        } catch (Exception e) {
            NotifyManager.SendNotify("Can not found module", NotifyType.Warn);
            e.printStackTrace();
        }
    }
}
