package leetcode1_10;

import java.util.ArrayList;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LeetCode005 {

    public static void main(String[] args) {
        String tast = "babad";
        System.out.println(longestPalindrome(tast));
    }

    /*
    思路： 1，找到所有的子字符串，然后从所有子字符串中找到回文字符串，比较长度找出最长的那个
    找到所有子字符串的次数是 n + （n-1）+（n-2）+ ....+ 1 = n(n+1)/2;时间复杂度是 n的二次方
    然后 n*n 个字符穿 要判断 是否回文 最多可能 次数是 n*n * n/2 就是n的3次方
    最后比较 最多有 n*n*n*n/2 次
    改进： 在获取子字符串时，采用从后往前的方式， 并且 和已经获取到的maxLength对比，当剩下的能获取到的字符串小于
    maxLength 时跳过
     */
    public static String longestPalindrome(String s) {
        //ArrayList<String> subStrings = new ArrayList<>();
        String result = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i; j--) {
                if (maxLength > j - i) break;
                String subString = s.substring(i, j);
                //TODO 判断是否是回文字符串
                if (isPalindrome(subString)) {
                    if (subString.length() > maxLength) {
                        maxLength = subString.length();
                        result = subString;
                    }
                }
            }
        }

//        for (String str : subStrings) {
//            if (str.length() > maxLength) {
//                maxLength = str.length();
//                result = str;
//            }
//        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        boolean b = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                b = false;
                break;
            }
        }
        return b;
    }

}
