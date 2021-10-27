package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/27 - 11:10
 **/
public class MergeSort {
    /**
     * 归并排序:是建立在归并操作上的一种有效、稳定的排序算法，该算法是采用分治法(Divide and Conquer）的一个非常典型的应用。
     * 归并排序对序列的元素进行逐层折半分组，然后从最小分组开始比较排序，合并成一个大的分组，时间复杂度为O(nlogn)，空间复杂度为 O(n)
     * @param array
     * @return int[]
     */
    public int[] mergeSorting(int[] array) {
        if (array == null || array.length < 1) {
            return new int[0];
        }
        divideSortMerge(array,0,array.length-1);
        return array;
    }

    //将原来的数组进行分组，然后将组内的元素进行排序，然后组与组之间进行合并。
    public void divideSortMerge(int[] array, int left, int right) {
        if (left >= right)
            return ;
        int mid = (left + right) / 2;
        divideSortMerge(array, left, mid);
        divideSortMerge(array, mid+1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        //合并数组下标为left到middle，和下标为middle+1到right的两部分
        int[] newArray = new int[right-left+1];
        int arrayStart = mid+1;
        int index = 0;
        int i = left;
        int j = right;
        while (left <= mid && arrayStart <= right) {
            if (array[left] <= array[arrayStart]) {
                newArray[index] = array[left];
                left++;
            }else {
                newArray[index] = array[arrayStart];
                arrayStart++;
            }
            index++;
        }
        while (left <= mid) {
            newArray[index] = array[left];
            index++;
            left++;
        }
        while (arrayStart <= right) {
            newArray[index] = array[arrayStart];
            index++;
            arrayStart++;
        }
        //将新数组排好序的元素拷贝到元素组从left到right的对应位置
        for (int k = 0; i <= j; i++,k++) {
            array[i] = newArray[k];
        }
    }
}
