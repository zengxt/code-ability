package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 */
public class ZeroAndOne {
    private static List<Integer> maxSubStrs;

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"00", "000"}, 1, 10));
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 4, 3));
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        maxSubStrs = new ArrayList<>();
        process(strs, 0, 0, 0, 0, m, n);
        Collections.sort(maxSubStrs);
        return maxSubStrs.get(maxSubStrs.size() - 1);
    }

    // 超出内存限制
    private static void process(String[] strs, int index, int maxSub, int currm, int currn, int m, int n) {
        if (index > strs.length || currm > m || currn > n) {
            return;
        }

        maxSubStrs.add(maxSub);
        if (index == strs.length && currm <= m && currn <= n) {
            return;
        }

        int indexZero = 0;
        int indexOne = 0;
        for (char ch : strs[index].toCharArray()) {
            indexZero += ch == '0' ? 1 : 0;
            indexOne += ch == '1' ? 1 : 0;
        }

        process(strs, index + 1, maxSub + 1, currm + indexZero,
                currn + indexOne, m, n); // 选择第index个串
        process(strs, index + 1, maxSub, currm,
                currn, m, n); // 不选择第index个串
    }
}
