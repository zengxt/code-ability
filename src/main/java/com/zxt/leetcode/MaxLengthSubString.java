package com.zxt.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 */
public class MaxLengthSubString {
    public static void main(String[] args) {
        MaxLengthSubString maxLengthSubString = new MaxLengthSubString();

        String str = "abcabcbb";
        System.out.println(maxLengthSubString.lengthOfLongestSubstring(str));

        String str1 = "pwwkew";
        System.out.println(maxLengthSubString.lengthOfLongestSubstring(str1));

        String str2 = "abba";
        System.out.println(maxLengthSubString.lengthOfLongestSubstring(str2));
    }

    public int lengthOfLongestSubstring(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }

        int maxLengthOfSubString;

        // �Ե�ǰ�ַ���β����Ӵ�����
        int[] maxLength = new int[str.length()];
        maxLength[0] = 1;
        maxLengthOfSubString = maxLength[0];

        for (int i = 1; i < str.length(); i++) {
            // �����ǰ����ַ���ǰ��û�г��ֹ����� maxLength[i] = maxLength[i-1] + 1
            // i - maxLength[i - 1]��maxLength[i - 1]��ʾ��ǰһ���ַ���β������Ӵ����ȣ�
            // ���жϼ��ϵ�ǰ�ַ����Ӵ��Ƿ��ظ�ʱ��ֻ��Ҫ����һ���Ӵ��Ŀ�ʼλ�ÿ�ʼ����
            int index = getIndexOfChar(str, i - maxLength[i - 1], i, str.charAt(i));
            if (index == -1) {
                maxLength[i] = maxLength[i - 1] + 1;
            } else {
                maxLength[i] = i - index;
            }

            if (maxLengthOfSubString < maxLength[i]) {
                maxLengthOfSubString = maxLength[i];
            }
        }

        return maxLengthOfSubString;
    }

    // ���� ch �� str��start -- end�� �е��±꣬���û�г��ֹ��򷵻� -1
    public int getIndexOfChar(String str, int start, int end, char ch) {
        for (int i = end - 1; i >= start; i--) {
            if (str.charAt(i) == ch) {
                return i;
            }
        }

        return -1;
    }

    // �������ڽⷨ

    /**
     * ʹ�� HashSet ���ַ��洢�ڵ�ǰ���� [i, j)����� j=i���С�
     * Ȼ���������Ҳ໬������ j����������� HashSet �У����ǻ�������� j��
     * ֱ�� str[j] �Ѿ������� HashSet �С���ʱ�������ҵ���û���ظ��ַ�������ַ������������� i ��ͷ��
     *
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring2(String str) {
        int maxLength = 0;

        int i = 0;
        int j = 0;
        int length = str.length();
        Set<Character> set = new HashSet<>();

        while (i < length && j < length) {
            // try to extend the range [i, j]
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(str.charAt(i++));
            }
        }

        return maxLength;
    }

    // �Ż��Ļ������ڽⷨ

    /**
     * ��� s[j] �� [i, j) ��Χ������ j' �ظ����ַ������ǲ���Ҫ������ i�����ǿ���ֱ������ [i��j']
     * ��Χ�ڵ�����Ԫ�أ����� i ��Ϊ j' + 1
     *
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring3(String str) {
        int maxLength = 0;

        int length = str.length();
        // current index of character
        Map<Character, Integer> map = new HashMap<>();

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < length; j++) {
            if (map.containsKey(str.charAt(j))) {
                i = Math.max(map.get(str.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(str.charAt(j), j + 1);
        }

        return maxLength;
    }

    /**
     * ������֪�����ַ����Ƚ�С��ʱ����ǿ�����һ������������Ϊֱ�ӷ��ʱ����滻 Map��
     * <p>
     * ���õı�������ʾ��
     * <p>
     * int [26] ������ĸ ��a�� - ��z�� �� ��A�� - ��Z��
     * int [128] ����ASCII��
     * int [256] ������չASCII��
     */
    public int lengthOfLongestSubstring4(String str) {
        int maxLength = 0;

        int length = str.length();
        // current index of character
        int[] index = new int[128];

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < length; j++) {
            i = Math.max(index[str.charAt(j)], i);
            maxLength = Math.max(maxLength, j - i + 1);
            index[str.charAt(j)] = j + 1;
        }

        return maxLength;
    }
}
