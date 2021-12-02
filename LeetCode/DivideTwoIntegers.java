package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/12/2 - 17:37
 **/
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers dti = new DivideTwoIntegers();
        System.out.println(dti.divide(-2147483648 , 1));
    }

    public int divide(int dividend, int divisor) {

        long count = 0;
        int unsigned = 1;
        if (dividend < 0 && divisor > 0)
            unsigned = -1;
        if ( dividend > 0 && divisor < 0)
            unsigned = -1;

        long a = dividend;
        long b = divisor;
        a = Math.abs(a);
        b = Math.abs(b);

        while (a >= b) {
            a -= b;
            count ++;
        }

        if ((count * unsigned) > Integer.MAX_VALUE || (count * unsigned) < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        return (int) count * unsigned;
    }
}
