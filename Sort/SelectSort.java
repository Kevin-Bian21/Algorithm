package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 10:58
 **/
public class SelectSort {
    /**
     * 选择排序,时间复杂度 O(logN)
     * @param array
     * @return int[]
     */
    public int[] selectSorting(int[] array){
        int i;
        int j;
        int index = 0;
        if (array == null || array.length <= 0)
            return new int[0];
        for (i = 0; i < array.length; i++) {
            int min = array[i];
            for (j = i+1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            if (array[i] != min) {
                int temp = array[i];
                array[i] = min;
                array[index] = temp;
            }
        }
        return array;
    }
}
