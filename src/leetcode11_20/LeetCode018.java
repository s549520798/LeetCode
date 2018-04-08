package leetcode11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * e.g  given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class LeetCode018 {
    public static void main(String[] args) {
        int[] test = new int[]{-1,-5,-5,-3,2,5,0,4};
        System.out.println(fourSum(test, -7));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> mResult = new ArrayList<>();
        if (nums == null || nums.length < 4) return mResult;
        Arrays.sort(nums);
        int maxValue = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] * 4 > target || maxValue * 4 < target) return mResult;
            int sum3 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    if (nums[j] + nums[m] + nums[n] > sum3) {
                        n--;
                    } else if (nums[j] + nums[m] + nums[n] < sum3) {
                        m++;
                    } else {
                        mResult.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < n && nums[n] == nums[n - 1]) n--;
                        while (m < n && nums[m] == nums[m + 1]) m++;
                        m++;
                        n--;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
        }
        return mResult;
    }
}
