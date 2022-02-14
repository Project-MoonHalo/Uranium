package MoonHalo.Uranium.Modules;

import MoonHalo.Uranium.Client.NotifyClass;
import MoonHalo.Uranium.Others.ModuleType;

public class Module {
    public boolean IsEnabled = false;
    protected ModuleType Category;
    protected String ModuleName;
    NotifyClass notifyManager;
    public Module(String _Name,ModuleType _Category){
       ModuleName = _Name;
       Category = _Category;
       NotifyClass notifymanager = NotifyClass.GetNotifyClass(ModuleName);
    }
    public String GetName(){
        return ModuleName;
    }
    public ModuleType GetCategory(){
        return Category;
    }

    public void OnEnable(){

    }
    public void OnDisable(){

    }

    public final void Toggle(){
        if (IsEnabled){
            IsEnabled = false;
            OnDisable();
            //Output Message here
        }
        else {
            IsEnabled = true;
            OnEnable();
            //Output message here
        }
    }
    public void OnExecute(String[] args){

    }
}
