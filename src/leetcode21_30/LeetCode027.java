package leetcode21_30;

/**
 * 27. Remove Element
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * e.g.
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 */
public class LeetCode027 {

    public static void main(String[] args) {
        int[] test = new int[]{2,3,4,2,3,1,5,7,8,9,5,9,0,3,4};
        System.out.println(removeElement(test,1));
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }

    }
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length){
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}
