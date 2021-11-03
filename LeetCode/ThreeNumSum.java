package LeetCode;

import java.util.*;

/**
 * @author BianWenKai
 * @DATE 2021/11/3 - 19:28
 **/
public class ThreeNumSum {
    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};
        ThreeNumSum threeNumSum = new ThreeNumSum();
        System.out.println(Arrays.toString(threeNumSum.threeSum(array).toArray()));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrayList = new ArrayList<>();
        if (nums.length <= 2) {
            return arrayList;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                return arrayList;
            //比较难以想到，但比较关键。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    arrayList.add(list);
                    //去重
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }
            }
        }
        return arrayList;
    }
}