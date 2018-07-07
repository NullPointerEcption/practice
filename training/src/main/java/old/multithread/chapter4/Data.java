package old.multithread.chapter4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
    private final String fileName;//文件名称
    private String content;//文件内容
    private boolean changed;//是否改变

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println("Thread " + Thread.currentThread().getName() + "将字符串写入了文件中。Content = " + content);
        try (Writer writer = new FileWriter(fileName);) {
            writer.write(content);
        }
    }
}
