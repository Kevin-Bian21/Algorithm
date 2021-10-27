package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/27 - 17:40
 **/
public class ShellSort {

    /**
     * 希尔排序：是针对直接插入排序算法的改进，它通过比较相距一定间隔的元素来进行，各趟比较所用的距离随着算法的进行而减小，
     * 直到只比较相邻元素的最后一趟排序为止。时间复杂度是 O(n^(1.3-2))，空间复杂度为常数阶 O(1)
     * @param array
     * @return int[]
     */
    public int[] shellSorting(int[] array) {

        if (array == null || array.length <= 0)
            return new int[0];

        //gap为增量
        for (int gap = (array.length / 2); gap > 0; gap /= 2) {
            //共有gap组
            for (int i = 0; i < gap; i++) {
                //对同一gap组的数据元素进行排序
                for (int j = (i+gap); j < array.length; j += gap) {
                    if (array[j] < array[j-gap]) {
                        int temp = array[j];
                        array[j] = array[j-gap];
                        array[j-gap] = temp;
                    }
                }
            }
        }
        return array;
    }
}
