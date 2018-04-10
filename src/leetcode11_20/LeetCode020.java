package leetcode11_20;

import java.util.Stack;

/**
 * Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class LeetCode020 {
    public static void main(String[] args) {
        String test = "(()(";
        System.out.println(isValid(test));
    }

    private static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
