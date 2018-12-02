package ds;

import java.util.Arrays;

/**
 * @author wangyufei
 * @date 2018/9/22
 */
public class NumberMap {


    private static char[] numMap = new char[]{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {

        String data = "12";
        String[] mapedChars = getMapedChars(data);
        System.out.println(Arrays.toString(mapedChars));
    }

    private static String[] getMapedChars(String data) {
        if(data == null || data.contains("0")){
            return new String[]{"0"};
        }
        String[] res = {};
        StringBuilder num1 = new StringBuilder();
        char[] charDatas = data.toCharArray();
        for (int i = 0; i < charDatas.length; i++) {
            char c = numMap[Integer.parseInt(String.valueOf(charDatas[i])) - 1];
            num1.append(c);
        }
        res = new String[]{num1.toString()};

        String num2 = "";
        int dataInt = Integer.parseInt(data);
        if(dataInt<=26){
            num2 = String.valueOf(numMap[dataInt-1]);
            res = new String[]{num1.toString(), num2};
        }

        return res;
    }


}
