package Practice;

/**
 * @author BianWenKai
 * @DATE 2021/11/26 - 22:37
 **/
public class Knapsack0_1 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int knapsackCapacity = 4;
        System.out.println(knapsack(knapsackCapacity, weight.length, weight, value));
    }

    /**
     * 使用贪心算法，得到局部最优解从而拿到整体最优解，但是该算法无法对所有问题都得到整体最优解
     * @param Capacity 背包容量
     * @param n 物品数量
     * @param weight 每件物品的重量
     * @param value 每件物品的价值
     */
    public static int knapsack(int Capacity, int n, int[] weight, int[] value) {
        float[] unitValue = new float[n];
        for (int i = 0; i < n; i++) {
            unitValue[i] = (float) value[i] / weight[i];
        }
        //将物品的重量按照单位价值排序
        sort(unitValue, weight, value);

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            //当某个物品重量超过背包所能放的物品重量时，说明该物品无论如何也放不到背包中去
            if (weight[i] > Capacity)
                continue;
            maxValue += value[i];
            Capacity -= weight[i];
        }
        return maxValue;
    }

    public static int[] sort(float[] array, int[] weight, int[] value){
        int i;
        int j;
        if (array == null || array.length <= 0)
            return new int[0];
        for (i = 0; i < array.length; i++) {
            //定位最小的元素所在下标
            int maxIndex = i;
            //从基准数之后确定出最小的元素的下标
            for (j = i+1; j < array.length; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            //如果该最小元素不是该基准数本身的话，就说明有比该基准数小的元素，因此交换
            if (array[i] != array[maxIndex]) {
                swapFloat(array, i, maxIndex);
                swapInt(weight, i, maxIndex);
                swapInt(value, i, maxIndex);
            }
        }
        return weight;
    }
    public static void swapFloat( float[] array, int first, int second) {
        float temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    public static void swapInt( int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
