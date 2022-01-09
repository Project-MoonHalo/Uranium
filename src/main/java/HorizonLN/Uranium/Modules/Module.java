package HorizonLN.Uranium.Modules;

import HorizonLN.Uranium.Others.ModuleType;

public class Module {
    public boolean IsEnabled = false;
    protected ModuleType Category;
    protected String ModuleName;

    public Module(String _Name,ModuleType _Category){
       ModuleName = _Name;
       Category = _Category;
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
}
