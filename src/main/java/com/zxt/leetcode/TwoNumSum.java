package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:给定一个整数数组 nums 和一个目标值 target， 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @Package com.zxt.leetcode
 * @Title: TwoNumSum.java
 * @author: zxt
 * @date: 2020年2月10日 上午12:05:16
 */
public class TwoNumSum {
    public static void main(String[] args) {
        int[] nums = {11, 7, 11, 2};
        int target = 9;
        System.out.println(getTwoNum(nums, target));
    }

    public static List<Integer> getTwoNum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> recode = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (recode.containsKey(complement)) {
                result.add(recode.get(complement));
                result.add(i);
                return result;
            }
            recode.put(nums[i], i);
        }

        return null;
    }
}
