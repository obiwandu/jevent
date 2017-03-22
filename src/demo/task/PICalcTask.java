package demo.task;

import task.TaskEventEmitter;
import task.TaskExecutor;

/**
 * Created by obiwan on 2017/3/22.
 */
class PICalcTask extends TaskEventEmitter {
    private final int N;

    PICalcTask(TaskExecutor executor, int n) {
        super(executor);
        if (n < 1) throw new IllegalArgumentException("n must be larger than 0");
        this.N = n;
    }

    public int getN() {
        return N;
    }

    @Override
    protected void run() throws Exception {
        emit("next", 1);
    }
}
