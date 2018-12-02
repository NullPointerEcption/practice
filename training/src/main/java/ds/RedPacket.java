package ds;

import java.util.Arrays;
import java.util.Random;

/**
 * Author:wangyufei
 * CreateTime: 2018/7/6
 * 红包模拟算法
 */
public class RedPacket {

    static int maxBound = 500;

    /**
     * 分红包
     *
     * @param money 总共多少钱 （以分为单位）
     * @param count 一共多少人
     * @return 每个人抢到的金额
     */
    public static long[] splitMoney(long money, int count) {
        long[] moneyToEveyOne = new long[count];

        initMoney(money, count, moneyToEveyOne);

        Random random = new Random();

        for (int i = 0; i < 200; i++) {

            int peopleIndexFrom = random.nextInt(count);//随机获取一个人
            int peopleIndexTo = random.nextInt(count);//随机获取一个人

            int radMoney = random.nextInt(maxBound);//随机的金额

            if (moneyToEveyOne[peopleIndexFrom] - radMoney <= 0) {
                continue;
            }

            moneyToEveyOne[peopleIndexFrom] -= radMoney;
            moneyToEveyOne[peopleIndexTo] += radMoney;

        }


        return moneyToEveyOne;
    }

    /**
     * 初始化金钱 先让每个人都获得差不多的金额
     *
     * @param money          总金额
     * @param count          人数
     * @param moneyToEveyOne 待分配的每个人的金额
     */
    private static void initMoney(long money, int count, long[] moneyToEveyOne) {
        long avgMoney = money / count;//有可能有余数 后面处理
        for (int i = 0; i < count; i++) {
            moneyToEveyOne[i] = avgMoney;
        }
        moneyToEveyOne[count - 1] += money % count;//把余数加到最后一个人的钱里面
    }

    public static void main(String[] args) {
        long money = 100 * 100;//一百元
        int count = 7; //五个人
        long[] moneys = splitMoney(money, count);
        System.out.println(Arrays.toString(moneys));
        System.out.println("总金额：" + Arrays.stream(moneys).sum());
    }


}
