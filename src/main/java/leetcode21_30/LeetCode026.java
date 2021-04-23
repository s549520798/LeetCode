package leetcode21_30;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class LeetCode026 {

    public static void main(String[] args) {
        int[] test = new int[]{1,1,2,2,3,3,4,5,5,6,7,7,7,8};
        System.out.println(removeDuplicates(test));
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 1)return nums.length;
        int length = nums.length;
        int i = 0;
        int j = 1;
        while (j < length){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
