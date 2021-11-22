package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 10:58
 **/
public class SelectSort {
    /**
     * 选择排序,时间复杂度 O(N^2) 稳定排序
     * 从基准数之后开始选出最小的元素，和基准数比较，如果小与基准数则与其交换
     * @param array
     * @return int[]
     */
    public int[] sort(int[] array){
        int i;
        int j;
        if (array == null || array.length <= 0)
            return new int[0];
        for (i = 0; i < array.length; i++) {
            //定位最小的元素所在下标
            int minIndex = i;
            //从基准数之后确定出最小的元素的下标
            for (j = i+1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            //如果该最小元素不是该基准数本身的话，就说明有比该基准数小的元素，因此交换
            if (array[i] != array[minIndex]) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }
}
