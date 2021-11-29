package LeetCode;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/11/29 - 17:28
 **/
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }

    public static int[] removeDuplicates(int[] nums) {
        int j = 0;
        int len = nums.length;
        while (j < len - 1) {
            if (nums[j] == nums[j + 1]) {
                if (len - 1 - j >= 0)
                    System.arraycopy(nums, j + 1, nums, j, len - 1 - j);
                System.out.println(len);
                len --;
                continue;
            }
            j++;
        }
        System.out.println(len);
        return nums ;
    }
}
