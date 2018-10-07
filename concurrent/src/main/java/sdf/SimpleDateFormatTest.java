package sdf;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author wangyufei
 * @date 2018/9/26
 */
public class SimpleDateFormatTest {
    //(1)创建单例实例
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static ThreadLocal<SimpleDateFormat> sdf2 = new ThreadLocal<SimpleDateFormat>();
//    {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        }
//    };

    static {
        sdf2.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args) {
//        //(2)创建多个线程，并启动
//        for (int i = 0; i <10 ; ++i) {
//            Thread thread = new Thread(new Runnable() {
//                public void run() {
//                    try {//(3)使用单例日期实例解析文本
//                        System.out.println(sdf2.get().parse("2017-12-13 15:17:27"));
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            thread.start();//(4)启动线程
//        }


        System.out.println(sdf2.get());

        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    //
                    System.out.println(sdf2.get());
                }
            }.start();
        }


    }
}
