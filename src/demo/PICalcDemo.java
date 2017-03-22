package demo;

import demo.task.TaskHelper;
import task.Task;
import task.TaskExecutor;
import task.TaskManager;

/**
 * Created by obiwan on 2017/3/22.
 */
 /* π/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + … + (-1)^(n-1)/(2*n-1)
 */
public class PICalcDemo {
    public static void main(String[] args) {
        final TaskManager manager = new TaskManager();
        manager.start();
        TaskExecutor executor = manager.getExecutor();
        Task piTask = TaskHelper.createPiTask(executor, 10000);
        executor.submit(piTask);
    }

}


