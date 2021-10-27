package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 11:41
 **/
public class QuickSort {
    /**
     * 快速排序
     * @param array
     * @return int[]
     */
    public int[] quickSorting(int[] array) {
        if (array == null || array.length < 1) {
            return new int[0];
        }
        quickSorting(array,0,array.length-1);
        return array;
    }


    private void quickSorting(int[] array, int left, int right) {

        if (left > right)
            return ;

        int i = left;
        int j = right;
        int temp = array[left];

        //如果选择最左面的数为基准数，则右边的哨兵先开始走，否则的话左边的哨兵先走。
        while (i != j) {
            while (temp <= array[j] && i < j) {
                j--;
            }
            while (temp >= array[i] && i < j) {
                i++;
            }
            if (i < j){
                int num = array[i];
                array[i] = array[j];
                array[j] = num;
            }
        }
        //当两个哨兵相遇时，基准数和相遇处的数进行交换
        array[left] = array[j];
        array[j] = temp;

        quickSorting(array,left,j-1);
        quickSorting(array,i+1,right);
    }
}
