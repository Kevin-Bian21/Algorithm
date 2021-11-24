package LeetCode.DynamicProgamming;

/**
 * @author BianWenKai
 * @DATE 2021/11/24 - 12:14
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，
 * 后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 *
 *输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 **/
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibWithRecursion(10));
        System.out.println(fibonacci.fib(10));
    }

    //递归求斐波那契数
    public int fibWithRecursion(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibWithRecursion(n - 1) + fibWithRecursion(n - 2);
    }

    //由于递归需要做很多重复计算，所以采用动态规划来实现，以减少不必要的重复计算过程
    public int fib(int n) {
        /*
            1. 确定dp数组及i的含义 dp[i]表示第i个斐波那契数为多少
            2. 确定状态转移方程 dp[i] = dp[i - 1] + dp[i - 2];
            3. dp数组初始化。dp[0] = 0; dp[1] = 1;
         */
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
