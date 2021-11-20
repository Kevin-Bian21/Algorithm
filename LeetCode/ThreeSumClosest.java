package LeetCode;

/**
 * @author BianWenKai
 * @DATE 2021/11/20 - 22:54
 **/
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int temp = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if (temp > Math.abs(target - (nums[i]+nums[j]+nums[k]))) {
                        temp = Math.abs(target - (nums[i]+nums[j]+nums[k]));
                        sum = nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }
        return sum;
    }
}
