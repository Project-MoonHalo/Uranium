package MoonHalo.Uranium.Event;

public class EventBase {
    public static boolean isCanceled = false;
    public static void Cancel(){
        isCanceled = true;

    }
}
