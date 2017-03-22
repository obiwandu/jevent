package demo;

import demo.task.GuardTask;
import demo.task.TaskHelper;
import event.EventHandler;
import event.EventObject;
import task.TaskEventEmitter;
import task.TaskExecutor;
import task.TaskManager;

/**
 * Created by obiwan on 2017/3/22.
 */
public class CompoundTaskDemo {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        TaskExecutor executor = manager.getExecutor();
        manager.start();
        TaskEventEmitter ioTask = TaskHelper.createIOTask(executor, "info.txt");
        TaskEventEmitter piTask = TaskHelper.createPiTask(executor, 100);
        final TaskEventEmitter guardTask = new GuardTask(manager, 2);
        EventHandler handler = new EventHandler() {
            @Override
            public void handle(EventObject event) {
                guardTask.emit("end");
            }
        };
        ioTask.on("close",handler);
        piTask.on("finish", handler);
        executor.submit(ioTask);
        executor.submit(piTask);
        executor.submit(guardTask);

    }
}
