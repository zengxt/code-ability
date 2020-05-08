package com.zxt.dynamic.program;

/**
 * @Description: 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。
 * 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 思路：以12258为例，数字1可以单独翻译成b，后面剩余2258， 1也可以和2一起翻译成m，后面剩余258，因此可以用递归解法，存在子问题重复问题
 * <p>
 * 既然递归解存在子问题重复，那就从小问题开始自底向上，即从右自左翻译
 * @author： zxt
 * @time: 2018年8月20日 上午11:41:10
 */
public class 把数字翻译成字符串 {

    public static void main(String[] args) {
        int n = 122581231;
        System.out.println(getTranslationCount(n));
        System.out.println(getTranslationCount2(n));
    }

    /**
     * @param n
     * @return
     * @Description：递归实现：以12258为例，数字1可以单独翻译成b，后面剩余2258， 1也可以和2一起翻译成m，后面剩余258
     */
    public static int getTranslationCount(int n) {
        if (n < 0) {
            return 0;
        }

        return getTranslationCount("" + n, 0);
    }

    public static int getTranslationCount(String str, int start) {
        if (str == null || start > str.length()) {
            return 0;
        }

        if (str.length() == 0 || start == str.length() - 1 || start == str.length()) {
            return 1;
        }

        // 当前数字单独翻译
        int result1 = getTranslationCount(str, start + 1);
        // 判断是否可以和下一个位置组合翻译
        int result2 = 0;
        if (start + 1 <= str.length() - 1) {
            String temp = str.substring(start, start + 2);
            int value = Integer.valueOf(temp);
            if (10 <= value && value <= 25) {
                result2 = getTranslationCount(str, start + 2);
            }
        }

        return result1 + result2;
    }

    /**
     * @param n
     * @return
     * @Description：动态规划解法
     */
    public static int getTranslationCount2(int n) {
        if (n < 0) {
            return 0;
        }

        return getTranslationCount2("" + n);
    }

    public static int getTranslationCount2(String str) {
        int length = str.length();
        int[] counts = new int[length];
        int count = 0;

        for (int i = length - 1; i >= 0; i--) {
            count = 0;

            if (i == length - 1) {
                count = 1;
            } else {
                count = counts[i + 1];
            }

            if (i < length - 1) {
                int currDigit = str.charAt(i) - '0';
                int nextDigit = str.charAt(i + 1) - '0';
                int converted = currDigit * 10 + nextDigit;
                if (10 <= converted && converted <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }

        return counts[0];
    }

}
