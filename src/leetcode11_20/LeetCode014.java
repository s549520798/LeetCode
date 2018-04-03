package leetcode11_20;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LeetCode014 {
    public static void main(String[] args) {
        String[] strings = new String[]{"aa", "a"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0) return prefix;
        if (strs.length == 1) return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() - 1 < i) return prefix;          //考虑 后面的字符串没有第一条长的情况
                if (strs[j].charAt(i) != strs[0].charAt(i)) return prefix;
            }
            prefix = prefix + strs[0].charAt(i);
        }

        return prefix;
    }
}
