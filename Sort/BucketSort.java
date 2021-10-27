package Sort;

/**
 * @author BianWenKai
 * @DATE 2021/10/26 - 10:14
 **/
public class BucketSort {

    /**
     * 桶排序
     * @param array
     * @return int[]
     */
    public int[] bucketSorting(int[] array){
        if (array == null || array.length <= 0)
            return new int[0];
        int max = array[0];
        //拿到该数组中的最大值
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        //创建一个新数组，新数组的长度为原数组中所放元素的最大值
        int[] newArray = new int[max+1];
        //创建一个统计原数组中的元素出现了多少次的数组。
        int[] count = new int[max+1];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == array[j]) {
                    newArray[i] = array[j];
                    count[i]++;
                }
            }
        }
        int index = 0;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[index] = newArray[i];
                index ++;
            }
        }
        return array;
    }
}
