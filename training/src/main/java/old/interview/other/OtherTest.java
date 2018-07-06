package old.interview.other;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: wangyufei
 * CreateTime:2018/03/05
 * Companion:Champion Software
 */
public class OtherTest {

    @Test
    public void method() {
        Map<String,Integer> map=new HashMap<>();
        map.put(null,123);
        Integer val = map.get(null);
        System.out.println(val);
    }
}
