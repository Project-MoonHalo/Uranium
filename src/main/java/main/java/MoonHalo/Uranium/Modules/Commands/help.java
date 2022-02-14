package MoonHalo.Uranium.Modules.Commands;

import MoonHalo.Uranium.Client.NotifyManager;
import MoonHalo.Uranium.Modules.Module;
import MoonHalo.Uranium.Others.ModuleType;
import MoonHalo.Uranium.Others.NotifyType;

public class help extends Module {
    public help() {
        super("help", ModuleType.Command);
    }
    @Override
    public void OnExecute(String[] args){
        NotifyManager.SendNotify("Hi there", NotifyType.Normal);
    }
}
