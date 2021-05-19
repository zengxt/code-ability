package com.zxt.leetcode;

import java.util.stream.Stream;

/**
 * ���������ַ������� word1 �� word2 ��������������ʾ���ַ�����ͬ������ true �����򣬷��� false ��
 * <p>
 * �����ʾ���ַ���?���������е�����Ԫ�� ��˳�� �����γɵ��ַ�����
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
