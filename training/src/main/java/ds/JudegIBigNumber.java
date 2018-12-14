package ds;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;

import java.time.LocalDateTime;

/**
 * @author wangyufei
 * @date 2018/12/2
 * @description 判断一个数是否存在于一个非常非常大的一堆数中
 */
public class JudegIBigNumber {

    public static void main(String[] args) {
        //bloomDemo();

        //10101 21
        //01010 10
        //11111 31

        int i = 21;
        i |= 10;
        System.out.println(i);

    }

    private static void bloomDemo() {
        long start = System.currentTimeMillis();
        BloomFilter<Integer> bloomFilter = BloomFilter.create(
                Funnels.integerFunnel(), 10_000_000, 0.01);
        for (int i = 0; i < 10_000_000; i++) {
            bloomFilter.put(i);
        }


        Assert.assertTrue(bloomFilter.mightContain(1));
        Assert.assertTrue(bloomFilter.mightContain(2));
        Assert.assertTrue(bloomFilter.mightContain(3));
        Assert.assertTrue(bloomFilter.mightContain(123455));

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
