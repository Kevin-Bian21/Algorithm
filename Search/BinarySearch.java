package Search;

/**
 * @author BianWenKai
 * @DATE 2021/9/12 - 14:30
 **/
public class BinarySearch {

    public static int binarySearch(int[] array,int key){
        int first = 0;
        int last = array.length -1;
        while (first <= last){
            int mid = (first + last)/2;
            if (key > array[mid])
                first = mid + 1;
            else if (key < array[mid])
                last = mid - 1;
            else
                return mid;
        }
        return -1;
    }

}
