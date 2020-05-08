package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:����һ���������� nums ��һ��Ŀ��ֵ target�� �����ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
 * @Package com.zxt.leetcode
 * @Title: TwoNumSum.java
 * @author: zxt
 * @date: 2020��2��10�� ����12:05:16
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
