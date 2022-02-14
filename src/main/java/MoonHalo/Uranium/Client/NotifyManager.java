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
        new Notify("["+ Uranium.ClientName+"-"+type.toString()+"]"+Text);
    }
}
