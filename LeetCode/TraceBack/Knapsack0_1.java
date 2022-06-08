package LeetCode.TraceBack;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/11/27 - 20:25
 **/
public class Knapsack0_1 {
    static int n = 4;  //物品个数
    int knapsackCapacity = 4;  //背包容量
    int maxValue = Integer.MIN_VALUE;  //最大价值
    int[] status = new int[n];  //状态空间,标记第 i 种物品是否装入背包
    int[] best = new int[n];  //存放最优解的方案

    public static void main(String[] args) {

        Goods[] goods = {new Goods(1, 15), new Goods(3, 20),
                new Goods(4, 30), new Goods(9, 150)};
        Knapsack0_1 knapsack01 = new Knapsack0_1();
        knapsack01.knapsack01(0, knapsack01.knapsackCapacity, 0, goods);
        System.out.println(Arrays.toString(knapsack01.best));
        System.out.println(knapsack01.maxValue);
    }
    static class Goods {
        private Integer weight;
        private Integer value;

        public Goods(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }



    /**
     * @param k 放入背包中的物品数量
     * @param capacity 背包当前剩余容量
     * @param valueSum 背包中放入的物品的总价值
     * @param goods 物品数组
     */

    public void knapsack01(int k, int capacity, int valueSum, Goods[] goods) {
        if (k >= n - 1)
            return;

        if (capacity > 0 && valueSum > maxValue) {
            maxValue = valueSum;
            best = status;
            Arrays.fill(best,k + 1, n, 0);
        }

        if (capacity > 0) {
            status[k + 1] = 0;
            knapsack01(k+1, capacity, valueSum, goods);
            status[k + 1] = 1;
            knapsack01(k + 1, capacity - goods[k + 1].weight, valueSum + goods[k + 1].value, goods);
        }
    }
}
