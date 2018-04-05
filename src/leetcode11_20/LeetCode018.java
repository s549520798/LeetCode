package leetcode11_20;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * e.g  given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class LeetCode018 {
    public static void main(String[] args) {

    }
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> mResult = new ArrayList<>();
        if (nums == null || nums.length < 4) return mResult;
        int i = 0; int end = nums.length - 1;
        while (i < end - 2){


        }
        return mResult;
    }
}
