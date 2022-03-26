package MoonHalo.Uranium.Concurrent;

import MoonHalo.Uranium.Uranium;

import java.lang.reflect.InvocationTargetException;

public class TaskThread extends Thread{
    public static volatile Task runningTask;
    public static volatile Object argument;
    public static volatile Boolean FreeFlag = true;
    @Override
    public void run(){
        synchronized (this){
            try {
                FreeFlag = true;
                wait();
            } catch (InterruptedException e) {
                FreeFlag = false;
            }
            while (true) {
            try {
                runningTask.ReturnValue = runningTask.getClass().getMethod("run", Object.class).invoke(runningTask, argument);
                runningTask.Over = true;
                runningTask = null;
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                Uranium.logger.fatal("Can not invoke method "+runningTask.getClass().getName()+" !");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                FreeFlag = true;
                TaskManager.getInstance().RefreshTask();
                wait();
            } catch (InterruptedException e) {
                FreeFlag = false;
            }
        }
        }
    }
    public void setRunningTask(Task task, Object _argument){
        synchronized (this) {
            runningTask = task;
            argument = _argument;
        }
    }
}
