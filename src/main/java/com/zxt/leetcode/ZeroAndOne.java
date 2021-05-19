package com.zxt.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ����һ���������ַ������� strs ���������� m �� n ��
 * <p>
 * �����ҳ������� strs ������Ӽ��Ĵ�С�����Ӽ��� ��� �� m �� 0 �� n �� 1 ��
 * <p>
 * ��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ� ��
 * <p>
 * ���룺strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * �����4
 * ���ͣ������ 5 �� 0 �� 3 �� 1 ������Ӽ��� {"10","0001","1","0"} ����˴��� 4 ��
 * �����������⵫��С���Ӽ����� {"0001","1"} �� {"10","1","0"} ��{"111001"} ���������⣬��Ϊ���� 4 �� 1 ������ n ��ֵ 3 ��
 * <p>
 * ���룺strs = ["10", "0", "1"], m = 1, n = 1
 * �����2
 * ���ͣ������Ӽ��� {"0", "1"} �����Դ��� 2 ��
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

    // �����ڴ�����
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
                currn + indexOne, m, n); // ѡ���index����
        process(strs, index + 1, maxSub, currm,
                currn, m, n); // ��ѡ���index����
    }
}
