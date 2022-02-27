package MoonHalo.Uranium.Client;

import MoonHalo.Uranium.Event.EventBase;
import MoonHalo.Uranium.Others.EventGetter;
import MoonHalo.Uranium.Others.Listener;
import MoonHalo.Uranium.Uranium;
import net.minecraftforge.fml.common.eventhandler.ListenerList;
import MoonHalo.Uranium.Utils.ClassUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Method;
import java.util.Set;

public class EventManager {
    private static EventManager instance;
    public static List<Method> ListenerList = new ArrayList<>();
    public static List<Class> ListenerClassesList;
    public static EventManager getInstance() {
        if (instance == null) instance = new EventManager();
        return instance;
    }

    public void RegisterListener(Method method){
        ListenerList.add(method);
    }
    public void UnregisterListener(Method method){
        ListenerList.remove(method);
    }
    public EventManager(){
        //NONE
        try {
            Set<Class<?>> ClassSet = ClassUtil.getClasses("MoonHalo.Uranium");
            for (Class clazz:ClassSet){
                for (Method method :clazz.getMethods()){
                    if(method.isAnnotationPresent(Listener.class)){
                        RegisterListener(method);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void PostEvent(EventBase event) {
        for(Method method : ListenerList){
            try {
            method.invoke(method.getClass(),event);
            }catch (Exception e){

            }
        }
    }
}
