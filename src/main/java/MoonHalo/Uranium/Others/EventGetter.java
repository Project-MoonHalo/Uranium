package MoonHalo.Uranium.Others;

import MoonHalo.Uranium.Event.EventBase;
import MoonHalo.Uranium.Uranium;

public class EventGetter {
    @Listener
    public static void GetE(EventBase event){
        Uranium.logger.info("We get Event!");
    }
}
