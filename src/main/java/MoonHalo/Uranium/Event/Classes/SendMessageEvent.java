package MoonHalo.Uranium.Event.Classes;

import MoonHalo.Uranium.Event.EventBase;

public class SendMessageEvent extends EventBase {
    static String Message = null;
    public SendMessageEvent(String msg){
        Message = msg;
    }
}
