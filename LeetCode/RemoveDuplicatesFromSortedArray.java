package LeetCode;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/11/29 - 17:28
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 **/
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }

    public static int[] removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0)
            return nums;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index ++;
                nums[index] = nums[i];
            }
        }
        System.out.println(index);
        return nums;
    }
}
