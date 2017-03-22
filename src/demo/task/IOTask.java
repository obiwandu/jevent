package demo.task;

import task.TaskEventEmitter;
import task.TaskExecutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by obiwan on 2017/3/22.
 */
class IOTask extends TaskEventEmitter {
    final private String fileName;
    final private String encoding;

    public IOTask(TaskExecutor executor, String fileName, String encoding) {
        super(executor);
        this.fileName = fileName;
        this.encoding = encoding;
    }

    public String getFileName() {
        return fileName;
    }

    public String getEncoding() {
        return encoding;
    }

    @Override
    protected void run() throws Exception {
        InputStream fis = this.getClass().getResourceAsStream("/" + fileName);

        if (fis != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, encoding));
            emit("open", getFileName());
            emit("next", reader);
        }else{
            throw new FileNotFoundException(fileName);
        }
    }
}
