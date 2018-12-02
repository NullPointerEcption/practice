package chapter4;

import org.testng.collections.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @author wangyufei
 * @date 2018/11/5
 */
public class Item13 {

    public static void main(String[] args) {
        System.out.println(Demo.VALUES.size());
        Demo.VALUES.add("aa");
        System.out.println(Demo.VALUES.size());

        Demo.getValues2().add("11");
        System.out.println(Demo.getValues2().size());
    }

}

class Demo {

    //unsafe
    public static final List<String> VALUES = Lists.newArrayList("aa","bb","cc");

    private static final List<String> VALUES2 = Lists.newArrayList("aa","bb","cc");

    public static List<String> getValues2(){
        return Collections.unmodifiableList(VALUES2);
    }


}
