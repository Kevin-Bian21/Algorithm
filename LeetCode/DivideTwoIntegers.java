package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/12/2 - 17:37
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 *
 **/
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers dti = new DivideTwoIntegers();
        System.out.println(dti.divide(-2147483648 , -2));
    }

    public int divide(int dividend, int divisor) {

        if(dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE)
            return 1;
        if(divisor == Integer.MIN_VALUE)
            return 0;

        int signed = dividend < 0 ? -1 : 1;
        signed = divisor < 0 ? -signed : signed;

        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int count = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            count ++;
        }

        System.out.println(Math.abs(Integer.MIN_VALUE));
        return count * signed;
    }
}
