package guava;

import com.google.common.io.Files;
import com.google.common.reflect.Invokable;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-29 13:58
 **/
public class ListenableFutureDmeo {

    public static void main(String[] args) {
        //Iterable<String> split = Splitter.on(",").split("a,b,c,d,,,,e,f,g,    hx ");
        //for (String s : split) {
        //    System.out.println(s);
        //}
        //System.out.println("\n\n");
        //Arrays.stream("a,b,c,d,,,,e,f,g,    hx ".split(",")).forEach(System.out::println);

        String s = Files.simplifyPath("C:\\Users\\Administrator\\Documents\\Tencent Files/1159905228\\FileRecv");
        System.out.println(s);

        Invokable.from(Object.class.getMethods()[0]).isPublic();
    }
}
