package 蓝桥杯;

/**
 * @author BianWenKai
 * @DATE 2021/11/9 - 20:35
 **/
public class MaxSumInArray {

    public static void main(String[] args) {
        int[] array = {-2, 11, -4, 13, -5, -2};
        MaxSumInArray max = new MaxSumInArray();
        System.out.println(max.maxSum(array));
    }

    public int maxSum(int[] array) {
        if (array == null || array.length < 1)
            throw new IllegalStateException();
        int MAX = array[0];
        for (int i = 0; i < array.length; i++) {
            int sum = array[i];
            for (int j = i+1; j < array.length; j++) {
                if (MAX < sum) {
                    MAX = sum;
                }
                sum += array[j];
            }
        }
        return MAX;
    }
}
