package leetcode31_40;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {

        System.out.println(permute(new int[]{1,2,3,4}));
        int[] nums = new int[]{1,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * @param nums  Inputs
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        boolean flag = false;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (i > 0 && nums[i] > nums[i - 1]){
                //第 i 位要前移至i-1位，i - 1位之后的要按大小顺序排列
                int temp = nums[i - 1];
                nums[i-1] = nums[i];
                nums[i] = temp;
                //TODO 将i之后的数 进行排序
                Arrays.sort(nums,i,nums.length);
                flag = true;
                break;
            }
        }
        if (!flag){
            Arrays.sort(nums);
        }

    }

    /**
     * Given a collection of distinct integers, return all possible permutations.
     *
     * Example:
     *
     * Input: [1,2,3]
     * Output:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     * @param nums Input
     * @return list
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
        }
        if (nums.length == 2){
            result.add(Arrays.asList(nums[0],nums[1]));
            result.add(Arrays.asList(nums[1],nums[0]));
        }else {
            for (int i = 0; i < nums.length; i++) {
                int[] num = new int[nums.length - 1];
                int dis = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (i == j){
                        dis = 1;
                    }else {
                        num[j - dis] = nums[j];
                    }
                }
                for (List<Integer> list : permute(num)){
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.addAll(list);
                    result.add(arrayList);
                }
            }
        }
        return result;
    }
}
