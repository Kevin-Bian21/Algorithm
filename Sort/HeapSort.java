package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/11/13 - 15:55
 **/
public class HeapSort {

    public int[] heapSort(int[] array) {
        int len = array.length;
        int lastParentIndex = len / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            buildMaxHeap(array, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(array, 0, i);
            len --;
            buildMaxHeap(array, 0, len);
        }
        return array;
    }

    private void buildMaxHeap(int[] array, int index, int len) {
        int largestIndex = index;
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        if (leftChildIndex < len && array[largestIndex] < array[leftChildIndex])
            largestIndex = leftChildIndex;
        if (rightChildIndex < len && array[largestIndex] < array[rightChildIndex])
            largestIndex = rightChildIndex;

        if (largestIndex == index)
            return;
        swap(array, largestIndex, index);
        buildMaxHeap(array, largestIndex, len);
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
