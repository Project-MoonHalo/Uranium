package MoonHalo.Uranium.Event.Impl;

import MoonHalo.Uranium.Utils.ClassUtil;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;

public class AnnotationEventBus implements EventBusInterface{
    public AnnotationEventBus(){
        FindListener();
    }
    public void FindListener(){
        try {
            Set<Class<?>> ClassSet = ClassUtil.getClasses("MoonHalo.Uranium");
            for (Class clazz:ClassSet){
                for (Method method :clazz.getMethods()){
                    if(method.isAnnotationPresent(Listener.class)){
                        Subscribe(method);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
