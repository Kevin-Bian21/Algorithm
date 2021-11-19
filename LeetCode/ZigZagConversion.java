package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/11/19 - 23:13
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 输出："PAHNAPLSIIGYIR"
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 **/
public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PA", 2));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int index = 1;
        int num = 0;
        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if ( index == 1)
                    num = 1;
                if (index == numRows)
                    num = -1;
                if (i == index)
                    sb.append(s.charAt(j));
                index += num;
            }
            index = 1;
        }
        return sb.toString();
    }
}
