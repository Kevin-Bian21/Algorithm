package LeetCode.DynamicProgamming;

/**
 * @author BianWenKai
 * @DATE 2021/11/25 - 19:38
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 **/
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairsDp(5));
    }

    public static int climbStairsDp(int n) {
        int i = 1;
        int j = 2;
        if (n == 1)
            return i;
        if (n == 2)
            return j;
        int result = 0;
        for (int k = 2; k < n; k++) {
            result = i + j;
            i = j;
            j = result;
        }
        return result;
    }

    public static int climbStairs(int n) {
        //一阶楼梯由一种爬法
        if (n == 1)
            return 1;
        //两阶楼梯有 (1 阶 + 1 阶)、(2 阶)两种爬法
        if (n == 2)
            return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
