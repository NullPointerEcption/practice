package myhashmap;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(5, 0.75f);
        map.put("1", 1);
        map.put("2", 3);
        map.put("3", 3);
        map.put("4", 3);
        map.put("5", 3);
        map.put("6", 3);
        map.put("7", 3);
        map.put("8", 3);
        map.put("9", 3);
        map.put("10", 3);
        map.put("11", 3);
        map.put("12", 3);

        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
        System.out.println(map.get("3"));
        System.out.println(map.get("4"));
        System.out.println(map.get("5"));
        System.out.println(map.get("6"));
        System.out.println(map.get("7"));
        System.out.println(map.get("8"));
        System.out.println(map.get("9"));
        System.out.println(map.get("10"));
        System.out.println(map.get("11"));
        System.out.println(map.get("12"));



    }
}
