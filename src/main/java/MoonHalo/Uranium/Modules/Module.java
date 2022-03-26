package MoonHalo.Uranium.Modules;

import MoonHalo.Uranium.Others.ModuleInfo;
import MoonHalo.Uranium.Others.ModuleType;

public class Module {
    public boolean IsEnabled = false;

    public String GetName(){
        return getClass().getAnnotation(ModuleInfo.class).ModName();
    }
    public ModuleType GetCategory(){
        return getClass().getAnnotation(ModuleInfo.class).type();
    }
    public String GetInfo(){
        return getClass().getAnnotation(ModuleInfo.class).info();
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
