package com.zxt.leetcode;

import java.util.stream.Stream;

/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串?是由数组中的所有元素 按顺序 连接形成的字符串。
 */
public class StringArrayIsEqual {
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(arrayStringsAreEqual2(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return Stream.of(word1).reduce(String::concat).orElse(null)
                .equals(Stream.of(word2).reduce(String::concat).orElse(null));
    }

    public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        // StringJoiner
        return String.join("", word1).equals(String.join("", word2));
    }
}
