package Sort;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 10:44
 **/
public class Main {
    public static void main(String[] args) {

        int[] array = {0,3,5,5,2,7,1,3,9,6,4};

        BubbleSort bubbleSor = new BubbleSort();
        BucketSort bucketSort = new BucketSort();
        SelectSort selectSort = new SelectSort();
        QuickSort quickSort = new QuickSort();
        InsertSort insertSort = new InsertSort();
        MergeSort mergeSort = new MergeSort();
        ShellSort shellSort = new ShellSort();
//        System.out.println(Arrays.toString(bubbleSor.bubbleSorting(array)));
//        System.out.println(Arrays.toString(bucketSort.bucketSorting(array)));
//        System.out.println(Arrays.toString(selectSort.selectSorting(array)));
//        System.out.println(Arrays.toString(quickSort.quickSorting(array)));
//        System.out.println(Arrays.toString(insertSort.insertSorting(array)));

//        System.out.println(Arrays.toString(mergeSort.mergeSorting(array)));
        System.out.println(Arrays.toString(shellSort.shellSorting(array)));
    }
}
