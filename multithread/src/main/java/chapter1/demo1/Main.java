package chapter1.demo1;

public class Main {

    public static void main(String[] args) {
        Gate gate=new Gate();
        new UserThread(gate,"Alice","Alaska").start();
        new UserThread(gate,"Bobby","Brazil").start();
        new UserThread(gate,"Chris","Canada").start();
    }
}
