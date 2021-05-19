package com.zxt.leetcode;

/**
 * 给你两个单词?word1 和?word2，请你计算出将?word1?转换成?word2 所使用的最少操作数?。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros")); // 3
        System.out.println(minDistance("intention", "execution")); // 5
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }

        int m = word1.length();
        int n = word2.length();

        // dp[i][j]：返回 word1[0..i] 和 word2[0..j] 的最?编辑距离
        int[][] dp = new int[m + 1][n + 1];

        // 只要有一个字符串遍历完了，编辑距离再加上另一个的就好了
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前位置为 [i - 1][j - 1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 当前字符相同不用操作
                } else {
                    // 三种操作都遍历一下
                    dp[i][j] = min(
                            dp[i][j - 1] + 1,   // 插入，word1不用操作，word2比较下一个字符
                            dp[i - 1][j] + 1,   // 删除，word1删除，word2还是比较当前字符
                            dp[i - 1][j - 1] + 1    // 替换
                    );
                }
            }
        }

        return dp[m][n];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
