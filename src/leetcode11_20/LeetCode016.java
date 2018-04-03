package leetcode11_20;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class LeetCode016 {

    public static void main(String[] args) {
        int[] test = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(test, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mResult = 0;
        int i = 0;
        while (nums[i] <= target) {
            int dup = Integer.MAX_VALUE;
            int temp = 0;
            int j = i + 1;
            int k = nums.length - 1;
            int sum = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] > sum) {
                    temp = nums[j] + nums[k] - sum;
                    k--;
                } else if (nums[j] + nums[k] < sum) {
                    temp = sum - nums[j] - nums[k];
                    j++;
                }
                if (dup > temp) {
                    dup = temp;
                } else {
                    mResult = Math.abs(mResult) < Math.abs(nums[i] + nums[j] + nums[k]) ?
                            mResult : nums[i] + nums[j] + nums[k];
                    break;
                }
            }
            i++;
        }
        return 0;
    }
}
