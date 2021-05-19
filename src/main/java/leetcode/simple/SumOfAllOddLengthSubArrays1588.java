package leetcode.simple;

/**
 * 给你一个正整数数组?arr?，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr?中 所有奇数长度子数组的和 。
 */
public class SumOfAllOddLengthSubArrays1588 {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1, 2}));
        System.out.println(sumOddLengthSubarrays(new int[]{10, 11, 12}));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];  // 长度为1的子数组
            int index = i;
            // 以 arr[i] 开头的所有子数组
            while (index + 2 < arr.length) {
                for (int j = i; j <= index + 2; j++) {
                    result += arr[j];
                }
                index += 2;
            }
        }

        return result;
    }
}
