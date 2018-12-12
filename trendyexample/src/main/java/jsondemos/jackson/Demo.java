package jsondemos.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2018-12-04 15:04
 **/
public class Demo {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        //格式化
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            ImmutableMap<String, Serializable> of = ImmutableMap.of("name", "wyf", "age", 18, "toys", ImmutableList.of("apple", "banana", "peear"));
            String s = objectMapper.writeValueAsString(of);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
