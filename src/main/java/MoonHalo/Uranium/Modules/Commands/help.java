package MoonHalo.Uranium.Modules.Commands;

import MoonHalo.Uranium.Client.NotifyManager;
import MoonHalo.Uranium.Modules.Module;
import MoonHalo.Uranium.Others.ModuleInfo;
import MoonHalo.Uranium.Others.ModuleType;
import MoonHalo.Uranium.Others.NotifyType;
@ModuleInfo(ModName = "help",type = ModuleType.Command,info = "Commands Help.")
public class help extends Module {
    @Override
    public void OnExecute(String[] args){
        NotifyManager.SendNotify("Hi there", NotifyType.Normal);
    }
}
