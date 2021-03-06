package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 10:07
 **/
public class BubbleSort {
    /**
     * 冒泡排序算法，时间复杂度 O(n^2),稳定排序
     * @param array
     * @return int[]
     */
    public int[] sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                     array[j - 1] = temp;
                    flag = false;
                }
            }
            if (flag)
                return array;
        }
        return array;
    }
}
