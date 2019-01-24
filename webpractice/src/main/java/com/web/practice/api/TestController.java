package com.web.practice.api;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.web.practice.param.QueryParam;
import com.web.practice.param.UserParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testGet(QueryParam<UserParam> queryParam) {
        System.out.println(queryParam);
        return "hello";
    }

    @GetMapping
    public void test() {
        Cache<Object, Object> build = CacheBuilder.newBuilder().build();
        build.put("a", "aa");
    }

}
