package jsondemos.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-04 17:23
 **/
public class Demo {
    public static void main(String[] args) {
        ImmutableMap<String, Serializable> of = ImmutableMap.of("name", "wyf", "age", 18, "toys", ImmutableList.of("apple", "banana", "peear"));
        String s = JSONObject.toJSONString(of);

        System.out.println(s);
    }
}
