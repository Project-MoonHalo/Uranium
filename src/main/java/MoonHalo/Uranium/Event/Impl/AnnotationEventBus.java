package MoonHalo.Uranium.Event.Impl;

import MoonHalo.Uranium.Concurrent.TaskThread;
import MoonHalo.Uranium.Uranium;
import MoonHalo.Uranium.Utils.ClassUtil;
import org.jetbrains.annotations.NotNull;
import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;

public class AnnotationEventBus implements EventBusInterface{
    public AnnotationEventBus(){
        FindListener();
    }
    public void FindListener(){
        Uranium.logger.debug("Event bus is start");
        for (Class clz : ClassUtil.getClasses("MoonHalo")){
            for (Method method : clz.getMethods()){
                if(method.isAnnotationPresent(Listener.class)){
                    ListenerList.add(method);
                }
            }
        }
        ListenerList.sort(new SortListener());
    }
    public void Subscribe(Method Target){
        if(!ListenerList.contains(Target)) {
            ListenerList.add(Target);
        }
        ListenerList.sort(new SortListener());
    }
    public void Unsubscribe(Method Target){
        if(!ListenerList.contains(Target)) {
            ListenerList.remove(Target);
        }
        ListenerList.sort(new SortListener());
    }

}



class SortListener implements Comparator<Method>{


    public int compare(Method o1, Method o2) {
        return o2.getAnnotation(Listener.class).priority()-o1.getAnnotation(Listener.class).priority();
    }
}
