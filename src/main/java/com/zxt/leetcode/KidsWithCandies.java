package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������?candies?��һ������?extraCandies?������?candies[i]?����� i ������ӵ�е��ǹ���Ŀ��
 * <p>
 * ��ÿһ�����ӣ�����Ƿ����һ�ַ������������?extraCandies?���ǹ������������֮�󣬴˺����� ���?���ǹ���
 * ע�⣬�����ж������ͬʱӵ�� ���?���ǹ���Ŀ��
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

        // ��� candies �� integer���͵����飬����ʹ�����µķ�ʽ������� ���� ��Сֵ
        // int max = Collections.max(Arrays.asList(candies));

        for (int i = 0; i < candies.length; i++) {
            result.add((candies[i] + extraCandies) >= maxCandies ? true : false);
        }

        return result;
    }
}
