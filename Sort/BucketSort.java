package Sort;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 10:14
 **/
public class BucketSort {

    /**
     * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
     * @param array
     */

    public int[] sort(int[] array) {
        int BUCKET_SIZE = 10;  //桶的数量默认为10
        if (array == null || array.length <= 0)
            return new int[0];
        int maxValue = maxValue(array);
        int minValue = minValue(array);
        int bucketCount = (int) Math.floor((maxValue - minValue) / (double) BUCKET_SIZE) + 1;

        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < array.length; i++) {
            int index = (int) Math.floor((array[i] - minValue) / (double) BUCKET_SIZE);
            //把追加元素后的新数组重写赋给该buckets处
            buckets[index] = appendValue(buckets[index], array[i]);
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].length != 0) {
                buckets[i] = new SelectSort().sort(buckets[i]);
                for (int j = 0; j < buckets[i].length; j++) {
                    array[index ++] = buckets[i][j];
                }
            }
        }
        return array;

    }

    //往桶中追加元素
    private int[] appendValue(int[] array, int value) {
        //首先对数组进行扩容
        array = Arrays.copyOf(array, array.length + 1);
        //将元素添到桶中新开辟的空间处
        array[array.length - 1] = value;
        return array;
    }

    private int minValue(int[] array) {
        return getMaxValue(array)[0];
    }
    private int maxValue(int[] array) {
        return getMaxValue(array)[1];
    }


    private int[] getMaxValue(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
        }
        return new int[]{min, max};
    }

}
