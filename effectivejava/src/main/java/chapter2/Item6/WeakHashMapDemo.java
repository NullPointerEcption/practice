package chapter2.Item6;

import java.util.WeakHashMap;

/**
 * @author wangyufei
 * @version 2018/10/15 16:48
 * @description
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        WeakHashMap<String,Integer> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("1",1);
        weakHashMap.put("2",2);
        weakHashMap.put("3",3);
        weakHashMap.put("4",4);
    }

}
