package MoonHalo.Uranium.Client;

import MoonHalo.Uranium.Others.NotifyType;
import MoonHalo.Uranium.Uranium;

public class NotifyManager {
    private static NotifyManager instance;

    public static NotifyManager getInstance() {
        if (instance == null) instance = new NotifyManager();
        return instance;
    }
    public static void SendNotify(String Text , NotifyType type){
        switch (type){
            case Warn:
                new Notify("["+ Uranium.ClientName+" §6Warning"+"§F]"+Text);
                break;
            case Normal:
                new Notify("["+ Uranium.ClientName+" §7Normal"+"§F]"+Text);
                break;
            case Crit:
                new Notify("["+ Uranium.ClientName+" §4Critical"+"§F]"+Text);
                break;

        }
        //new Notify("["+ Uranium.ClientName+"-"+type.toString()+"]"+Text);
    }
}
