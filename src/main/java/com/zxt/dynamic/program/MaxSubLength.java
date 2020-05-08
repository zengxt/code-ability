package com.zxt.dynamic.program;

/**
 * @Description: 子串是要求更严格的一种子序列，要求在母串中连续地出现。
 * @author： zxt
 * @time: 2018年10月4日 下午1:32:43
 */
public class MaxSubLength {
    public static void main(String[] args) {
        String str1 = "cnblogs";
        String str2 = "belong";
        System.out.println(getMaxSubLength(str1, str2));
    }

    public static int getMaxSubLength(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }

        // maxLength[i][j]记录 串x1x2...xi与y1y2⋯yj的公共子串的长度
        int[][] maxLength = new int[str1.length() + 1][str2.length() + 1];
        int result = 0;
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    maxLength[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
                    result = maxLength[i][j] > result ? maxLength[i][j] : result;
                } else {
                    // 子串要求连续，不等时即为0
                    maxLength[i][j] = 0;
                }
            }
        }

        return result;
    }
}
