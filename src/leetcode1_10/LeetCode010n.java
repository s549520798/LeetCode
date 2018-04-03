package leetcode1_10;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *      '.' Matches any single character.
        '*' Matches zero or more of the preceding element.

        The matching should cover the entire input string (not partial).

        The function prototype should be:
        bool isMatch(const char *s, const char *p)

        Some examples:
        isMatch("aa","a") → false
        isMatch("aa","aa") → true
        isMatch("aaa","aa") → false
        isMatch("aa", "a*") → true
        isMatch("aa", ".*") → true
        isMatch("ab", ".*") → true
        isMatch("aab", "c*a*b") → true
 *
 */
public class LeetCode010n {
    /**
     * 1. s.length > p.length 时，返回false
     * 2. p 全是'.'时，返回true.
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return false;
    }
}
