package leetcode1_10;

/**
 * Created by lazylee on 2017/12/5.
 * Question: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * 有两个有序数组 nums1和nums2,找出这两个有序列表的中间值,要求时间复杂度是 O(log(m+n)) [二分法].
 */
public class LeetCode004n {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        if (a == 0 && b == 0) return 0;
        if (a == 0) return nums2[(b + 1) / 2];
        if (b == 0) return nums1[(a + 1) / 2];

        int half = (a + b + 1) / 2;


        return 0;
    }

}
