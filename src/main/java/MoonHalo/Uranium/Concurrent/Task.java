package MoonHalo.Uranium.Concurrent;

import MoonHalo.Uranium.Uranium;

import java.util.concurrent.Callable;

public class Task{
    public volatile Object argm;
    public volatile Object ReturnValue = null;
    public volatile Boolean Over = false;
    public Task(int priority){

    }

    public Object run(Object arg) throws Exception {
        return null;
    }
    public void setArg(Object o){
        argm = o;
    }
    public final Object getReturnValue(){
        Uranium.logger.info("Get be invoke,Now return value is "+ReturnValue);
        while (!Over){}
        return ReturnValue;
    }
}
