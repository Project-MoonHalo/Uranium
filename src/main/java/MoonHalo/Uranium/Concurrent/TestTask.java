package MoonHalo.Uranium.Concurrent;

import MoonHalo.Uranium.Uranium;

public class TestTask extends Task {
    @Override
    public Object run(Object arg) throws Exception{
        Uranium.logger.info("Start sleep.");
        Thread.currentThread().sleep(6000);
        Uranium.logger.info("Fuck off thread pool!");
        Uranium.logger.debug(TaskManager.getInstance().taskList.toString());
        return "This is return for run.";
    }
    public TestTask(){
        super(10000);
    }

}
