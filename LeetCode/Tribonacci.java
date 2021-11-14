package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/11/14 - 19:40
 *
 * 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 **/
public class Tribonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //2082876103    10096毫秒
//        System.out.println(tribonacci(37));
        System.out.println(tribonacciWithDynamic(37)); //2082876103   0毫秒
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "毫秒");
    }
    //1. 使用递归
    public static int tribonacci(int n){
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return tribonacci(n-1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    //2. 使用动态规划
    public static int tribonacciWithDynamic(int n){
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int m = 0;
        int j = 0;
        int k = 1;
        int sum = 1;
        for (int i = 3; i <= n; i++) {
            m = j;
            j = k;
            k = sum;
            sum = m + k + j;
        }
        return sum;
    }
}
