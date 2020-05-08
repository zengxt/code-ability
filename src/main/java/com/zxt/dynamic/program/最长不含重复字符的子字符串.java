package com.zxt.dynamic.program;

/**
 * @Description: 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。例如，在字符串中”arabcacfr”，最长非重复子字符串为”acfr”，长度为4。
 * @author： zxt
 * @time: 2018年7月14日 下午5:39:56
 */
public class 最长不含重复字符的子字符串 {
    // 由于题目规定字符串中只包含a-z的字符，所以定义一个长度为26的数组，保存字符的下标（上一次出现），相同字符的下标必然相同
    private static int[] position = new int[26];

    public static void main(String[] args) {
        System.out.println(getMaxSubStr("arabcacfr"));

        System.out.println(getMaxSubStr(""));

        System.out.println(getMaxSubStr("abcdef"));

        System.out.println(getMaxSubStr("aaaaaa"));
    }

    /**
     * @param str
     * @return
     * @Description：定义f(i)表示以第i个字符为结尾的不包含重复字符的子字符串的最长长度
     */
    public static int getMaxSubStr(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        // 首先默认所有的字符都还没有出现，所以它们的下标都为-1
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        // 最长不含重复字符的子字符串
        int maxLength = 0;
        // 以当前字符结尾的不含重复字符的子字符串长度
        int curLength = 0;

        for (int i = 0; i < str.length(); i++) {
            // 判断当前字符前一次出现的位置
            int preIndex = position[str.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > curLength) {
                // preIndex < 0，即-1，表示该字符前面没有出现过，所以以第i个字符结尾的不含重复字符的子字符串长度 为以第i-1个字符结尾的长度+1
                // i - preIndex > curLength，表示第i个字符出现过，但是出现在 以第i-1个字符结尾的子串长度距离的前面（即该子串不含该重复字符）
                ++curLength;

            } else {
                // 该字符出现过，且出现在以第i-1个字符结尾的子串里面
                if (curLength > maxLength) {
                    maxLength = curLength;
                }

                // 所以以第i个字符结尾的子串长度为当前位置到该重复字符前面出现的位置的距离
                curLength = i - preIndex;
            }

            // 记录当前字符出现的位置
            position[str.charAt(i) - 'a'] = i;
        }

        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }
}
