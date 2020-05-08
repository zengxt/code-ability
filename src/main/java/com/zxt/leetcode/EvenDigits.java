package com.zxt.leetcode;

/**
 * ����һ���������� nums�����㷵������ λ��Ϊ ż�� �����ֵĸ�����
 */
public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896, 95135, 951353, 1};
        System.out.println(findNumbers2(nums));
    }

    public static int findNumbers(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 5;
            for (; j >= 0; j--) {
                // nums[i] / Math.pow(10, j) != 0 ����
                if (nums[i] / Math.pow(10, j) >= 1) {
                    break;
                }
            }

            result += (((j + 1) & 1) == 1) ? 0 : 1;
        }

        return result;
    }

    public static int findNumbers2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = 0;
            while (num != 0) {
                num /= 10;
                temp++;
            }

            result += (temp & 1) == 1 ? 0 : 1;
        }

        return result;
    }
}
