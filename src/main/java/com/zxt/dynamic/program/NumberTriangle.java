package com.zxt.dynamic.program;

import java.util.Scanner;

/**
 * @Description: 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * 在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。路径上的每一步都只能往左下或
 * 右下走。只需要求出这个最大和即可，不必给出具体路径。 三角形的行数大于1小于等于100，数字为 0 - 99
 * <p>
 * 输入格式：
 * 5 //表示三角形的行数 接下来输入三角形
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 * <p>
 * 要求输出最大和
 * <p>
 * 接下来，我们来分析一下解题思路：首先，肯定得用二维数组来存放数字三角形，然后我们用D(r, j) 来表示第r行第 j 个数字(r,j从1开始算)
 * 我们用MaxSum(r, j)表示从D(r,j)到底边的各条路径中，最佳路径的数字之和。
 * 因此，此题的最终问题就变成了求 MaxSum(1,1)
 * @author： zxt
 * @time: 2018年3月25日 下午12:11:40
 */
public class NumberTriangle {

    private static int[][] maxSum;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] D = new int[n][n];
        maxSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                D[i][j] = scanner.nextInt();
                maxSum[i][j] = -1;
            }
        }

        System.out.println(maxSumDynamicOptimize(D, 0, 0));
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:递归方法求解
     */
    public static int maxSum(int[][] D, int i, int j) {
        // 已经到了最后一层，直接返回
        if (i == D.length - 1) {
            return D[i][j];
        }

        int x = maxSum(D, i + 1, j);
        int y = maxSum(D, i + 1, j + 1);

        return Math.max(x, y) + D[i][j];
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:记忆递归型的动态规划
     */
    public static int maxSumTable(int[][] D, int i, int j) {
        // 如果最优子问题的解已经计算过，则直接返回
        if (maxSum[i][j] != -1) {
            return maxSum[i][j];
        }

        if (i == D.length - 1) {
            maxSum[i][j] = D[i][j];

        } else {
            int x = maxSum(D, i + 1, j);
            int y = maxSum(D, i + 1, j + 1);
            maxSum[i][j] = Math.max(x, y) + D[i][j];
        }

        return maxSum[i][j];
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:动态规划求解
     */
    public static int maxSumDynamic(int[][] D, int i, int j) {
        // 使用一张表格来保存自底向上的最优子问题的解
        int[][] table = new int[D.length][D[0].length];

        // 给 table 的最后一行赋值
        for (int k = 0; k < D.length; k++) {
            table[D.length - 1][k] = D[D.length - 1][k];
        }

        // 自底向上计算各个子问题的解
        for (int p = D.length - 2; p >= 0; p--) {

            for (int q = 0; q <= p; q++) {
                table[p][q] = Math.max(table[p + 1][q], table[p + 1][q + 1]) + D[p][q];
            }
        }

        return table[0][0];
    }

    /**
     * @param D
     * @param i
     * @param j
     * @return
     * @Description:动态规划求解（空间优化解）
     */
    public static int maxSumDynamicOptimize(int[][] D, int i, int j) {
        // 使用一维数组来保存自底向上的最优子问题的解（只保存前一次的即可）
        int[] table = new int[D.length];

        // 给 table 初始化
        table = D[D.length - 1];

        // 自底向上计算各个子问题的解
        for (int p = D.length - 2; p >= 0; p--) {

            for (int q = 0; q <= p; q++) {
                table[q] = Math.max(table[q], table[q + 1]) + D[p][q];
            }
        }

        return table[0];
    }

}
