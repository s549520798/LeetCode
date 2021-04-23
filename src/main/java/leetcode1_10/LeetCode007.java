package leetcode1_10;

/***
 * Given a 32-bit signed integer, reverse digits of an integer.
 * eg. 123 -> 321;  -123 -> -321; 120 -> 21
 */
public class LeetCode007 {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(153436469));

    }


    public static int reverse(int x) {
        boolean isNegative = x < 0;
        int i = isNegative ? -x : x;
        String s = i + "";
        while (s.endsWith("0")) {
            s = s.substring(0, s.length() - 1);
        }
        int m = 0, n = s.length() - 1;
        char[] chars = new char[s.length()];
        while (m <= n) {
            chars[m] = s.charAt(n);
            chars[n] = s.charAt(m);
            m++;
            n--;
        }
        String s1 = "";
        for (char c : chars) {
            s1 = s1 + c;
        }
        //判断s1的大小是否大于 Integer.MaxValue;
        int re = parseInt(s1);

        return isNegative ? -re : re;
    }
    //判断s1是否大于2147483647
    private static int parseInt(String s) {
        char[] chars = s.toCharArray();

        long total = 0;
        long step = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            total += step * (chars[i] - '0');
            step *= 10;
        }
        if (total > Integer.MAX_VALUE) return 0;

        return (int) total;
    }

}
