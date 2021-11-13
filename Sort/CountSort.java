package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/11/13 - 20:00
 **/

/**
 * 计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 。计数排序不是比较排序，排序的速度快于任何比较排序算法。计数排序是用来排序0到100之间的数字的最好的算法
 */
public class CountSort {

    public int[] countSort(int[] array) {
        int[] newArray = new int[getMaxNum(array) + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[array[i]] += 1 ;
        }
        int index = 0;
        for (int i = 0; i < newArray.length; i++) {
            while (newArray[i] != 0) {
                array[index] = i;
                newArray[i] --;
                index ++;
            }
        }
        return array;
    }

    private int getMaxNum(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    }

}
