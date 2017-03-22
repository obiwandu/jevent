package task;

/**
 * Created by obiwan on 2017/3/22.
 */
/**
 * 任务执行器
 */
public interface TaskExecutor extends Task {

    /**
     * 提交一个任务
     * @param task
     */
    public void submit(Task task);
}
