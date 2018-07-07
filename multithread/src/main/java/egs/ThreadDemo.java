package egs;

public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread("wyf").start();
        new MyThread("123").start();
    }
}

class MyThread extends Thread{
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.print(name+"\t");
            if(i==100){
                System.out.print("\n");
            }
        }
    }
}