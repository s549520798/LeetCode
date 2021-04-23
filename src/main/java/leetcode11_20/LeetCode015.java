package leetcode11_20;

import java.util.*;

/**
 * Given an array S of n integers,are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class LeetCode015 {
    public static void main(String[] args) {
        int[] tast = new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        System.out.println(threeSum1(tast));
    }

    /*
    注意去重，
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        boolean b = true;
                        for (List<Integer> l : result) {
                            if (l.containsAll(list)) {
                                b = false;
                                break;
                            }
                        }
                        if (b) result.add(list);
                        if (list.equals(Arrays.asList(0, 0, 0)) && !result.contains(Arrays.asList(0, 0, 0))) {
                            result.add(list);
                        }
                    }
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> mResult = new ArrayList<>();
        if (nums.length == 0 || nums.length < 3) return mResult;
        Arrays.sort(nums);
        int i = 0;
        while (nums[i] <= 0 && i < nums.length - 2) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        mResult.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            i++;
        }
        return mResult;
    }

}
