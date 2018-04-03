package leetcode1_10;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class LeetCode009 {

    public static void main(String[] args) {
        System.out.println(pow(10, 0));
        System.out.println(isPalindrome(1410110141));
        System.out.println(convertSolution(10101));
    }

    /**
     * 1、负数 不是回文的！
     * 2、考虑将数字翻过来时会不会溢出
     * 1234457
     *
     * @param x
     * @return is palindrome
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int c = 1;
        int step = 10;
        while (x / step != 0 && c < 10) {
            c++;
            step *= 10;
        }
        boolean b = true;
        int space = c;
        for (int i = 1; i <= c / 2; i++) {
            //得到各位数是 x%10 最高位是 x/ 10的space - 1次方
            if ((x % 10) != (x / pow(10, space - 1))) {
                return false;
            }
            // 将x的最高位和最低位去掉，即先对 10的space次方求余，在除以10
            x = (x % pow(10, space - 1)) / 10;
            space -= 2;
        }
        return b;
    }

    private static int pow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result = result * x;
        }
        return result;
    }

    /**
     * 将字符串进行反转
     * 注意反转时会溢出int类型范围
     */
    private static boolean convertSolution(int x) {
        if (x < 0) return false;
        int convert = 0;
        while (convert < x) {
            int last = x % 10;
            if (last == 0 && convert == 0) return false;
            convert = convert * 10 + last;
            x = x / 10;
        }
        return convert == x || convert / 10 == x;
    }
}
