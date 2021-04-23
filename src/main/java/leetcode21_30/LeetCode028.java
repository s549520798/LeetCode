package leetcode21_30;

/**
 * 28. Implement strStr()
 * in Java  String's indexOf() method
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * e.g.
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Note: when noodle is empty ,return 0;
 */
public class LeetCode028 {
    public static void main(String[] args) {
        System.out.println(strStr("a","a"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        int i = 0;

        while (i < haystack.length() - needle.length() + 1){
            if (needle.charAt(0) == haystack.charAt(i)){
                boolean a = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)){
                        a = false;
                        break;
                    }else {
                        a = true;
                    }
                }
                if (a) return i;
            }
            i++;
        }
        return -1;

    }
}
