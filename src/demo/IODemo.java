package demo;

import demo.task.TaskHelper;
import task.Task;
import task.TaskExecutor;
import task.TaskManager;

/**
 * Created by obiwan on 2017/3/22.
 */
public class IODemo {
    public static void main(String[] args) throws InterruptedException {
        String fileName = "info.txt";
        final TaskManager manager = new TaskManager();
        manager.start();
        TaskExecutor executor = manager.getExecutor();
        Task ioTask = TaskHelper.createIOTask(executor, fileName);
        executor.submit(ioTask);
        Thread.sleep(5000L);
        manager.stop();
    }
}
