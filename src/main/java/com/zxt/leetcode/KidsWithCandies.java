package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个数组?candies?和一个整数?extraCandies?，其中?candies[i]?代表第 i 个孩子拥有的糖果数目。
 * <p>
 * 对每一个孩子，检查是否存在一种方案，将额外的?extraCandies?个糖果分配给孩子们之后，此孩子有 最多?的糖果。
 * 注意，允许有多个孩子同时拥有 最多?的糖果数目。
 * <p>
 */
public class KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        System.out.println(kidsWithCandies(candies, 3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        if (candies == null) {
            return result;
        }

        int maxCandies = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        // 如果 candies 是 integer类型的数组，可以使用如下的方式计算最大 或者 最小值
        // int max = Collections.max(Arrays.asList(candies));

        for (int i = 0; i < candies.length; i++) {
            result.add((candies[i] + extraCandies) >= maxCandies ? true : false);
        }

        return result;
    }
}
