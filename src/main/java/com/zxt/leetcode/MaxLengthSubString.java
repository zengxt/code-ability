package com.zxt.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
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

        // 以当前字符结尾的最长子串长度
        int[] maxLength = new int[str.length()];
        maxLength[0] = 1;
        maxLengthOfSubString = maxLength[0];

        for (int i = 1; i < str.length(); i++) {
            // 如果当前这个字符在前面没有出现过，则 maxLength[i] = maxLength[i-1] + 1
            // i - maxLength[i - 1]：maxLength[i - 1]表示以前一个字符结尾的最大子串长度，
            // 则判断加上当前字符的子串是否重复时，只需要从上一个子串的开始位置开始即可
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

    // 返回 ch 在 str【start -- end】 中的下标，如果没有出现过则返回 -1
    public int getIndexOfChar(String str, int start, int end, char ch) {
        for (int i = end - 1; i >= start; i--) {
            if (str.charAt(i) == ch) {
                return i;
            }
        }

        return -1;
    }

    // 滑动窗口解法

    /**
     * 使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j=i）中。
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
     * 直到 str[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。
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

    // 优化的滑动窗口解法

    /**
     * 如果 s[j] 在 [i, j) 范围内有与 j' 重复的字符，我们不需要逐渐增加 i。我们可以直接跳过 [i，j']
     * 范围内的所有元素，并将 i 变为 j' + 1
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
     * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
     * <p>
     * 常用的表如下所示：
     * <p>
     * int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
     * int [128] 用于ASCII码
     * int [256] 用于扩展ASCII码
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
