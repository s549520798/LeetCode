package leetcode11_20;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 */
public class LeetCode011 {

    public static void main(String[] args) {
        int[] tast = new int[]{2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxContainter(tast));
    }

    /**
     * 1、（i,a[i]） 和 （j,a[j]）最大盛水量是 (j - i) * Max(i,j)
     * 2、 可以双循环套嵌依次找到最大值 总共的次数是 n-1 + n-2 + ....+ 1 = n(n-1)/2
     * 时间复杂度是O（n²） 此方法 time limit exceeded
     * 3、 对上面循环进行改进，
     *
     * @param height 数组
     * @return 最大盛水量
     */
    public int maxArea(int[] height) {
        int maxValue = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = height[i] < height[j] ? height[i] : height[j];
                maxValue = (j - i) * h > maxValue ? (j - i) * h : maxValue;
            }
        }
        return maxValue;
    }

    /**
     * 1、 思路： 从两边端点往中间移动，每次移动条件是 找到了更大的 Aera 并且从较小的那边开始移动
     * 2、 这个方法的关键是 判断从哪边移动时，如果从较大的那边移动是不可能找到更大的值的。
     *
     * @param height
     * @return
     */
    public static int maxContainter(int[] height) {
        int maxValue = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int h = height[i] < height[j] ? height[i] : height[j];
            maxValue = maxValue < h * (j - i) ? h * (j - i) : maxValue;

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxValue;

    }
}
