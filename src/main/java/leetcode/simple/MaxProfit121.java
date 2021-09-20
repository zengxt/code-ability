package leetcode.simple;

public class MaxProfit121 {
    public static void main(String[] args) {
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 第i天的最大收益
        int[][] dbTable = new int[prices.length][2];
        dbTable[0][0] = 0;
        dbTable[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dbTable[i][0] = Math.max(dbTable[i - 1][0], dbTable[i - 1][1] + prices[i]);
            dbTable[i][1] = Math.max(dbTable[i - 1][1], dbTable[i - 1][0] - prices[i]);
        }

        return dbTable[prices.length - 1][0];
    }

}
