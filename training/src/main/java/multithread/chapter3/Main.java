package multithread.chapter3;

public class Main {
    public static void main(String[] args) {
        RequestQueue queue=new RequestQueue();
        new ClientThread("clientThread",queue,1232244L).start();
        new ServerThread("serverThread",queue,3345244L).start();
    }
}
