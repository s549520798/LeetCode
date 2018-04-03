package leetcode1_10;

/**
 * Implement atoi to convert a string to an integer.
 */
public class LeetCode008 {


    public static void main(String[] args) {
        char a = 56;
        System.out.println(myAtoi("+"));
    }

    /**
     * 1、考虑开头是空格的情况，去掉空格。
     * 2、去掉空格后如果第一个字符是字母或者其他不为数子的字符，返回0；
     * 3、数字后结尾如果不是数字则停止
     * 4、ASCII 0到9 对应的是 48到57
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //不能使用 term 对String 进行去空格处理，这样会去掉数字中间是空格的情况，导致结果错误。

        if (str.isEmpty()) return 0;
        while (str.startsWith(" ")) {
            str = str.substring(1);
        }

        char[] chars = str.toCharArray();
        int sign = 1;
        if (chars[0] == 45 || chars[0] == 43) {
            sign = chars[0] == 45 ? -1 : 1;
            if (!str.substring(1).isEmpty()) chars = str.substring(1).toCharArray();
        }
        if (chars[0] > 57 || chars[0] < 48) {
            return 0;
        }
        int total = 0;
        for (char c : chars) {
            if (c <= 57 && c >= 48) {
                int val = c - '0';
                int ex = total;
                total = ex * 10 + val;
                if (total / 10 != ex) {
                    return  sign > 0 ? 2147483647 : -2147483648;
                }
            } else {
                break;
            }
        }

        return total * sign;
    }

}
