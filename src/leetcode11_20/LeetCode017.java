package leetcode11_20;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * e.g Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode017 {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    private static List<String> letterCombinations(String digits) {
        LinkedList<String> mResult = new LinkedList<>();
        if (digits == null || digits.isEmpty() || digits.trim().isEmpty()) return mResult;
        if (digits.contains("0") || digits.contains("1")) return mResult;
        String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        mResult.add("");
        for (int i = 0; i < digits.length(); i++) {
            int dig = digits.charAt(i) - '0' - 2;
            while (mResult.peek().length() == i) {
                String temp = mResult.remove();
                for (char c : letters[dig].toCharArray()) {
                    mResult.add(temp + c);
                }
            }
        }
        return mResult;
    }
}
