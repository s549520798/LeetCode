package leetcode21_30;

/**
 * 29. Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 * e.g
 * Input: dividend = 10, divisor = 3
 * Output: 3
 */
public class LeetCode029 {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = -a;
        System.out.println(a);
        System.out.println(b);
        System.out.println(divide(-2147483648, 2));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor ==0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        int sign = (dividend > 0 ? 1 : -1) == (divisor > 0 ? 1 : -1) ? 1 : -1;
        int result = 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        long d = Math.abs((long)dividend);
        long s = Math.abs((long)divisor);
        while (d >= s) {
            long temp = s,muti = 1;
            while (d >= (temp << 1)){
                temp <<= 1;
                muti <<= 1;
            }
            d -=temp;
            result += muti;
        }
        return sign > 0 ? result : -result;
    }
}
