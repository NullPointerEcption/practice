package com.web.practice.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-12 21:39
 **/
public class EnumImpl {

    private EnumImpl() {
    }

    public static EnumImpl getInstance() {
        return MySingleTon.INSTANCE.getAnEnumInstance();
    }

    private enum MySingleTon {
        INSTANCE;

        private EnumImpl anEnum;

        //JVM保证该方法只会调用一次
        MySingleTon() {
            System.out.println("init enum");
            anEnum = new EnumImpl();
        }


        public EnumImpl getAnEnumInstance() {
            return anEnum;
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                EnumImpl anEnum = EnumImpl.getInstance();
                System.out.println(anEnum.hashCode());
            });
        }
        executorService.shutdown();
    }

}
