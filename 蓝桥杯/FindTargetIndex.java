package 蓝桥杯;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/11/13 - 15:29
 **/
public class FindTargetIndex {

    public static void main(String[] args) {
        int[] array = {1,9,6,3,4,8,5,3,3,3};
        FindTargetIndex find = new FindTargetIndex();
        System.out.println(Arrays.toString(find.targetIndex(array,3)));
    }

    public int[] targetIndex(int[] array, int target) {
        maxHeap(array);
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (target == array[i]) {
                i ++;
            }
            if (j != i)
                return new int[]{j, i - 1};
        }
        return new int[]{-1, -1};
    }

    public int[] maxHeap(int[] array) {
        int len = array.length;
        int lastParentIndex = array.length / 2 - 1 ;
        for (int i = lastParentIndex; i >= 0 ; i--) {
            heapSort(array, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            len --;
            heapSort(array, 0, len);
        }

        System.out.println(Arrays.toString(array));
        return array;
    }

    private int[] heapSort(int[] array, int index, int len) {
        int largeIndex = index;
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex < len && array[largeIndex] < array[leftChildIndex])
            largeIndex = leftChildIndex;

        if (rightChildIndex < len && array[largeIndex] < array[rightChildIndex])
            largeIndex = rightChildIndex;

        if (largeIndex == index)
            return null;

        swap(array, largeIndex, index);

        heapSort(array, largeIndex, len);
        return array;
    }

    private void swap (int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

