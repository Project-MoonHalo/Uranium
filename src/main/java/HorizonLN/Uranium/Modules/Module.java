package HorizonLN.Uranium.Modules;

import HorizonLN.Uranium.Others.ModuleType;

public class Module {
    public boolean IsEnabled = false;
    private ModuleType Category;
    private String ModuleName;
    public Module(String _Name,ModuleType _Category){
        _Name = ModuleName;
        _Category = Category;
    }
    public String GetName(){
        return ModuleName;
    }
    public ModuleType getCategory(){
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
