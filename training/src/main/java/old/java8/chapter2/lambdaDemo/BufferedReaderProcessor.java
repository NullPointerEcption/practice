package old.java8.chapter2.lambdaDemo;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Author: wangyufei
 * CreateTime:2018/02/24
 * Companion:Champion Software
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
