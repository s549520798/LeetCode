package leetcode11_20;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。记数的方法：
 * 1、相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
 * 2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
 * 3、小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
 * 4、在一个数的上面画一条横线，表示这个数增值 1,000 倍
 */
public class LeetCode013 {

    public int romanToInt(String s) {
        int sum = 0;
        if (s.contains("IV")) sum -= 2;      //因为之后算sum时，会分别对'I' 和 'V'进行计算，两者相加等于 6 要 - 2；
        if (s.contains("IX")) sum -= 2;
        if (s.contains("XL")) sum -= 20;
        if (s.contains("XC")) sum -= 20;
        if (s.contains("CD")) sum -= 200;
        if (s.contains("CM")) sum -= 200;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') sum += 1000;
            if (c == 'D') sum += 500;
            if (c == 'C') sum += 100;
            if (c == 'L') sum += 50;
            if (c == 'X') sum += 10;
            if (c == 'V') sum += 5;
            if (c == 'I') sum += 1;
        }

        return sum;
    }
}
