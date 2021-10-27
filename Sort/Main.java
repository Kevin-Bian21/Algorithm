package Sort;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 10:44
 **/
public class Main {
    public static void main(String[] args) {

        int[] array = {1,7,9,4,6,5,3,0,1,1,2};

        BubbleSort bubbleSor = new BubbleSort();
        BucketSort bucketSort = new BucketSort();
        SelectSort selectSort = new SelectSort();
        QuickSort quickSort = new QuickSort();
//        System.out.println(Arrays.toString(bubbleSor.bubbleSorting(array)));
//        System.out.println(Arrays.toString(bucketSort.bucketSorting(array)));
        System.out.println(Arrays.toString(selectSort.selectSorting(array)));
//        System.out.println(Arrays.toString(quickSort.quickSorting(array)));

    }
}
