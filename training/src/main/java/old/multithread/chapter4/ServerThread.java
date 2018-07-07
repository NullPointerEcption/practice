package old.multithread.chapter4;

import java.io.IOException;

public class ServerThread extends Thread {
    private final Data data;

    public ServerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                data.save();
                Thread.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
