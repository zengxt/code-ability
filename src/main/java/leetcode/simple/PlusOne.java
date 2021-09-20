package leetcode.simple;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {
    public static void main(String[] args) {
        Arrays.stream(plusOne(new int[]{1, 2, 3})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(plusOne(new int[]{9})).forEach(System.out::print);
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int bit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + bit;
            digits[i] = temp == 10 ? 0 : temp;
            bit = temp == 10 ? 1 : 0;

            if (bit == 0) {
                break;
            }
        }

        if (bit == 0) {
            return digits;
        } else {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 1, digits.length);
            ans[0] = 1;
            return ans;
        }

    }
}
