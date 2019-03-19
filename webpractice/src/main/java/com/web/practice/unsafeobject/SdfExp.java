package com.web.practice.unsafeobject;

import com.web.practice.util.DothingTogether;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-13 22:12
 **/
public class SdfExp {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        DothingTogether.consume((sdf)->{
            try {
                sdf.parse("20180212");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }, yyyyMMdd);
    }
}
