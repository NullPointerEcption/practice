package old.util;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-08 20:28
 **/
public class LambdaTest {

    public static void main(String[] args) {
        ArrayList<Consumer<String>> objects = new ArrayList<>();
        objects.add((s) -> {
            System.out.println(s + "hello");
        });
        objects.add((s) -> {
            System.out.println(s + "hello111");
        });
        objects.add((s) -> {
            System.out.println(s + "hello222");
        });
        objects.add((s) -> {
            System.out.println(s + "hello333");
        });
        for (Consumer object : objects) {
            object.accept("sdsdsd");
        }

        ArrayList<String> strings = new ArrayList<String>() {{
            add("121"); add("bbb"); add("ccc");
        }};
    }
}
