package old.multithread.chapter3;

import java.util.Random;

public class ClientThread extends  Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(String name, RequestQueue requestQueue,long seed) {
        super (name);
        this.requestQueue = requestQueue;
        this.random=new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request=new Request("NO."+i);
            System.out.println(Thread.currentThread().getName()+" send requests "+request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
