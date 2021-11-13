package Sort;

import java.util.ArrayList;

/**
 * @author BianWenKai
 * @DATE 2021/11/13 - 10:39
 **/
public class RadixSort {

    public void radixSort(int[] array) {
        radixSort(array, getMaxNumLength(array));
    }

    /**
     * 目前未实现处理负数的情况，但是思路是如果含有负数找到该数组中最小值，数组中所有数减去该负数，
     * 这样就当作正整数排序，处理完后在加上该负数。
     * @param  array is positive array
     * @param  maxNumLength the max value length in array
     */
    private void radixSort(int[] array, int maxNumLength) {
        int divide = 1;

        for (int i = 0; i < maxNumLength; i++, divide *= 10) {

            ArrayList<Integer>[] radixArray = new ArrayList[10];

            for (int j = 0; j < array.length; j++) {
                int index = array[j] / divide % 10;
                if (radixArray[index] == null)
                    radixArray[index] = new ArrayList<Integer>();
                radixArray[index].add(array[j]);
            }

            int arrayIndex = 0;
            int listSize = 0;
            for (ArrayList<Integer> list : radixArray) {
                while (list != null && listSize < list.size()) {
                    array[arrayIndex] = list.get(listSize);
                    arrayIndex ++;
                    listSize ++;
                }
                listSize = 0;
            }
        }
    }

    private int getMaxNumLength (int[] array) {
        int max = array[0];
        for (int value : array) {
            if (max < value)
                max = value;
        }
        int length = 0;
        for (int i = max; i != 0 ; i /= 10) {
            length ++;
        }
        return length;
    }
}
