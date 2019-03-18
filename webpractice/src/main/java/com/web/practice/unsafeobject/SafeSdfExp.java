package com.web.practice.unsafeobject;

import com.web.practice.util.DothingTogether;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-13 22:12
 **/
public class SafeSdfExp {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DothingTogether.consume((d) -> {
            TemporalAccessor parse = d.parse("2018-02-12");
            System.out.println(Thread.currentThread().getId() + "---" + parse);

        }, dateTimeFormatter);
    }
}
