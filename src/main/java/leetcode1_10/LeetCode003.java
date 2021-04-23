package leetcode1_10;

import java.util.HashMap;

/**
 * Created by lazylee on 2017/12/5.
 * <p>
 * Question: Given a string, find the length of the longest substring without repeating characters.
 * 给出一个String,找出它的最长的没有重复字符的子字符串的长度
 * <p>
 * String 类中需要注意的是:  indexOf(String s)  返回值index从0开始
 * substring(int begin,int end)  返回一个 end-begin的String  不包含index为end是的char
 */
public class LeetCode003 {


    public static void main(String[] args) {
        String s = "ausdf";

        System.out.println(lengthOfLongestSubstring(s) + "");

    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = s.isEmpty() ? 0 : 1;
        int start = 0;
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 1; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            String child = i == s.length() ? s.substring(start) : s.substring(start, i);
            if (child.contains(c)) {
                start = s.indexOf(c, start) + 1;
                map.put(child.length(), child);
            }else{
                maxLength = child.length() + 1;
            }
        }

        for (Integer i : map.keySet()) {
            maxLength = maxLength < i ? i : maxLength;
        }

        return maxLength;
    }
}
