package leetcode1_10;

import org.junit.Test;

import java.util.Arrays;

import static leetcode1_10.LeetCode001.*;

public class LeetCodeTest001 {

    @Test
    public void twoSumTest() {
        //test 1 [2,7,11,15]
        int[] ret1 =  twoSum(new int[]{2, 7, 11, 15}, 9);
        assert Arrays.equals(ret1, new int[]{0, 1});
    }

}
