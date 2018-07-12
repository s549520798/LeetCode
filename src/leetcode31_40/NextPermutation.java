package leetcode31_40;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {

        System.out.println(permute(new int[]{1, 2, 3, 4}));
        int[] nums = new int[]{5, 1, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(getPermutation(1, 1));
        System.out.println(letterCasePermutation("3a4f5D"));
    }

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * <p>
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     * <p>
     * The replacement must be in-place and use only constant extra memory.
     * <p>
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     * <p>
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * @param nums Inputs
     */
    public static void nextPermutation(int[] nums) {
        // 从倒数第二个数开始
        int i = nums.length - 2;
        // 找到最左边需要替换的数字
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //找出nums[i]之后 刚好大于nums[i]的那个数，之后的数肯定是倒叙排列的
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[i] < nums[j]) {
                j++;
            }
            swap(nums, i, j - 1);
        }
        Arrays.sort(nums, i + 1, nums.length);

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    /**
     * Given a collection of distinct integers, return all possible permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * Output:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     *
     * @param nums Input
     * @return list
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
        }
        if (nums.length == 2) {
            result.add(Arrays.asList(nums[0], nums[1]));
            result.add(Arrays.asList(nums[1], nums[0]));
        } else {
            for (int i = 0; i < nums.length; i++) {
                int[] num = new int[nums.length - 1];
                int dis = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        dis = 1;
                    } else {
                        num[j - dis] = nums[j];
                    }
                }
                for (List<Integer> list : permute(num)) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.addAll(list);
                    result.add(arrayList);
                }
            }
        }
        return result;
    }

    /**
     * 46 permutations ii
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     *
     * Example:
     *
     * Input: [1,1,2]
     * Output:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     * @param nums input
     * @return output
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        Arrays.sort(nums);
        //TODO
        return result;
    }

    /**
     * 60. Permutation Sequence
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * <p>
     * "123" "132" "213" "231" "312" "321"
     * Given n and k, return the kth permutation sequence.
     * Note:
     * <p>
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1:
     * <p>
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     * <p>
     * Input: n = 4, k = 9
     * Output: "2314"
     *
     * @param n 1~9
     * @param k 1~n!
     * @return string
     */
    private static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        String result = "";
        for (int i = n; i >= 1; i--) {
            int remainder = k % factorial(i - 1);
            int head;
            if (remainder != 0) {
                head = k / factorial(i - 1) + 1;
                k = remainder;
            } else {
                head = k / factorial(i - 1);
                k = factorial(i - 1);
            }
            result = result + nums[head - 1];
            leaveHeadBehind(nums, head - 1);

        }
        return result;
    }

    //将head 放在数组的最后面
    private static void leaveHeadBehind(int[] nums, int head) {
        while (head < nums.length - 1) {
            swap(nums, head, head + 1);
            head++;
        }
    }

    //求阶乘
    private static int factorial(int n) {
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact *= i;
        }
        return fact;
    }

    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
     * Examples:
     * Input: S = "a1b2"
     * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * <p>
     * Input: S = "3z4"
     * Output: ["3z4", "3Z4"]
     * <p>
     * Input: S = "12345"
     * Output: ["12345"]
     * Note:
     * <p>
     * S will be a string with length at most 12.
     * S will consist only of letters or digits.
     *
     * @param S input
     * @return output
     */
    private static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S.isEmpty())  {
            result.add(S);
            return result;
        }
        String s = S.toLowerCase();
        String head = s.charAt(0) + "";
        if (s.length() == 1){
            result.add(head);
            if ('a' <= s.charAt(0) && s.charAt(0) <= 'z'){
                result.add(head.toUpperCase());
            }
        }else {
            for (String string : letterCasePermutation(S.substring(1))){
                result.add(head + string);
                if ('a' <= s.charAt(0) && s.charAt(0) <= 'z'){
                    result.add(head.toUpperCase() + string);
                }
            }
        }
        return result;
    }
}
