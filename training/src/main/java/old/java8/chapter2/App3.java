package old.java8.chapter2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 */
public class App3 {
    public static void main(String[] args)throws IOException {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a runnable implement...");
            }
        };

        Runnable r2=()-> System.out.println("lambda implement Runnable Interface...");

//        r.run();
//        r2.run();

        String line = processFile();
        System.out.println(line);


    }

    public  static  String processFile() throws  IOException{
        try (
                BufferedReader br=new BufferedReader(new FileReader("D:\\a.txt"));
        ){
           return  br.readLine();
        }
    }
}
