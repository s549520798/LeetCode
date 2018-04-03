package leetcode11_20;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class LeetCode012 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3909));
    }

    /**
     * 罗马数字是阿拉伯数字传入之前使用的一种数码。
     * 罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。记数的方法：
     * 1、相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
     * 2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
     * 3、小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
     * 4、在一个数的上面画一条横线，表示这个数增值 1,000 倍
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        String result = "";
        if (num / 1000 != 0) {
            for (int i = 0; i < num / 1000; i++) {
                result = result + 'M';
            }
            num = num % 1000;
        }
        if (num / 100 != 0) {
            int h = num / 100;
            if (h < 4) {
                for (int j = 0; j < h; j++) {
                    result = result + 'C';
                }
            } else if (h == 4) {
                result = result + "CD";
            } else if (h < 9) {
                result = result + 'D';
                for (int i = 0; i < h - 5; i++) {
                    result = result + 'C';
                }
            } else if (h == 9) {
                result = result + "CM";
            }
            num = num % 100;
        }

        if (num / 10 != 0) {
            int t = num / 10;
            if (t < 4) {
                for (int m = 0; m < t; m++) {
                    result = result + 'X';
                }
            } else if (t == 4) {
                result = result + "XL";
            } else if (t < 9) {
                result = result + 'L';
                for (int i = 0; i < t - 5; i++) {
                    result = result + 'X';
                }
            } else if (t == 9) {
                result = result + "XC";
            }
            num = num % 10;
        }
        if (num < 4) {
            for (int i = 0; i < num; i++) {
                result = result + 'I';
            }
        }else if (num == 4){
            result = result + "IV";
        }else if (num < 9){
            result = result + 'V';
            for (int i = 0; i < num - 5 ; i++) {
                result = result + 'I';
            }
        }else if (num == 9) {
            result = result + "IX";
        }

        return result;
    }

}
