package com.web.practice.unsafeobject;

import com.web.practice.anno.ThreadUnSafe;
import com.web.practice.util.DothingTogether;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-13 22:07
 **/
@ThreadUnSafe
public class StringBuilderExp {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        DothingTogether.consume((s) -> {
            s.append("1");
        }, sb);
        System.out.println(sb.length());
    }
}
