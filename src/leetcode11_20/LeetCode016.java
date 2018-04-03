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
        int[] test = new int[]{-1, 2, 1, -4,3,2,1,5,7,4};
        System.out.println(threeSumClosest(test, 100));
    }

    /**
     *  accepted  but take much time
     * @param nums 数组
     * @param target 目标数字
     * @return 三个数相加之和
     */
    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int mResult = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1 ; j++) {
                for (int k = j + 1; k < nums.length ; k++) {
                    if (Math.abs(diff) > Math.abs(nums[i] + nums[j] + nums[k] - target)){
                        diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        mResult = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return mResult;
    }

    private static int threeSumClosest1(int[] nums, int target){
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int mResult = Integer.MAX_VALUE;
        int i = 0; boolean flag = false;
        while (flag == false){


            if (flag == true) break;
            i++;
        }

        return 0;
    }
}
