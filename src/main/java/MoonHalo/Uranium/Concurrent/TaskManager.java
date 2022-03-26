package MoonHalo.Uranium.Concurrent;

import MoonHalo.Uranium.Uranium;
import scala.collection.parallel.ParIterableLike;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager {
    public static final int workingThreads = Runtime.getRuntime().availableProcessors();
    public volatile static List<Task> taskList = new ArrayList<>();
    public volatile static List<TaskThread> threadList = new ArrayList<>();
    private static TaskManager instance;
    public static TaskManager getInstance(){
            if (instance == null) instance = new TaskManager();
            return instance;
    }
    public void ReleaseTask(Task task,Object args){
        taskList.add(task);
        RefreshTask();
    }
    public void RefreshTask() {
        Uranium.logger.debug("Refresh!");
        for(Task task : taskList){
            for(TaskThread thread:threadList){
                if(thread.FreeFlag){
                    taskList.remove(task);
                    thread.setRunningTask(task,task.argm);
                    thread.interrupt();
                    break;
                }
            }
            break;
        }
        //Invoke this method can make free thread get task and run.
    }
    public TaskManager(){
        int i = 0;
        while (i != workingThreads) {
            TaskThread Test = new TaskThread();
            Test.start();
            threadList.add(Test);
            i=i+1;
        }
    }
}