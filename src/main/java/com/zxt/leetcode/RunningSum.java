package com.zxt.leetcode;

import java.util.Arrays;

/**
 * ����һ������ nums �����顸��̬�͡��ļ��㹫ʽΪ��runningSum[i] = sum(nums[0]��nums[i]) ��
 * <p>
 * �뷵�� nums �Ķ�̬�͡�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,4]
 * �����[1,3,6,10]
 * ���ͣ���̬�ͼ������Ϊ [1, 1+2, 1+2+3, 1+2+3+4] ��
 */
public class RunningSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));  // [1,3,6,10]
        System.out.println(Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1})));  // [1,2,3,4,5]
        System.out.println(Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1}))); // [3,4,6,16,17]
    }

    public static int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    }
}
