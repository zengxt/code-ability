package com.zxt.dynamic.program;

/**
 * @Description: 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
 * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 * <p>
 * 金矿的信息：黄金量 / 所需工人数：500/5、200/3、300/4、350/3、400/5
 * @author： zxt
 * @time: 2018年6月30日 下午5:27:39
 */
public class 国王与金矿 {

    public static void main(String[] args) {
        int N = 5;
        int W = 10;
        int[] G = {400, 500, 200, 300, 350};
        int[] P = {5, 5, 3, 4, 3};

        // 递归法
        System.out.println(getMostGlod(G, P, N, W));

        // 动态规划，保存所有的子问题最优解
        System.out.println(getMostGlod(N, W, G, P));

        // 动态规划，保存前一行子问题的结果即可
        System.out.println(getMostGlod2(N, W, G, P));
    }

    /**
     * @param G
     * @param P
     * @param N
     * @param W
     * @return
     * @Description：使用递归的方式求解（时间复杂度较高）
     */
    public static int getMostGlod(int[] G, int[] P, int N, int W) {
        if (N <= 1 && W < P[0]) {
            return 0;
        }
        if (N == 1 && W >= P[0]) {
            return G[0];
        }

        if (N > 1 && W < P[N - 1]) {
            return getMostGlod(G, P, N - 1, W);
        }

        return Math.max(getMostGlod(G, P, N - 1, W), getMostGlod(G, P, N - 1, W - P[N - 1]) + G[N - 1]);
    }

    /**
     * @param N：金矿数
     * @param W：工人数
     * @param G：每座金矿的黄金量
     * @param P：每座金矿需要的工人
     * @return
     * @Description：按照自底向上的策略，填充一个二维表，表中元素表示n座金矿w个人挖的最大收益
     */
    public static int getMostGlod(int N, int W, int[] G, int[] P) {

        int[][] result = new int[N][W + 1];

        // 初始化时，表示一座金矿i个工人的最大收益
        for (int i = 1; i <= W; i++) {
            // 工人数不够挖第一座金矿
            if (i < P[0]) {
                result[0][i] = 0;
            } else {
                result[0][i] = G[0];
            }
        }

        // 自底向上，逐步递推。外层循环是金矿数量，内层循环是工人数
        for (int i = 1; i < N; i++) {

            for (int j = 1; j <= W; j++) {
                // 人不够肯定不挖
                if (j < P[i]) {
                    result[i][j] = result[i - 1][j];

                } else {
                    // 人够了，挖不挖第i座金矿
                    result[i][j] = Math.max(result[i - 1][j], (result[i - 1][j - P[i]] + G[i]));
                }
            }
        }

        return result[N - 1][W];
    }

    /**
     * @param N：金矿数
     * @param W：工人数
     * @param G：每座金矿的黄金量
     * @param P：每座金矿需要的工人
     * @return
     * @Description：实际操作中，并不需要完整的表，只需要知道前一行即可
     */
    public static int getMostGlod2(int N, int W, int[] G, int[] P) {

        int[] result = new int[W + 1];
        int[] preResult = new int[W + 1];

        // 初始化时，表示一座金矿i个工人的最大收益
        for (int j = 1; j <= W; j++) {
            // 工人数不够挖第一座金矿
            if (j < P[0]) {
                preResult[j] = 0;
            } else {
                preResult[j] = G[0];
            }
        }

        // 自底向上，逐步递推。外层循环是金矿数量，内层循环是工人数
        for (int i = 1; i < N; i++) {

            for (int j = 1; j <= W; j++) {
                // 人不够肯定不挖
                if (j < P[i]) {
                    result[j] = preResult[j];

                } else {
                    // 人够了，挖不挖第i座金矿
                    result[j] = Math.max(preResult[j], (preResult[j - P[i]] + G[i]));
                }
            }

            // 特别注意：Java中数组是一个对象，如果直接等于的话，preResult和result其实是指向同一个位置，根本无法保留上一次的结果
            // preResult = result;
            System.arraycopy(result, 0, preResult, 0, preResult.length);
        }

        return result[W];
    }
}
