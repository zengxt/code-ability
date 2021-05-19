package com.zxt.leetcode;

/**
 * ������������?word1 ��?word2������������?word1?ת����?word2 ��ʹ�õ����ٲ�����?��
 * <p>
 * ����Զ�һ�����ʽ����������ֲ�����
 * <p>
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
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

        // dp[i][j]������ word1[0..i] �� word2[0..j] ����?�༭����
        int[][] dp = new int[m + 1][n + 1];

        // ֻҪ��һ���ַ����������ˣ��༭�����ټ�����һ���ľͺ���
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // ��ǰλ��Ϊ [i - 1][j - 1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // ��ǰ�ַ���ͬ���ò���
                } else {
                    // ���ֲ���������һ��
                    dp[i][j] = min(
                            dp[i][j - 1] + 1,   // ���룬word1���ò�����word2�Ƚ���һ���ַ�
                            dp[i - 1][j] + 1,   // ɾ����word1ɾ����word2���ǱȽϵ�ǰ�ַ�
                            dp[i - 1][j - 1] + 1    // �滻
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
