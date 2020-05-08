package com.zxt.dynamic.program;

/**
 * @Description: 子序列要求字符出现的顺序与母序列的顺序一样即可，不需要保持连续
 * @author： zxt
 * @time: 2018年10月4日 上午10:51:52
 */
public class MaxLCS {
    public static void main(String[] args) {
        String str1 = "cnblogs";
        String str2 = "belong";

        System.out.println(getLCS(str1, str2));
    }

    /**
     * @param str1
     * @param str2
     * @return
     * @Description：假设Z=<z1,z2,⋯,zk>是X与Y的LCS， 我们观察到
     * 如果Xm=Yn，则Zk=Xm=Yn，有Zk−1是Xm−1与Yn−1的LCS；
     * 如果Xm≠Yn，则Zk是Xm与Yn−1的LCS，或者是Xm−1与Yn的LCS。
     * 因此，求解LCS的问题则变成递归求解的两个子问题。但是，上述的递归求解的办法中，重复的子问题多，效率低下。
     * 改进的办法——用空间换时间，用数组保存中间状态，方便后面的计算。这就是动态规划（DP)的核心思想了。
     */
    public static int getLCS(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }

        // maxLength[i][j]记录 串x1x2...xi与y1y2⋯yj的LCS长度
        int[][] maxLength = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    maxLength[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
                } else {
                    maxLength[i][j] = Math.max(maxLength[i - 1][j], maxLength[i][j - 1]);
                }
            }
        }

        return maxLength[str1.length()][str2.length()];
    }
}
