package com.zxt.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
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

        // 次数并不重要，也可以使用 set 集合
        Map<Integer, Integer> map = new HashMap<>();
        // Arrays.sort(nums); 排序可能提高效率
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
     * 给定一个整数数组和一个整数?k，判断数组中是否存在两个不同的索引?i?和?j，使得?nums [i] = nums [j]，
     * 并且 i 和 j?的差的 绝对值 至多为 k。
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
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得?nums [i] 和?nums [j]?的差的绝对值最大为 t，
     * 并且 i 和 j 之间的差的绝对值最大为 ?。
     * <p>
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    // 超出时间限制
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
