package 蓝桥杯;

import java.util.*;

/**
 * @author BianWenKai
 * @DATE 2021/11/18 - 20:14
 *
 * 链接：https://ac.nowcoder.com/acm/contest/23119/G
 *
 * 最近小明疯狂因为自己的体重问题而苦恼，觉得自己太轻了（Orz），所以产生了增重计划，希望通过多吃零食达到目标，
 * 但现在他的零食背包的体积和容积有限，他希望你能有一种在零食背包体积和容积的范围内保证食物的卡路里最大的方法，使得他能够快速增重。

 * 第一行两个数 体积最大值(<400)和质量最大值(<400)
 * 第二行一个数 食品总数N(<50).
 * 第三行--第3+N行
 * 每行三个数体积(<400) 质量(<400) 所含卡路里(<500)
 *
 * 输入：
 * 320 350
 * 4
 * 160 40 120
 * 80 110 240
 * 220 70 310
 * 40 400 220
 *
 *
 * 一个数所能达到的最大卡路里(int范围内)
 * 输出：
 * 550
 **/
public class Orz {

    private class Food {
        private int volume;
        private int wight;
        private int calorie;

        public Food(int volume, int wight, int calorie) {
            this.volume = volume;
            this.wight = wight;
            this.calorie = calorie;
        }
    }
    PriorityQueue<Food> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(f -> f.calorie));

    public static void main(String[] args) {
        Orz orz = new Orz();
        System.out.println(orz.getMaxCalorie());

    }

    public int getMaxCalorie(){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int w = sc.nextInt();
        int volume = v;
        int weight = w;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Food(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        List<Food> foods = new ArrayList<>();
        for (int i = priorityQueue.size() ; i > 0 ; i--) {
            Food food = priorityQueue.remove();
            if (food.volume >  v || food.wight > w)
                continue;
            foods.add(food);
        }
        int maxCalorie = 0;
        int sumCalorie = 0;
        int count = foods.size();

            for (int i = count - 1; i >= 0 ; i--) {
                if (v >= foods.get(i).volume && w > foods.get(i).wight) {
                    v -= foods.get(i).volume;
                    w -= foods.get(i).wight;
                    maxCalorie = Math.max(maxCalorie, maxCalorie + foods.get(i).calorie);
                }
                for (int j = i -1 ,k = j; j >= 0; j--) {
                    if (v >= foods.get(j).volume && w > foods.get(j).wight) {
                        v -= foods.get(j).volume;
                        w -= foods.get(j).wight;
                        maxCalorie = Math.max(maxCalorie, maxCalorie + foods.get(i).calorie);
                    }
                    if (j == 0) {
                        j = k - 1;
                        k -- ;
                        v = volume - foods.get(i).volume;
                        w = weight - foods.get(i).wight;
                    }
                }
            }

        return maxCalorie;
    }
}
