package MoonHalo.Uranium.Event.Impl;


import MoonHalo.Uranium.Event.EventBase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public interface EventBusInterface {
    List<Method> ListenerList = new ArrayList<>();
    public default void Subscribe(Method Target){
        if(!ListenerList.contains(Target)) {
            ListenerList.add(Target);
        }
    }
    public default void Unsubscribe(Method Target){
        if(!ListenerList.contains(Target)) {
            ListenerList.remove(Target);
        }
    }
    public void FindListener();
    public default void Post(EventBase event){
        for(Method method : ListenerList){
            try {
                method.invoke(method.getClass(),event);
            }catch (Exception e) {

            }
        }
    }
}
