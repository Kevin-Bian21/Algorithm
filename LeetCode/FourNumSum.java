package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BianWenKai
 * @DATE 2021/11/22 - 13:37
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * 链接：https://leetcode-cn.com/problems/4sum
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 **/
public class FourNumSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(fourSum(nums, 0));
    }

    /**
     * @param nums 由n个整数组成的数组
     * @param target 任意整数
     * @return List<List<Integer>>
     *
     * 采用排序 + 双循环 + 双指针 💙🚗🚚😂😁😀😉😘🥰😥😮😌🤐😯
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < len; j++) {
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                int left = j+1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target)
                        right--;
                    else if (sum < target)
                        left++;
                    else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //去重
                        while (left < right && nums[left] == nums[left+1])
                            left++;
                        while (left < right && nums[right] == nums[right-1])
                            right--;

                        left++;
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
