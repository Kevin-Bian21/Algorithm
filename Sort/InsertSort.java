package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/27 - 10:32
 **/
public class InsertSort {
    /**
     * 插入排序：将一个记录插入到已经排好序的有序表中，从而一个新的、记录数增 1 的有序表 O(n^2)
     * @param array
     * @return int[]
     */
    public int[] insertSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                //和前一个数字比较，如果当前数字大于前一个数字的话，说明当前元素和前面的元素是有序的，那就不在比较，直接退出，
                if (array[j] < array[j-1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }else
                    break;
            }
        }
        return array;
    }
}
