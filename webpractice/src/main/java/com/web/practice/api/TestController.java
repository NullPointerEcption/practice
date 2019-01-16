package com.web.practice.api;

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

}
