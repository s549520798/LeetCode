package leetcode21_30;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class LeetCode022 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n == 0) return result;
        if (n == 1) {
            result.add("()");
            return result;
        }

        for (int i = n; i > 0; i--) {
            if (i == 1) {
                for (String s : generateParenthesis(n - 1)) {
                    result.add("()" + s);
                }
            } else if (i == n) {
                for(String s: generateParenthesis(n - 1)){
                    result.add("(" + s + ")");
                }
            } else {
                for (String s1 : generateParenthesis(i - 1)) {
                    String pre = "(" + s1 + ")";
                    for (String s2 : generateParenthesis(n - i)) {
                        result.add(pre + s2);
                    }
                }
            }
        }
        return result;
    }
}
