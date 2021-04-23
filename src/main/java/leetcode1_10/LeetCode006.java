package leetcode1_10;


/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 */
public class LeetCode006 {

    public static void main(String[] args) {
        String tast = "ABCD";
        System.out.println(convert(tast, 3));
    }

    public static String convert(String s, int numRows) {
        if (s.isEmpty()) return "";
        if (numRows == 1) return s;
        //每组包含的字母个数
        int num = 2 * numRows - 2;
        //一共可以分成多少组
        int groupNum = s.length() % num == 0 ? s.length() / num : s.length() / num + 1;
        String[] subStrings = new String[groupNum];
        for (int i = 0; i < groupNum; i++) {
            if (i != groupNum - 1) {
                subStrings[i] = s.substring(i * (2 * numRows - 2), (i + 1) * (2 * numRows - 2));
            } else {
                subStrings[i] = s.substring(i * (2 * numRows - 2));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < groupNum; j++) {
                //考虑 当j == groupNum - 1时，即 最后一个子字符串没有全长时
                if (j == groupNum - 1) {
                    int length = subStrings[j].length();
                    if (length <= numRows) {
                        if (i < length) {
                            sb.append(subStrings[j].charAt(i));
                        }
                    } else {
                        sb.append(subStrings[j].charAt(i));
                        if (num - i < length && i != numRows -1) {
                            sb.append(subStrings[j].charAt(num - i));
                        }
                    }
                } else {
                    if (i == 0 || i == numRows - 1) {
                        sb.append(subStrings[j].charAt(i));
                    } else {
                        sb.append(subStrings[j].charAt(i));
                        sb.append(subStrings[j].charAt(num - i));
                    }
                }
            }
        }

        return sb.toString();
    }
}
