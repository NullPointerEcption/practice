package multithread.chapter4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Data data=new Data("D:/aaa.txt","hello");
        new ChangerThread("ChangeThread",data).start();
        new ServerThread("ServerThread",data).start();
    }
}
