package leetcode1_10;

import java.util.*;

/**
 * Created by lazylee on 2017/11/25.
 * Question: twoSum
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where
 * index1 must be less than index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based.
 * You may assume that each input would have exactly one solution.
 * 　　  Input: numbers={2, 7, 11, 15}, target=9
 * 　　  Output: index1=1, index2=2
 * 题目:
 * 给出一个integers数组,从数组中找到两个值,使他们加起来的值等于特定的目标值(数组是无序的).
 * twoSum 函数应该返回相加等于目标值的两个数的数组下标,并且返回的index1应该小于index2.
 * 请注意,以你返回的值(index1和index2)都不是从零开始的.
 * 你可以假设 每次的输入都只有一种对应的解法.
 * 例如:输入的数组是{2,7,11,15},目标值9;
 * 输出的结果是 index1=1,index2=2.
 */
public class LeetCode001 {


    public static void main(String[] args) {

        int [] nums = new int[]{2,5,3,1,4,8,6,7};
        int sum = 10;
        int[] indexs = twoSum(nums, sum);

        System.out.println("index1 = " + indexs[0] + ",index2 = " + indexs[1]);


    }

    public static int[] twoSum(int[] nums, int target) {

        int[] indexs = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return indexs;
    }

    public static int[] twoSum1(int[] nums, int sum) {
        int[] index = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(sum - nums[i])) {
                index[1] = i + 1;
                index[0] = map.get(sum - nums[i]);
                return index;
            } else {
                map.put(nums[i], i + 1);
            }
        }
        return index;
    }
    //如果是有序数组的话可以使用
    public static int[] twoSumRecursion(int[] nums, int sum) {
        int[] index = new int[2];
        compareSum(sum, 0, nums.length - 1, nums, index);
        return index;
    }

    public static void compareSum(int sum, int pre, int suf, int[] nums, int[] index) {
        if (pre >= suf) return;

        if (sum > nums[pre] + nums[suf]) {
            compareSum(sum, pre + 1, suf, nums, index);
        } else if (sum < nums[pre] + nums[suf]) {
            compareSum(sum, pre, suf - 1, nums, index);
        } else {
            index[0] = pre;
            index[1] = suf;
        }
    }
}
