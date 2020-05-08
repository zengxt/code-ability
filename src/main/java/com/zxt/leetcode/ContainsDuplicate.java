package com.zxt.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
 * <p>
 * �������һֵ�������г����������Σ��������� true �����������ÿ��Ԫ�ض�����ͬ���򷵻� false ��
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }

        // ����������Ҫ��Ҳ����ʹ�� set ����
        Map<Integer, Integer> map = new HashMap<>();
        // Arrays.sort(nums); ����������Ч��
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], 1);
        }

        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        if (nums == null) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsDuplicate3(int[] nums) {
        if (nums == null) {
            return false;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * ����һ�����������һ������?k���ж��������Ƿ����������ͬ������?i?��?j��ʹ��?nums [i] = nums [j]��
     * ���� i �� j?�Ĳ�� ����ֵ ����Ϊ k��
     * <p>
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    /**
     * ����һ���������飬�ж��������Ƿ���������ͬ������ i �� j��ʹ��?nums [i] ��?nums [j]?�Ĳ�ľ���ֵ���Ϊ t��
     * ���� i �� j ֮��Ĳ�ľ���ֵ���Ϊ ?��
     * <p>
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    // ����ʱ������
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = -t; j <= t; j++) {
                if (map.containsKey(nums[i] + j) && Math.abs(i - map.get(nums[i] + j)) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
